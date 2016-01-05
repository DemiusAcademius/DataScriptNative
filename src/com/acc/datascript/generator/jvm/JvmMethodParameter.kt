package com.acc.datascript.generator.jvm

import com.acc.datascript.utils.join
import com.intellij.psi.util.QualifiedName
import java.util.*

/**
 * Created by demius on 04.01.2016.
 */
class JvmMethodParameter(val name: String, val type: JvmTypeRef, vararg val annotations: JvmAnnotationRef) {

    fun imports(): Set<QualifiedName> {
        var set = TreeSet<QualifiedName>()
        set.addAll(type.imports())
        for(i in annotations) set.addAll(i.imports())
        return set
    }

    fun generate(): CharSequence =
            buildString {
                join(annotations, this, " ", after = " ") { append(it.generate()) }
                append("${type.generate()} $name")
            }

}