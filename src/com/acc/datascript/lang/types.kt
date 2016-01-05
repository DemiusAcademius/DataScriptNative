package com.acc.datascript.lang.types

import com.acc.datascript.lang.extensions.*
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.*
import com.acc.datascript.resources.ColumnType
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

/**
 * Created by nataly on 27.12.15.
 */

public sealed class DataScriptType(val sqlType: ColumnType?) {
    public class Sql(sqlType: ColumnType?) : DataScriptType(sqlType) {
        override fun toString(): String = sqlType?.toText() ?: "null"
    }

    public class Enum(sqlType: ColumnType?, val enumRef: DsEnumDefinition) : DataScriptType(sqlType) {
        override fun toString(): String = enumRef.name ?: sqlType?.toText() ?: "null"
    }
}

public sealed class TypeCheckResult {
    public object Ok : TypeCheckResult()

    public class Error(val text: String, val psiElement: PsiElement) : TypeCheckResult()
}

val nullType = DataScriptType.Sql(null)

val intType = DataScriptType.Sql(ColumnType.INT)
val longType = DataScriptType.Sql(ColumnType.LONG)
val nullIntType = DataScriptType.Sql(ColumnType.NULLABLE_INT)
val nullLongType = DataScriptType.Sql(ColumnType.NULLABLE_LONG)

val doubleType = DataScriptType.Sql(ColumnType.DOUBLE)
val decimalType = DataScriptType.Sql(ColumnType.DECIMAL)

val stringType = DataScriptType.Sql(ColumnType.STRING)

val dateType = DataScriptType.Sql(ColumnType.DATE)
val timeType = DataScriptType.Sql(ColumnType.TIMESTAMP)

val boolType = DataScriptType.Sql(ColumnType.BOOLEAN)

val sqlTypesRegistry = mapOf(
        "int" to intType, "long" to longType, "int?" to nullIntType, "long?" to nullLongType,
        "double" to doubleType, "decimal" to decimalType,
        "string" to stringType,
        "date" to dateType, "timestamp" to timeType, "boolean" to boolType)

val sqlTypesRegistryEnums = mapOf(
        ColumnType.INT to intType, ColumnType.LONG to longType,
        ColumnType.NULLABLE_INT to nullIntType, ColumnType.NULLABLE_LONG to nullLongType,
        ColumnType.DOUBLE to doubleType, ColumnType.DECIMAL to decimalType,
        ColumnType.STRING to stringType,
        ColumnType.DATE to dateType, ColumnType.TIMESTAMP to timeType,
        ColumnType.BOOLEAN to boolType)

val intSet = setOf(ColumnType.INT, ColumnType.LONG)

public val validPrimaryTypes = setOf(ColumnType.INT, ColumnType.LONG, ColumnType.STRING)

// INFER TYPES

public val ColumnType.inferType: DataScriptType?
    get() = sqlTypesRegistryEnums.get(this)

public val DsEnumElement.inferType: DataScriptType?
    get() {
        val sqlType = this.sqlExpression.inferType?.sqlType
        val enumDefinition = PsiTreeUtil.getParentOfType(this, DsEnumDefinition::class.java)
        return if (sqlType != null && enumDefinition != null) DataScriptType.Enum(sqlType, enumDefinition) else null
    }

public val DsEnumDefinition.inferType: DataScriptType?
    get() {
        var t = this.enumElementList.firstOrNull()?.sqlExpression?.inferType?.sqlType
        if (t == ColumnType.INT) {
            val isNullable = this.enumElementList.firstOrNull { it.sqlExpression is DsSqlNullLiteralExpression } != null
            if (isNullable) t = ColumnType.NULLABLE_INT
        }
        return DataScriptType.Enum(t, this)
    }

public val DsSqlType.inferType: DataScriptType?
    get() = sqlTypesRegistry.get(this.text)

public val DsDataType.inferType: DataScriptType?
    get() = this.sqlType?.inferType ?: findEnumDefinitionByName(this.project, this.id?.text)?.inferType

public val DsColumn.inferType: DataScriptType?
    get() = this.typeModifier?.dataType?.inferType ?: this.sqlType.inferType

public val DsQueryParameter.inferType: DataScriptType?
    get() = this.dataType.inferType

public val DsSqlExpression.inferType: DataScriptType?
    get() = when (this) {
        is DsSqlIntLiteralExpression -> intType
        is DsSqlStringLiteralExpression -> stringType
        is DsSqlDateLiteralExpression -> dateType
        is DsSqlNullLiteralExpression -> nullType
        is DsSqlSysDateLiteralExpression -> timeType

        is DsSqlAndExpression, is DsSqlOrExpression, is DsSqlComparisonExpression,
        is DsSqlNotExpression, is DsSqlBetweenExpression, is DsSqlInExpression -> boolType

        is DsSqlCountFunctionExpression -> intType

        is DsSqlParanthesisExpression -> this.sqlExpression.inferType
        is DsSqlParameterExpression -> getSqlParameter(this)?.inferType

        is DsSqlFunctionExpression -> {
            val n = this.name
            val expressions = this.sqlExpressionList
            val t =
                    if (aggregateFunctionNames.containsRaw(n))
                        inferAggregateFunctionType(expressions)
                    else if (sqlNativeFunctionNames.containsRaw(n))
                        inferNativeFunctionType(n!!, expressions)
                    else findFunction(this.qualifiedName)?.dataType?.inferType
            t
        }

        is DsSqlPlusOrMinusExpression -> inferPlusOrMinusExprType(this)
        is DsSqlMulOrDivExpression -> inferMulOrDivExprType(this)

        is DsSqlColumnRefExpression -> {
            val colOrEnum = findColumnOrEnumLiteral(this)
            if (colOrEnum != null)
                when (colOrEnum) {
                    is DsColumn -> colOrEnum.inferType
                    is DsEnumElement -> colOrEnum.inferType
                    else -> null
                }
            else null
        }

        else -> null
    }

private fun inferAggregateFunctionType(expressions: Collection<DsSqlExpression>): DataScriptType? {
    val childType = expressions.firstOrNull()?.inferType
    val t =
            if (childType == null) null
            else if (intSet.containsRaw (childType.sqlType))
                childType.sqlType?.toNullable()?.inferType
            else childType
    return t
}

private fun inferNativeFunctionType(f: String, expressions: Collection<DsSqlExpression>): DataScriptType? =
        when (f) {
            "lower", "upper", "trim", "to_char", "substr" -> stringType
            "to_date", "trunc" -> dateType

            "to_number" -> {
                val headExpr = expressions.firstOrNull()
                if (headExpr == null) null
                else {
                    if (headExpr is DsSqlIntLiteralExpression) intType
                    else if (headExpr is DsSqlStringLiteralExpression) {
                        val str = headExpr.value
                        if (!str.contains(".")) {
                            if (str.length > 30) longType else intType
                        } else doubleType
                    } else decimalType
                }
            }
            "nvl" -> {
                val headExpr = expressions.firstOrNull()
                if (headExpr == null) null
                else headExpr.inferType?.sqlType?.toNonNullable()?.inferType
            }

            "decode" -> expressions.elementAtOrNull(2)?.inferType

            else -> null
        }

private fun inferPlusOrMinusExprType(expr: DsSqlPlusOrMinusExpression): DataScriptType? {
    val literal = expr.sqlPlusOrMinusOp
    val op = literal.text
    val type =
            if (op == "||") stringType
            else {
                val expressions = expr.sqlExpressionList
                val leftExpr = expressions[0]

                if (expressions.size < 2) leftExpr.inferType
                else {
                    val rightExpr = expressions[1]
                    inferBinaryType(leftExpr, rightExpr, true)
                }
            }
    return type
}

private fun inferMulOrDivExprType(expr: DsSqlMulOrDivExpression): DataScriptType? {
    val expressions = expr.sqlExpressionList
    val leftExpr = expressions[0]

    val type =
            if (expressions.size < 2) leftExpr.inferType
            else {
                val rightExpr = expressions[1]
                inferBinaryType(leftExpr, rightExpr, false)
            }
    return type
}

private fun inferBinaryType(leftExpr: DsSqlExpression, rightExpr: DsSqlExpression, withDate: Boolean): DataScriptType? {
    val leftType = leftExpr.inferType
    val rightType = rightExpr.inferType

    val retType =
            if (leftType == null || rightType == null || leftType.sqlType == null) leftType
            else {
                if (leftType is DataScriptType.Enum) leftType
                else if (rightType is DataScriptType.Enum) rightType
                else if (withDate && leftType.sqlType.isDate && rightType.sqlType == ColumnType.INT) leftType
                else if (leftType.sqlType.superTypes().contains(rightType.sqlType)) rightType
                else leftType
            }
    return retType
}

// CHECK TYPES AND OTHERS

public fun checkType(enumDefinition: DsEnumDefinition): TypeCheckResult {
    var result = TypeCheckResult.Ok as TypeCheckResult
    var curElement = null as ColumnType?

    val elements = enumDefinition.enumElementList
    if (elements.size == 0)
        return TypeCheckResult.Error("Enumeration must have values", enumDefinition)

    for (element in elements) {
        val t = element.sqlExpression.inferType?.sqlType
        if (curElement == null) curElement = t
        else if (result == TypeCheckResult.Ok && curElement != t)
            result = TypeCheckResult.Error("Type of value not matched with others values", element)
    }

    return result
}

public fun checkType(column: DsColumn): TypeCheckResult {
    val modifier = column.typeModifier
    if (modifier == null) return TypeCheckResult.Ok
    else {
        val fieldType = column.sqlType.inferType?.sqlType
        val modifierType = modifier.dataType.inferType
        val mt = modifierType?.sqlType

        if (fieldType != null && modifierType != null && mt != null) {
            if (modifierType is DataScriptType.Enum) {
                if (!fieldType.conformForEnum(mt))
                    return TypeCheckResult.Error("Types of column and enum do not match", modifier)
            } else if (!fieldType.legalModifierTypes().contains(mt))
                return TypeCheckResult.Error("Types of column and modifer do not match", modifier)
        }

        return TypeCheckResult.Ok
    }
}

public fun ColumnType.conformForEnum(anotherType: ColumnType) =
        this == anotherType || (this == ColumnType.NULLABLE_INT && anotherType == ColumnType.INT)

public fun ColumnType.legalModifierTypes(): Set<ColumnType> {
    val set = HashSet<ColumnType>()

    if (this == ColumnType.INT || this == ColumnType.NULLABLE_INT)
        set.add(ColumnType.BOOLEAN)
    if (this == ColumnType.NULLABLE_INT) set.add(ColumnType.INT)
    if (this == ColumnType.NULLABLE_LONG) {
        set.add(ColumnType.LONG)
        set.add(ColumnType.DOUBLE)
        set.add(ColumnType.DECIMAL)
    }
    if (this == ColumnType.DATE) set.add(ColumnType.TIMESTAMP)
    if (this == ColumnType.DOUBLE) set.add(ColumnType.DECIMAL)

    return set
}

public fun checkType(expr: DsSqlExpression): TypeCheckResult =
        when (expr) {
            is DsSqlParameterExpression -> checkParameterExpression(expr)
            is DsSqlColumnRefExpression -> checkColumnRefExpression(expr)
            is DsSqlComparisonExpression -> checkComparisonExpression(expr)
            is DsSqlCountFunctionExpression -> TypeCheckResult.Ok
            is DsSqlFunctionExpression -> checkFunctionExpression(expr)
            is DsSqlBetweenExpression -> checkBetweenExpression(expr)
            is DsSqlInExpression -> checkInExpression(expr)
            is DsSqlOrExpression -> checkOrExpression(expr)
            is DsSqlAndExpression -> checkAndExpression(expr)
            is DsSqlMulOrDivExpression -> checkMulOrDivExpression(expr)
            is DsSqlPlusOrMinusExpression -> checkPlusOrMinusExpression(expr)
            is DsSqlNotExpression -> checkNotExpression(expr)
            else -> TypeCheckResult.Ok
        }

private fun checkOrExpression(expr: DsSqlOrExpression): TypeCheckResult {
    val pair = inferBinaryExpressions(expr.sqlExpressionList)
    return if (pair == null) TypeCheckResult.Ok else checkBinaryBoolean(pair.first, pair.second)
}

private fun checkAndExpression(expr: DsSqlAndExpression): TypeCheckResult {
    val pair = inferBinaryExpressions(expr.sqlExpressionList)
    return if (pair == null) TypeCheckResult.Ok else checkBinaryBoolean(pair.first, pair.second)
}

private fun checkMulOrDivExpression(expr: DsSqlMulOrDivExpression): TypeCheckResult {
    val pair = inferBinaryExpressions(expr.sqlExpressionList)
    return if (pair == null) TypeCheckResult.Ok else checkBinaryNumeric(pair.first, pair.second, false)
}

private fun checkPlusOrMinusExpression(expr: DsSqlPlusOrMinusExpression): TypeCheckResult {
    val pair = inferBinaryExpressions(expr.sqlExpressionList)
    val op = expr.sqlPlusOrMinusOp.text

    val ret =
            if (pair == null) TypeCheckResult.Ok
            else if (op == "||") checkBinaryString(pair.first, pair.second)
            else checkBinaryNumeric(pair.first, pair.second, true)

    return ret
}

private fun inferBinaryExpressions(expressions: List<DsSqlExpression>): Pair<DsSqlExpression, DsSqlExpression>? =
        if (expressions.size != 2) null else Pair(expressions[0], expressions[1])

private fun checkNotExpression(expr: DsSqlNotExpression): TypeCheckResult {
    val subExpr = expr.sqlExpression

    val ret =
            if (subExpr.inferType?.sqlType == ColumnType.BOOLEAN) TypeCheckResult.Ok
            else TypeCheckResult.Error("argument have to be boolean", subExpr)

    return ret
}

private fun checkFunctionExpression(expr: DsSqlFunctionExpression): TypeCheckResult {
    val n = expr.name
    val expressions = expr.sqlExpressionList
    val t =
            if (aggregateFunctionNames.containsRaw(n)) {
                if (expressions.isNotEmpty() && (n == "sum" || n == "avg")) {
                    if (expressions[0].inferType?.sqlType?.isNumeric ?: false) TypeCheckResult.Ok
                    else TypeCheckResult.Error("type must be numeric", expressions[0])
                } else TypeCheckResult.Ok
            } else if (sqlNativeFunctionNames.containsRaw(n)) {

                val string1 = { ->
                    if (expressions.size == 1 && expressions[0].inferType?.sqlType == ColumnType.STRING) TypeCheckResult.Ok
                    else TypeCheckResult.Error("function have to be 1 argument and string type", expr.qualifiedName)
                }

                when (n) {
                    "trunc" ->
                        if (expressions.size == 1) {
                            val t = expressions[0].inferType?.sqlType
                            if (t?.isDate ?: false) TypeCheckResult.Ok
                            else TypeCheckResult.Error("invalid type, must be datetime or timestamp", expressions[0])
                        } else TypeCheckResult.Error("invalid application of function", expr.qualifiedName)

                    "to_date" ->
                        if (expressions.size == 2)
                            checkTypeSample(stringType, expressions)
                        else TypeCheckResult.Error("function TO_DATE have to be 2 arguments", expr.qualifiedName)

                    "nvl" ->
                        if (expressions.size == 2) checkTypes(expressions)
                        else TypeCheckResult.Error("function NVL have to be 2 arguments", expr.qualifiedName)

                    "upper", "lower", "trim" -> string1.invoke()
                    else -> TypeCheckResult.Ok
                }


            } else {
                val funDef = findFunction(expr.qualifiedName)
                // TODO: check types for user functions
                TypeCheckResult.Ok
            }
    return t
}

private fun checkBetweenExpression(expr: DsSqlBetweenExpression): TypeCheckResult {
    val expressions = expr.sqlExpressionList
    val ret =
            if (expressions.size < 3) TypeCheckResult.Ok
            else {
                val t = expressions[0].inferType
                if (t == null) TypeCheckResult.Ok else checkTypeSample(t, expressions.drop(1))
            }
    return ret
}

private fun checkInExpression(expr: DsSqlInExpression): TypeCheckResult {
    val expressions = expr.sqlExpressionList
    val atomicList = expr.sqlAtomicList
    val subSelect = expr.subSelect

    val ret =
            if (expressions.size != 1) TypeCheckResult.Ok
            else {
                val t = expressions[0].inferType
                if (t == null) TypeCheckResult.Ok
                else if (atomicList != null)
                    checkTypeSample(t, atomicList.sqlExpressionList)
                else {
                    // TODO: check type for sub select
                    TypeCheckResult.Ok
                }
            }
    return ret
}

private fun checkTypeSample(sampleType: DataScriptType, expressions: List<DsSqlExpression>): TypeCheckResult {
    val st = sampleType.sqlType
    for (element in expressions) {
        val et = element.inferType?.sqlType
        if (!(et == st || (st?.isNumeric ?: false && et?.isNumeric ?: false)))
            return TypeCheckResult.Error("Type of value not matched with others values", element)
    }
    return TypeCheckResult.Ok
}

private fun checkTypes(expressions: List<DsSqlExpression>): TypeCheckResult {
    var result: TypeCheckResult = TypeCheckResult.Ok
    var curElement: ColumnType? = null

    for (element in expressions) {
        val t = element.inferType?.sqlType
        if (curElement == null) curElement = t
        else if (result == TypeCheckResult.Ok && curElement != t)
            result = TypeCheckResult.Error("Type of value not matched with others values", element)
    }
    return result
}

private fun checkComparisonExpression(expr: DsSqlComparisonExpression): TypeCheckResult {
    val expressions = expr.sqlExpressionList
    if (expressions.size < 2) return TypeCheckResult.Ok

    if (expressions.size > 2) {
        println("count of expressions in comparison is ${expressions.size}")
        return TypeCheckResult.Error("count of expressions in comparison is ${expressions.size}", expr)
    }

    val literal = expr.sqlComparisonOp
    val op = literal.text

    if (op == "is") {
        val right = expressions[1]
        val ret =
                if (right is DsSqlNullLiteralExpression) TypeCheckResult.Ok
                else TypeCheckResult.Error("valid expression: is null", right)
        return ret
    }

    val leftType = expressions[0].inferType
    val rightType = expressions[1].inferType

    if (leftType == null || rightType == null) return TypeCheckResult.Ok

    val ret =
            if (leftType is DataScriptType.Enum || rightType is DataScriptType.Enum) {
                if (!(leftType is DataScriptType.Enum) || !(rightType is DataScriptType.Enum))
                    TypeCheckResult.Error("both types have to be enums", literal)
                else if (leftType.enumRef.id?.text != rightType.enumRef.id?.text)
                    TypeCheckResult.Error("enums do not match", literal)
                else if (op != "=" && op != "<>")
                    TypeCheckResult.Error("only '=' and '<>' operations valid for enums", literal)
                else TypeCheckResult.Ok
            } else {
                val lt = leftType.sqlType!!
                val rt = rightType.sqlType!!
                if (op == "like") {
                    if (lt == ColumnType.STRING && rt == ColumnType.STRING) TypeCheckResult.Ok
                    else TypeCheckResult.Error("types for like have to be string", literal)
                } else if (lt == rt || (lt.isNumeric && rt.isNumeric)) TypeCheckResult.Ok
                else TypeCheckResult.Error("types do not match", literal)
            }

    return ret
}

private fun checkParameterExpression(expr: DsSqlParameterExpression): TypeCheckResult =
        if (getSqlParameter(expr) == null) TypeCheckResult.Error("query does not have this parameter", expr) else TypeCheckResult.Ok

private fun checkColumnRefExpression(expr: DsSqlColumnRefExpression): TypeCheckResult =
        if (findColumnOrEnumLiteral(expr) == null) TypeCheckResult.Error("can not find column", expr) else TypeCheckResult.Ok

private fun checkBinaryBoolean(leftExpr: DsSqlExpression, rightExpr: DsSqlExpression): TypeCheckResult {
    val leftType = leftExpr.inferType?.sqlType
    var rightType = rightExpr.inferType?.sqlType

    val ret =
            if (leftType == null || rightType == null) TypeCheckResult.Ok
            else if (leftType == ColumnType.BOOLEAN && rightType == ColumnType.BOOLEAN) TypeCheckResult.Ok
            else {
                val literal = if (leftType != ColumnType.BOOLEAN) leftExpr else rightExpr
                TypeCheckResult.Error("types have to be boolean", literal)
            }
    return ret
}

private fun checkBinaryNumeric(leftExpr: DsSqlExpression, rightExpr: DsSqlExpression, withDate: Boolean): TypeCheckResult {
    val leftType = leftExpr.inferType
    var rightType = rightExpr.inferType

    val leftSqlType = leftType?.sqlType
    var rightSqlType = rightType?.sqlType

    val ret =
            if (leftSqlType == null || rightSqlType == null) TypeCheckResult.Ok
            else if (leftType is DataScriptType.Enum)
                TypeCheckResult.Error("invalid operatio for enumeration", leftExpr)
            else if (rightType is DataScriptType.Enum)
                TypeCheckResult.Error("invalid operatio for enumeration", rightExpr)
            else if (leftSqlType.isNumeric && rightSqlType.isNumeric) TypeCheckResult.Ok
            else if (withDate && leftSqlType.isDate && rightSqlType == ColumnType.INT) TypeCheckResult.Ok
            else {
                val literal = if (!leftSqlType.isNumeric) leftExpr else rightExpr
                TypeCheckResult.Error("types have to be numeric", literal)
            }
    return ret
}

private fun checkBinaryString(leftExpr: DsSqlExpression, rightExpr: DsSqlExpression): TypeCheckResult {
    val leftType = leftExpr.inferType
    var rightType = rightExpr.inferType

    val leftSqlType = leftType?.sqlType
    var rightSqlType = rightType?.sqlType

    val ret =
            if (leftSqlType == null || rightSqlType == null) TypeCheckResult.Ok
            else if (leftType is DataScriptType.Enum)
                TypeCheckResult.Error("invalid operatio for enumeration", leftExpr)
            else if (rightType is DataScriptType.Enum)
                TypeCheckResult.Error("invalid operatio for enumeration", rightExpr)
            else if (leftSqlType == ColumnType.STRING && rightSqlType == ColumnType.STRING) TypeCheckResult.Ok
            else {
                val literal = if (leftSqlType != ColumnType.STRING) leftExpr else rightExpr
                TypeCheckResult.Error("types have to be string", literal)
            }
    return ret
}

