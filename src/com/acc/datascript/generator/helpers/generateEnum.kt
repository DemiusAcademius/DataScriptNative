package com.acc.datascript.generator.helpers

import com.acc.datascript.generator.*
import com.acc.datascript.generator.jvm.JvmVisibility
import com.acc.datascript.lang.extensions.literalValue
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsEnumDefinition
import com.acc.datascript.lang.types.inferType
import com.acc.datascript.resources.ColumnType
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

/**
 * Created by demius on 04.01.2016.
 */

public fun generateEnum(generator: Generator, enumDefinition: DsEnumDefinition) {
    val name = enumDefinition.name ?: return
    val type = enumDefinition.inferType?.sqlType ?: return

    val javaDecl = type.javaDeclaration()
    val partExpr = type.partOfExpression()

    generator.generateEnum(name) { clazz ->

        clazz.additionalImports += Pair(typeRef("com.acc.server.utils.EnumsHelper.entriesToMap"), true)
        clazz.additionalImports += Pair(typeRef("com.acc.server.utils.EnumsHelper.entry"), true)
        clazz.additionalImports += Pair(typeRef(java.util.Arrays::class.java), false)

        enumDefinition.enumElementList.forEach {
            val value = it.sqlExpression.literalValue
            clazz.enumLiteral(it.name, value)
        }

        val defaultName = enumDefinition.enumElementList.firstOrNull { it.isDefault != null }?.name ?: "null"

        clazz.field("value", typeRef(javaDecl), JvmVisibility.PRIVATE)

        clazz.constructor {
            it.parameter("value", typeRef(javaDecl))
            it.body = "this.value = value;"
        }

        val constType = if (type == ColumnType.INT) typeRef("Integer") else stringTypeRef

        clazz.field("constants",typeRef(java.util.Map::class.java, false, constType, typeRef(name)), JvmVisibility.PRIVATE) {
            it.static = true
            it.initializer = "Arrays.stream($name.values()).map(e -> entry(e.value, e)).collect(entriesToMap())"
        }

        clazz.method("setValue", voidTypeRef, JvmVisibility.PUBLIC) {
            it.parameter("st", typeRef(PreparedStatement::class.java))
            it.parameter("index", intTypeRef)
            it.exceptions += typeRef(SQLException::class.java)
            it.body = "st.set$partExpr(index, this.value);"
        }

        clazz.method("select", typeRef(name), JvmVisibility.PUBLIC) {
            it.static = true
            it.parameter("rs", typeRef(ResultSet::class.java))
            it.parameter("index", intTypeRef)
            it.exceptions += typeRef(SQLException::class.java)
            it.body = "return constants.getOrDefault(rs.get$partExpr(index),$defaultName);"
        }
    }
}
