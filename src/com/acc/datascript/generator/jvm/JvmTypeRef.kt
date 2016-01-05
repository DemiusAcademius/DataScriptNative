package com.acc.datascript.generator.jvm

import com.acc.datascript.utils.join
import com.intellij.psi.util.QualifiedName
import java.util.*

/**
 * Created by demius on 04.01.2016.
 */
class JvmTypeRef(val type: QualifiedName, val wildcard: Boolean = false, vararg val typeArgs: JvmTypeRef) {

    constructor(type: String, wildcard: Boolean = false, vararg typeArgs: JvmTypeRef):
        this(QualifiedName.fromDottedString(type), wildcard, *typeArgs)

    fun generate(): CharSequence =
        buildString {
            if (wildcard) append("? extends ")
            append(type.lastComponent)
            join(typeArgs, this, ",", before = "<", after = ">") { append(it.generate()) }
        }

    fun imports(): Set<QualifiedName> {
        var set = TreeSet<QualifiedName>()

        if (type.componentCount > 1) set.add(type)
        if (typeArgs != null)
            for(i in typeArgs) set.addAll(i.imports())

        return set
    }

}