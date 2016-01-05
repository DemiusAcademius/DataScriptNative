package com.acc.datascript.generator

import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DataScriptFile
import com.acc.datascript.lang.psi.DsNamespaceSection
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil

/**
 * Created by demius on 31.12.2015.
 */
class GenerateAction: AnAction() {

    override fun update(e: AnActionEvent) {
        val file = LangDataKeys.PSI_FILE.getData(e.dataContext)
        val enabled =
                if (file !is DataScriptFile) false
                else {
                    val namespace = PsiTreeUtil.findChildOfType(file, DsNamespaceSection::class.java)
                    if (namespace != null) namespace.name != null else false
                }
        e.presentation.isEnabledAndVisible = enabled
    }

    override fun actionPerformed(e: AnActionEvent) {
        val file = LangDataKeys.PSI_FILE.getData(e.dataContext)
        if (file !is DataScriptFile) return

        val project = file.project

        PsiDocumentManager.getInstance(project).commitAllDocuments()
        FileDocumentManager.getInstance().saveAllDocuments()

        val namespace = PsiTreeUtil.findChildOfType(file, DsNamespaceSection::class.java)
        if (namespace != null) {
            val namespaceName = namespace.name
            if (namespaceName != null) {

                ApplicationManager.getApplication().runWriteAction {
                    Generator(file, namespace, namespaceName).generate()
                }

            }
        }
    }
}