package com.acc.datascript.generator.jvm

import com.acc.datascript.utils.join
import com.intellij.psi.util.QualifiedName
import java.util.*

/**
 * Created by demius on 04.01.2016.
 */
class JvmAnnotationRef(val type: QualifiedName, vararg val typeArgs: String) {

    constructor(type: String, vararg typeArgs: String): this(QualifiedName.fromDottedString(type), *typeArgs)

    fun generate(): CharSequence =
            buildString {
                append("@${type.lastComponent}")
                join(typeArgs, this, ",", before = "(", after = ")")
            }


    fun imports(): Set<QualifiedName> {
        var set = TreeSet<QualifiedName>()
        if (type.componentCount > 1) set.add(type)
        return set
    }

}