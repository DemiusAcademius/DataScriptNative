package com.acc.datascript.generator.jvm

import com.acc.datascript.utils.join
import com.intellij.psi.util.QualifiedName
import java.util.*

/**
 * Created by demius on 04.01.2016.
 */
class JvmMethod(val name: String, val type: JvmTypeRef, visibility: JvmVisibility = JvmVisibility.DEFAULT): JvmClassMember(visibility) {

    private val parameters = ArrayList<JvmMethodParameter>()

    public var static: Boolean = false
    var body: String? = null
    val exceptions = ArrayList<JvmTypeRef>()
    public val annotations = ArrayList<JvmAnnotationRef>()
    var declaringType: String? = null

    fun parameter(name: String, type: JvmTypeRef, vararg annotations: JvmAnnotationRef) {
        parameters += JvmMethodParameter(name, type, *annotations)
    }

    override fun imports(): Set<QualifiedName> {
        var set = TreeSet<QualifiedName>()
        set.addAll(type.imports())
        for(i in annotations) set.addAll(i.imports())
        for(i in exceptions) set.addAll(i.imports())
        for(i in parameters) set.addAll(i.imports())
        return set
    }

    override fun generate(): CharSequence =
            buildString {
                append(visibility.generate())
                if (static) append("static ")
                if (declaringType != null) append("<$declaringType> ")
                append("${type.generate()} $name")
                append("(")
                join(parameters, this, ",") { append(it.generate()) }
                append(")")
                join(exceptions, this, ",", before = " throws ") { append(it.generate()) }
                if (body == null) append(";")
                else append(" {\n   $body\n}")
            }

}