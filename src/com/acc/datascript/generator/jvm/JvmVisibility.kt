package com.acc.datascript.generator.jvm

/**
 * Created by demius on 04.01.2016.
 */
public enum class JvmVisibility {
    PUBLIC, PRIVATE, PROTECTED, DEFAULT;

    fun generate(): CharSequence =
        when (this) {
            PUBLIC -> "public "
            PRIVATE -> "private "
            DEFAULT -> ""
            PROTECTED -> "protected "
        }

}