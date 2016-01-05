package com.acc.datascript.generator.jvm

import com.acc.datascript.utils.join
import com.intellij.psi.util.QualifiedName
import java.util.*

/**
 * Created by demius on 04.01.2016.
 */
class JvmClass(val name: String, val type: ClassType = ClassType.CLASS,
               val namespace: QualifiedName? = null, visibility: JvmVisibility = JvmVisibility.DEFAULT) : JvmClassMember(visibility) {

    public var static: Boolean = false

    val members = ArrayList<JvmClassMember>()

    private val javaLangName = QualifiedName.fromComponents("java","lang")

    val typeArgs = ArrayList<JvmTypeRef>()
    val annotations = ArrayList<JvmAnnotationRef>()
    val additionalImports = ArrayList<Pair<JvmTypeRef,Boolean>>()

    var implements: JvmTypeRef? = null
    var extends: JvmTypeRef? = null

    fun constructor(visibility: JvmVisibility = JvmVisibility.DEFAULT, consumer: ((JvmConstructor) -> Unit)? = null) {
        val m = JvmConstructor(this.name, visibility)
        consumer?.invoke(m)
        members += m
    }

    fun method(name: String, type: JvmTypeRef, visibility: JvmVisibility = JvmVisibility.DEFAULT, consumer: ((JvmMethod) -> Unit)? = null) {
        val m = JvmMethod(name, type, visibility)
        consumer?.invoke(m)
        members += m
    }

    fun field(name: String, type: JvmTypeRef, visibility: JvmVisibility = JvmVisibility.DEFAULT, consumer: ((JvmField) -> Unit)? = null) {
        val f = JvmField(name, type, visibility)
        consumer?.invoke(f)
        members += f
    }

    fun enumLiteral(name: String, value: String? = null) {
        members += JvmEnumLiteral(name, value)
    }

    override fun imports(): Set<QualifiedName> {
        var imports = TreeSet<QualifiedName>()
        for(m in this.members)
            imports.addAll(m.imports())

        for(i in this.annotations) imports.addAll(i.imports())

        for(i in additionalImports.filter { !it.second }.map { it.first }) imports.addAll(i.imports())

        if (implements != null) {
            imports.addAll((implements as JvmTypeRef).imports())
        } else if (extends != null) {
            imports.addAll((extends as JvmTypeRef).imports())
        }
        return imports
    }

    override fun generate(): CharSequence  =
            buildString {
                if (namespace != null) {
                    append("package $namespace;\n\n")
                    imports().filter { !(it.matchesPrefix(javaLangName) && it.matchesPrefix(namespace)) }.forEach {
                        append("import $it;\n")
                    }
                    additionalImports.filter { it.second }.map { it.first }.forEach {
                        append("import static ${it.type};\n")
                    }
                }
                for (a in annotations) append("${a.generate()}\n")

                append(visibility.generate())

                append("${type.generate()} $name")
                join(typeArgs, this, ",", before = "<", after = ">") { append(it.generate()) }

                if (extends != null) append(" extends ${(extends as JvmTypeRef).generate()}")
                if (implements != null) append(" implements ${(implements as JvmTypeRef).generate()}")

                append(" {\n")

                join(members.filter { it is JvmEnumLiteral }, this, ",", after = ";") { append(it.generate()) }
                join(members.filter { it !is JvmEnumLiteral }, this) { append(it.generate()) }

                append("\n}")
            }
}