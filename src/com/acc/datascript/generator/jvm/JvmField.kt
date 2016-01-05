package com.acc.datascript.generator.jvm

import com.intellij.psi.util.QualifiedName
import java.util.*

/**
 * Created by demius on 04.01.2016.
 */
public class JvmField(val name: String, val type: JvmTypeRef, visibility: JvmVisibility = JvmVisibility.DEFAULT): JvmClassMember(visibility) {

    public var static: Boolean = false
    public var final: Boolean = false
    public var initializer: String? = null
    public val annotations = ArrayList<JvmAnnotationRef>()

    override fun imports(): Set<QualifiedName> {
        var set = TreeSet<QualifiedName>()
        set.addAll(type.imports())
        for(i in annotations) set.addAll(i.imports())
        return set
    }

    override fun generate(): CharSequence =
            buildString {
                for (a in annotations) append("${a.generate()}\n")
                append(visibility.generate())
                if (static) append("static ")
                if (final) append("final ")
                append("${type.generate()} $name")
                if (initializer != null) append(" = $initializer")
                append(";")
            }
}
