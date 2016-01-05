package com.acc.datascript.lang.extensions

import com.acc.datascript.lang.CallableSignature
import com.acc.datascript.lang.DataScriptFileType
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.names.segments
import com.acc.datascript.lang.psi.*
import com.acc.datascript.lang.types.DataScriptType
import com.acc.datascript.lang.types.inferType
import com.acc.datascript.resources.ConnectionPack
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.FileBasedIndex

/**
 * Created by nataly on 25.12.15.
 */

public val aggregateFunctionNames = setOf("sum", "max", "min", "avg")

public val sqlNativeFunctionNames = setOf("upper", "lower", "trim", "nvl", "to_char", "to_date", "decode", "to_number", "substr", "trunc")

public val allFunctionNames = aggregateFunctionNames.union(sqlNativeFunctionNames)

public val DsSqlStringLiteralExpression.value: String
    get() {
        val txt = this.text
        val len = txt.length
        return txt.substring(1, len - 1)
    }

public val DsSqlExpression.literalValue: String
    get() = when (this) {
        is DsSqlStringLiteralExpression -> '"' + this.value + '"'
        is DsSqlIntLiteralExpression -> this.text
        else -> ""
    }

public val DsTableDefinition.hasPrimaryKey: Boolean
    get() = this.primaryKeyClause?.sqlSimpleColumnRefExpressionList?.isNotEmpty() ?: false

public val DsCallGenerator.cardinality: Int?
    get() {
        val c = this.callableCardinality?.int?.text

        val i =
                if (c == null) null
                else try {
                    Integer.parseInt(c)
                } catch (e: NumberFormatException) {
                    null
                }
        return i
    }

public fun entityFunctionForPk(name: String) = setOf("find","update","delete").contains(name)

public fun DsConnection.connectionPack(): ConnectionPack? {
    val user = this.id?.text
    val serverInfo = this.string?.text

    return if (user != null && serverInfo != null) {
        val len = serverInfo.length
        ConnectionPack(serverInfo.substring(1, len - 1), user)
    } else null
}

public fun getSchema(file: PsiFile): DsSchemaSection =
        PsiTreeUtil.getChildOfType(file, DsSchemaSection::class.java)!!

public fun getConnectionPack(schemaSection: DsSchemaSection): ConnectionPack? =
        schemaSection.connection?.connectionPack()

public fun getSequenceNames(schemaSection: DsSchemaSection): List<String?> =
        schemaSection.sequenceDefinitionList.map { it.name }.filter { it != null }

public fun getTableNames(schemaSection: DsSchemaSection): List<String?> =
        schemaSection.tableDefinitionList.map { it.name }.filter { it != null }

public fun getViewNames(schemaSection: DsSchemaSection): List<String?> =
        schemaSection.viewDefinitionList.map { it.name }.filter { it != null }

public fun getDataScriptFiles(project: Project): Collection<DataScriptFile> {
    val psiManager = PsiManager.getInstance(project)
    return FileBasedIndex.getInstance().
            getContainingFiles(FileTypeIndex.NAME, DataScriptFileType.INSTANCE, GlobalSearchScope.allScope(project)).
            map { psiManager.findFile(it) as DataScriptFile }
}

public fun getSchemas(project: Project): List<DsSchemaSection> {
    var result = emptyList<DsSchemaSection>()
    for (file in getDataScriptFiles(project))
        result += PsiTreeUtil.findChildrenOfType(file, DsSchemaSection::class.java)
    return result
}

public fun getEnumDefinitions(project: Project): List<DsEnumDefinition> {
    var result = emptyList<DsEnumDefinition>()
    for (file in getDataScriptFiles(project))
        result += PsiTreeUtil.findChildrenOfType(file, DsEnumDefinition::class.java)
    return result
}

public fun getTableDefinitions(project: Project): List<DsTableDefinition> {
    var result = emptyList<DsTableDefinition>()
    for (file in getDataScriptFiles(project))
        result += PsiTreeUtil.findChildrenOfType(file, DsTableDefinition::class.java)
    return result
}

public fun getSequenceDefinitions(project: Project): List<DsSequenceDefinition> {
    var result = emptyList<DsSequenceDefinition>()
    for (file in getDataScriptFiles(project))
        result += PsiTreeUtil.findChildrenOfType(file, DsSequenceDefinition::class.java)
    return result
}

public fun getTableDefinitions(schemaSection: DsSchemaSection): Collection<DsTableDefinition> =
        PsiTreeUtil.findChildrenOfType(schemaSection, DsTableDefinition::class.java)

public fun getViewDefinitions(schemaSection: DsSchemaSection): Collection<DsViewDefinition> =
        PsiTreeUtil.findChildrenOfType(schemaSection, DsViewDefinition::class.java)

public fun getSequenceDefinitions(schemaSection: DsSchemaSection): Collection<DsSequenceDefinition> =
        PsiTreeUtil.findChildrenOfType(schemaSection, DsSequenceDefinition::class.java)

public fun getPackageDefinitions(schemaSection: DsSchemaSection): Collection<DsPackageDefinition> =
        PsiTreeUtil.findChildrenOfType(schemaSection, DsPackageDefinition::class.java)

public fun getCallableDefinitions(packageDefinition: DsPackageDefinition): Collection<DsSqlCallable> =
        PsiTreeUtil.findChildrenOfType(packageDefinition, DsSqlCallable::class.java)

public fun getCallableDefinitions(project: Project): List<DsSqlCallable> {
    var result = emptyList<DsSqlCallable>()
    for (file in getDataScriptFiles(project)) {
        result += PsiTreeUtil.findChildrenOfType(file, DsSqlCallable::class.java)
    }
    return result
}

public fun findEnumDefinitionByName(project: Project, name: String?): DsEnumDefinition? =
        getEnumDefinitions(project).firstOrNull { it.name == name }

public fun findEnumElement(enumDefinition: DsEnumDefinition, name: String): DsEnumElement? =
    enumDefinition.enumElementList.firstOrNull { it.name == name }

public fun getSqlParameter(expression: DsSqlParameterExpression): DsQueryParameter? {
    val commonParent = PsiTreeUtil.findFirstParent(expression, { it is DsQueryGenerator || it is DsEntityQueryGenerator })
    return PsiTreeUtil.findChildrenOfType(commonParent, DsQueryParameter::class.java).firstOrNull { it.id.text == expression.id.text }
}

public fun findSchema(name: String, project: Project): DsSchemaSection? =
        getSchemas(project).firstOrNull { it.name == name }

public fun findPackageDefinition(schemaSection: DsSchemaSection, packageName: String?): DsPackageDefinition? =
    schemaSection.packageDefinitionList.firstOrNull { (packageName == null && it.isDefault != null) || it.name == packageName }

public fun findFunction(n: DsQualifiedName): DsSqlFunctionCallable? {
    val segments = n.segments.map { it.toUpperCase() }

    val segmentsCount = segments.size
    if (segmentsCount < 2) return null

    val funName = segments.last()

    val schema = findSchema(segments[0], n.project)
    if (schema != null) {
        val packageDefinition = findPackageDefinition(schema, if (segmentsCount == 2) null else segments[1])
        if (packageDefinition != null) {
            return packageDefinition.sqlCallableList.firstOrNull { it is DsSqlFunctionCallable && it.name == funName } as DsSqlFunctionCallable
        }
    }

    return null
}

public fun findColumn(table: DsTableDefinition, name: String): DsColumn? =
        table.columnList.firstOrNull { it.name == name }

public fun findColumnOrEnumLiteral(ref: DsSqlColumnRefExpression): PsiElement? {
    val fullName = ref.node.getChildren(TokenSet.create(DataScriptTypes.ID))
    val segmentsCnt = fullName.size

    if (segmentsCnt == 1) {
        val parentExpr = ref.parent
        val operand = when (parentExpr) {
            is DsSqlComparisonExpression -> {
                val op = parentExpr.sqlComparisonOp.text
                if (op == "=" || op == "<>") parentExpr.sqlExpressionList[0] else null
            }
            is DsSqlInExpression -> parentExpr.sqlExpressionList[0]
            is DsSqlBetweenExpression -> parentExpr.sqlExpressionList[0]
            else -> null
        }
        if (operand != null && operand != ref) {
            val type = operand.inferType
            if (type != null && type is DataScriptType.Enum) {
                val enumElement = findEnumElement(type.enumRef, fullName[0].text)
                if (enumElement != null) return enumElement
            }
        }
    }

    val commonParent = PsiTreeUtil.findFirstParent(ref, { it is DsQueryGenerator || it is DsEntityQueryGenerator })!!

    val columnName = fullName.last().text

    val alias = if (segmentsCnt < 2) null else fullName[0].text
    val table = findTableDefinition(commonParent, alias )

    return if (table == null) null else table.columnList.firstOrNull { it.name == columnName }
}

public fun findTableDefinition(commonParent: PsiElement, alias: String?): DsTableDefinition? =
        when (commonParent) {
            is DsQueryGenerator -> {
                val fromClause = commonParent.fullSelect.fromClause
                val selectorList = fromClause.entitySelectorList
                if (selectorList.size == 0) null
                else {
                    val qn =
                            if (selectorList.size == 1)
                                selectorList[0].qualifiedName
                            else if (alias == null)
                                selectorList[0].qualifiedName
                            else {
                                selectorList.firstOrNull {
                                    val ac = it.aliasClause
                                    ac != null && ac.id.text == alias
                                }?.qualifiedName
                            }
                    if (qn != null) findTable(qn) else null
                }
            }
            is DsEntityQueryGenerator -> {
                val entity = commonParent.parent as DsEntityDefinition
                val qn = entity.qualifiedName
                if (qn != null) findTable(qn) else null
            }
            else -> null
        }

public fun getPrimaryColumns(tableDefinition: DsTableDefinition): List<DsColumn> {
    val primaryKeyClause = tableDefinition.primaryKeyClause ?: return emptyList()
    val primaryColumnRefs = PsiTreeUtil.findChildrenOfType(primaryKeyClause, DsSqlSimpleColumnRefExpression::class.java).map { it.id.text }.toSet()
    return tableDefinition.columnList.filter { primaryColumnRefs.contains(it.name) }
}

public fun getSignature(callable: DsSqlCallable): CallableSignature? {
    val name = callable.name ?: return null

    val cardinality = when (callable) {
        is DsSqlFunctionCallable -> callable.sqlCallableParametersList?.sqlCallableParameterList?.size ?: 0
        is DsSqlProcedureCallable -> callable.sqlCallableParametersList?.sqlCallableParameterList?.size ?: 0
        else -> 0
    }
    return CallableSignature(name, cardinality)
}

public fun findTable(qualifiedName: DsQualifiedName): DsTableDefinition? {
    val fullName = qualifiedName.node.getChildren(TokenSet.create(DataScriptTypes.ID))
    if (fullName.size < 2) return null

    val schemaName = fullName.get(0).text
    val tableName = fullName.get(1).text

    val schema = findSchema(schemaName, qualifiedName.project)
    return if (schema != null)
        schema.tableDefinitionList.firstOrNull { it.name == tableName }
    else null
}

public fun findCallable(qualifiedName: DsQualifiedName, cardinality: Int?): DsSqlCallable? {
    val segments = qualifiedName.segments.map { it.toUpperCase() }

    val segmentsCount = segments.size
    if (segmentsCount < 2) return null

    val funName = segments.last()

    val schema = findSchema(segments[0], qualifiedName.project)
    if (schema != null) {
        val packageDefinition = findPackageDefinition(schema, if (segmentsCount == 2) null else segments[1])
        if (packageDefinition != null) {
            return packageDefinition.sqlCallableList.firstOrNull {
                it.name == funName && (cardinality == null || cardinality == getSignature(it)?.cardinality)
            }
        }
    }

    return null
}
