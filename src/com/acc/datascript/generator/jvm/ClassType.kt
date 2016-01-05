package com.acc.datascript.generator.jvm

/**
 * Created by demius on 04.01.2016.
 */
enum class ClassType {
    CLASS, ENUM, INTERFACE;

    fun generate(): CharSequence = this.name.toLowerCase()
}