package com.acc.datascript.generator

import com.acc.datascript.generator.helpers.generateClass
import com.acc.datascript.generator.helpers.generateEnum
import com.acc.datascript.generator.jvm.*
import com.acc.datascript.lang.DataScriptFileType
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DataScriptFile
import com.acc.datascript.lang.psi.DsEnumDefinition
import com.acc.datascript.lang.psi.DsNamespaceSection
import com.intellij.ide.highlighter.JavaFileType
import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.application.Result
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.psi.util.QualifiedName
import com.intellij.util.ObjectUtils
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import java.nio.charset.Charset

/**
 * Created by demius on 31.12.2015.
 */

public fun parameter(name: String, type: JvmTypeRef, vararg annotations: JvmAnnotationRef): JvmMethodParameter =
        JvmMethodParameter(name, type, *annotations)

public fun typeRef(type: QualifiedName, wildcard: Boolean = false, vararg typeArgs: JvmTypeRef) =
        JvmTypeRef(type, wildcard, *typeArgs)

public fun typeRef(type: Class<out Any>, wildcard: Boolean = false, vararg typeArgs: JvmTypeRef) =
        JvmTypeRef(QualifiedName.fromDottedString(type.typeName), wildcard, *typeArgs)

public fun typeRef(type: String, wildcard: Boolean = false, vararg typeArgs: JvmTypeRef) =
        JvmTypeRef(QualifiedName.fromDottedString(type), wildcard, *typeArgs)

public fun annotationRef(type: QualifiedName, vararg typeArgs: String) =
        JvmAnnotationRef(type, *typeArgs)

public fun annotationRef(type: Class<out Any>, vararg typeArgs: String) =
        JvmAnnotationRef(QualifiedName.fromDottedString(type.typeName), *typeArgs)

public fun annotationRef(type: String, vararg typeArgs: String) =
        JvmAnnotationRef(QualifiedName.fromDottedString(type), *typeArgs)

public val voidTypeRef = typeRef("void")
public val intTypeRef = typeRef("int")
public val longTypeRef = typeRef("long")
public val stringTypeRef = typeRef("String")

public class Generator(val sourceFile: DataScriptFile, val namespace: DsNamespaceSection, val namespaceName: String) {
    private val project = sourceFile.project
    private val psiManager = PsiManager.getInstance(project)

    private val rootManager = ProjectRootManager.getInstance(project)
    private val fileIndex = ProjectFileIndex.SERVICE.getInstance(project)
    private val codeStyleManager = CodeStyleManager.getInstance(project)

    private val targetDirectory = prepareTargetDirectory(sourceFile.virtualFile, namespaceName)
    private val psiDirectory = psiManager.findDirectory(targetDirectory)

    public fun generate() {
        if (psiDirectory != null) {
            targetDirectory.charset = Charset.forName("UTF-8")

            namespace.enumDefinitionList.forEach { generateEnum(this, it) }
            namespace.classDefinitionList.forEach { generateClass(this, it) }
        }
    }

    public fun generateClass(name: String, visibility: JvmVisibility = JvmVisibility.DEFAULT, consumer: (JvmClass) -> Unit) {
        generateComponent(name, ClassType.CLASS, visibility, consumer)
    }

    public fun generateInterface(name: String, consumer: (JvmClass) -> Unit) {
        generateComponent(name, ClassType.INTERFACE, JvmVisibility.PUBLIC, consumer)
    }

    public fun generateEnum(name: String, visibility: JvmVisibility = JvmVisibility.PUBLIC, consumer: (JvmClass) -> Unit) {
        generateComponent(name, ClassType.ENUM, visibility, consumer)
    }

    fun generateComponent(name: String, type: ClassType, visibility: JvmVisibility, consumer: (JvmClass) -> Unit) {
        val c = JvmClass(name, type, QualifiedName.fromDottedString(namespaceName),visibility)
        consumer.invoke(c)
        val javaFile = PsiFileFactory.getInstance(project).
                createFileFromText(name + ".java", JavaFileType.INSTANCE, c.generate())
        codeStyleManager.reformat(javaFile)
        psiDirectory!!.add(javaFile.containingFile)
    }

    private fun prepareTargetDirectory(sourceFile: VirtualFile,
                                       targetPackage: String): VirtualFile {
        val hasPackage = StringUtil.isNotEmpty(targetPackage)
        val contentRoots = rootManager.contentRoots

        val virtualRoot =
                if (fileIndex.isInContent(sourceFile))
                    fileIndex.getContentRootForFile(sourceFile)
                else contentRoots.firstOrNull()

        if (virtualRoot == null) {
            fail(project, sourceFile, "Unable to guess target source root")
            throw ProcessCanceledException()
        }
        try {
            val newGenRoot = !fileIndex.isInSourceContent(virtualRoot)
            val relativePath =
                    (
                            if (hasPackage && newGenRoot) "gen." + targetPackage
                            else if (hasPackage) targetPackage
                            else if (newGenRoot) "gen"
                            else "").replace('.', '/')

            if (relativePath.isEmpty()) {
                return virtualRoot
            } else {
                val result = object : WriteAction<VirtualFile>() {
                    @Throws(Throwable::class)
                    override fun run(result: Result<VirtualFile>) {
                        result.setResult(VfsUtil.createDirectoryIfMissing(virtualRoot, relativePath))
                    }
                }.execute().throwException().resultObject

                val file = VfsUtil.virtualToIoFile(result)
                if (file.deleteRecursively()) {
                    file.mkdir()
                }

                VfsUtil.markDirtyAndRefresh(false, true, true, result)
                return result
            }
        } catch (ex: ProcessCanceledException) {
            throw ex
        } catch (ex: Exception) {
            fail(project, sourceFile, ex.message!!)
            throw ProcessCanceledException()
        }

    }

    internal fun fail(project: Project, sourceFile: VirtualFile, message: String) {
        Notifications.Bus.notify(Notification(
                "datascript.Generate.Script",
                sourceFile.name, message,
                NotificationType.ERROR), project)
        throw ProcessCanceledException()
    }


}

