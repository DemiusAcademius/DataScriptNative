package com.acc.datascript.generator.helpers

import com.acc.datascript.generator.Generator
import com.acc.datascript.generator.jvm.JvmClass
import com.acc.datascript.generator.jvm.JvmVisibility
import com.acc.datascript.generator.longTypeRef
import com.acc.datascript.generator.typeRef
import com.acc.datascript.lang.extensions.cardinality
import com.acc.datascript.lang.extensions.findCallable
import com.acc.datascript.lang.names.methodName
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.*
import com.acc.datascript.lang.types.DataScriptType
import com.acc.datascript.lang.types.inferType
import com.acc.datascript.lang.types.nullType
import com.acc.datascript.utils.join
import java.sql.Connection
import java.sql.SQLException

/**
 * Created by demius on 05.01.2016.
 */

public fun generateClass(generator: Generator, classDefinition: DsClassDefinition) {
    val name = classDefinition.name ?: return

    generator.generateClass(name) { clazz ->
        classDefinition.classElementList.forEach {
            when (it) {
                is DsSequenceGenerator -> generateSequence(generator, clazz, it)
                is DsCallGenerator -> generateCall(generator, clazz, it)
                is DsQueryGenerator -> generateQuery(generator, clazz, it)
            }
        }
    }

}

private fun generateSequence(generator: Generator, clazz: JvmClass, sequenceGenerator: DsSequenceGenerator) {
    val methodName = sequenceGenerator.methodName ?: return

    clazz.additionalImports += Pair(typeRef("com.acc.server.runtime.SqlRuntime.fetchSequence"), true)
    val sequence = sequenceGenerator.qualifiedName.text

    clazz.method(methodName, longTypeRef, JvmVisibility.PUBLIC) {
        it.static = true
        it.exceptions += typeRef(SQLException::class.java)
        it.parameter("connection",typeRef(Connection::class.java))
        it.body = "return fetchSequence(connection,\"$sequence\");"
    }
}

private fun generateCall(generator: Generator, clazz: JvmClass, callGenerator: DsCallGenerator) {
    val methodName = callGenerator.methodName ?: return

    val callable = findCallable(callGenerator.qualifiedName, callGenerator.cardinality) ?: return

    val parameterList = when (callable) {
        is DsSqlFunctionCallable -> callable.sqlCallableParametersList?.sqlCallableParameterList
        is DsSqlProcedureCallable -> callable.sqlCallableParametersList?.sqlCallableParameterList
        else -> null
    } ?: emptyList<DsSqlCallableParameter>()

    val inParams = parameterList.filter { it.outModifier == null  }
    val outParams = parameterList.filter { it.outModifier != null  }
    val inParamsSize = inParams.size
    val outParamsSize = outParams.size

    val helperName = if (callable is DsSqlFunctionCallable || outParamsSize > 0) "Function" else "Procedure"

    clazz.additionalImports += Pair(typeRef("com.acc.server.runtime.SqlRuntime.call$helperName"), true)

    val sql = buildString {
        append("final String sql = \"{ ? = call ${callGenerator.qualifiedName.text}(")
        join(parameterList, this, ",") {append("?")}
        append(") }\"")
    }

    val preparator =
        if (inParamsSize == 0 && outParamsSize == 0) "null"
        else buildString {
            append("st -> {\n")
            val offset = if (callable is DsSqlFunctionCallable) 2 else 1
            inParams.forEachIndexed { i, parameter -> append(sqlSetter(parameter, i + offset,"")) }
            outParams.forEachIndexed { i, parameter -> append(registerer(parameter, i + 1 + inParamsSize)) }
            append("}")
        }

    clazz.method(methodName, longTypeRef, JvmVisibility.PUBLIC) {
        it.static = true
        it.exceptions += typeRef(SQLException::class.java)
        it.parameter("connection",typeRef(Connection::class.java))
        it.body = "$sql;\n return call$helperName(connection,sql,x,$preparator);"
    }
}

private fun registerer(p: DsSqlCallableParameter, index: Int) =
    "st.registerOutParameter($index, Types.${p.dataType.inferType?.sqlType?.javaSqlType()});\n"


private fun sqlSetter(p: DsSqlCallableParameter, index: Int, source: String) =
    sqlSetter(p.dataType.inferType ?: nullType, p.name.sqlToJava(), index, source)

private fun sqlGetter(col: Pair<String, DataScriptType>, index: Int) =
    sqlGetter(col.second, col.first.sqlToJava(), index, "this", false)



fun generateQuery(generator: Generator, clazz: JvmClass, queryGenerator: DsQueryGenerator) {

}