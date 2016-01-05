package com.acc.datascript.generator.jvm

import com.intellij.psi.util.QualifiedName

/**
 * Created by demius on 04.01.2016.
 */
public abstract class JvmClassMember(val visibility: JvmVisibility) {
    abstract fun imports(): Set<QualifiedName>
    abstract fun generate(): CharSequence
}