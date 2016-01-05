package com.acc.datascript.lang.names

import com.acc.datascript.lang.extensions.aggregateFunctionNames
import com.acc.datascript.lang.extensions.cardinality
import com.acc.datascript.lang.extensions.findColumnOrEnumLiteral
import com.acc.datascript.lang.extensions.getSqlParameter
import com.acc.datascript.lang.psi.*
import com.intellij.psi.tree.TokenSet

/**
 * Created by demius on 31.12.2015.
 */

public val DsNamespaceSection.name: String?
    get() = this.qualifiedName?.text

public val DsSqlFunctionExpression.name: String?
    get() = this.qualifiedName.text.toLowerCase()

public val DsSchemaSection.name: String?
    get() = this.id?.text?.toUpperCase()

public val DsSequenceDefinition.name: String?
    get() = this.id?.text?.toUpperCase()

public val DsViewDefinition.name: String?
    get() = this.id?.text?.toUpperCase()

public val DsTableDefinition.name: String?
    get() = this.id?.text?.toUpperCase()

public val DsColumn.name: String?
    get() = this.id.text?.toUpperCase()

public val DsEnumDefinition.name: String?
    get() = this.id?.text

public val DsPackageDefinition.name: String?
    get() = this.id?.text

public val DsSqlCallable.name: String?
    get() = when (this) {
        is DsSqlFunctionCallable -> this.id.text
        is DsSqlProcedureCallable -> this.id.text
        else -> null
    }?.toUpperCase()

public val DsEnumElement.name: String
    get() = this.id.text

public val DsClassDefinition.name: String?
    get() = this.id?.text

public val DsQueryGenerator.name: String?
    get() = this.id.text

public val DsEntityQueryGenerator.name: String?
    get() = this.id.text

public val DsQueryParameter.name: String
    get() = this.id.text

public val DsEntitySelector.name: String?
    get() {
        val aliasClause = this.aliasClause
        return if (aliasClause != null) aliasClause.id.text else this.qualifiedName?.text
    }

public val DsBatchFunction.name: String?
    get() {
        val node = this.node
        val un = node.findChildByType(DataScriptTypes.UPDATE)
        val n =
                if (un != null) "update"
                else {
                    val ins = node.findChildByType(DataScriptTypes.INSERT)
                    if (ins != null) "insert"
                    else "delete"
                }
        return n
    }

public val DsSelectDerivedColumn.name: String?
    get() {
        val aliasClause = this.aliasClause
        return if (aliasClause != null) aliasClause.id.text.toUpperCase() else this.sqlExpression.name
    }

public val DsSqlExpression.name: String?
    get() = when (this) {
        is DsSqlCountAllFunction -> "COUNT_ALL"
        is DsSqlNotExpression -> this.sqlExpression.name
        is DsSqlColumnRefExpression -> {
            val colOrEnum = findColumnOrEnumLiteral(this)
            if (colOrEnum != null)
                when (colOrEnum) {
                    is DsColumn -> colOrEnum.name
                    is DsEnumElement -> colOrEnum.name
                    else -> null
                }
            else null

        }
        is DsSqlParameterExpression -> getSqlParameter(this)?.name
        is DsSqlFunctionExpression -> {
            val n = this.name
            if (aggregateFunctionNames.containsRaw(n)) {
                val subn = this.sqlExpressionList.firstOrNull()?.name
                if (subn == null) n?.toUpperCase() else n?.toUpperCase() + "_" + subn
            } else n?.toUpperCase()
        }
        else -> null
    }


public val DsQualifiedName.segments: List<String>
    get() = this.node.getChildren(TokenSet.create(DataScriptTypes.ID)).map { it.text }

public val DsEntityDefinition.className: String?
    get() = this.qualifiedName?.segments?.map { it.capitalize() }?.joinToString()

public val DsCallGenerator.methodName: String?
    get() {
        val n = "call" + this.qualifiedName.segments.last().prepare()
        //val n = this.qualifiedName.segments.mapIndexed { i, s -> if (i == 0) s.toLowerCase() else s.capitalize() }.joinToString("")
        val i = this.cardinality
        return if (i == null) n else n + "_$i"
    }

public val DsSequenceGenerator.methodName: String?
    get() {
        val segments = this.qualifiedName.segments
        val sequenceName = segments.last().prepare()
        val seqShortName = segments.last().prepareSkipFirst()
        return if (seqShortName != null) seqShortName.toFirstLower() + "Id"
        else sequenceName.toFirstLower() + "Id"
    }
    //get() = this.qualifiedName.text.split("\\.").mapIndexed { i, s -> if (i == 0) s.toLowerCase() else s.capitalize() }.joinToString()

public val DsEntityFunction.methodName: String?
    get() {
        val ff = this.findFunction
        val n =
                if (ff != null) "find"
                else {
                    val indexf = this.indexFunction
                    if (indexf != null) "index"
                    else this.batchFunction!!.name
                }
        return n
    }

// TODO: for java names

public fun String.prepare(): String =
    this.split("_").map { it.toLowerCase().capitalize() }.joinToString("")

public fun String.prepareSkipFirst(): String? {
    val l = this.split("_")
    return if (l.size > 1) l.drop(1).map{ it.toLowerCase().capitalize() }.joinToString("") else null
}

public fun String.toFirstLower(): String {
    return this.get(0).toLowerCase() + this.substring(1)
}


