package com.acc.datascript.generator.jvm

import com.intellij.psi.util.QualifiedName

/**
 * Created by demius on 04.01.2016.
 */
class JvmEnumLiteral(val name: String, val value: String? = null): JvmClassMember(JvmVisibility.PUBLIC) {

    override fun generate(): CharSequence = name + if (value != null) "($value)" else ""

    override fun imports(): Set<QualifiedName> = emptySet()
}