package com.acc.datascript.lang.annotators

import com.acc.datascript.lang.extensions.*
import com.acc.datascript.lang.names.className
import com.acc.datascript.lang.names.methodName
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.types.*
import com.acc.datascript.lang.psi.*
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

/**
 * Created by demius on 29.12.2015.
 */

private fun AnnotationHolder.error(id: PsiElement, elementName: String) {
    this.createErrorAnnotation(id, "Duplicate $elementName name")
}

public fun annotateSchema(schemaSection: DsSchemaSection, holder: AnnotationHolder) {
    val id = schemaSection.id ?: return
    val name = schemaSection.name
    if (getSchemas(schemaSection.project).firstOrNull { schemaSection != it && name == it.name } != null)
        holder.error(id, "schema")
}

public fun annotateTable(tableDefinition: DsTableDefinition, holder: AnnotationHolder) {
    val id = tableDefinition.id ?: return
    val name = tableDefinition.name
    val schema = PsiTreeUtil.getParentOfType(tableDefinition, DsSchemaSection::class.java)!!
    if (getTableDefinitions(schema).firstOrNull { tableDefinition != it && name == it.name } != null)
        holder.error(id, "table")
}

public fun annotateView(viewDefinition: DsViewDefinition, holder: AnnotationHolder) {
    val id = viewDefinition.id ?: return
    val name = viewDefinition.name
    val schema = PsiTreeUtil.getParentOfType(viewDefinition, DsSchemaSection::class.java)!!
    if (getViewDefinitions(schema).firstOrNull { viewDefinition != it && name == it.name } != null)
        holder.error(id, "view")
}

public fun annotateSequence(sequenceDefinition: DsSequenceDefinition, holder: AnnotationHolder) {
    val id = sequenceDefinition.id ?: return
    val name = sequenceDefinition.name
    val schema = PsiTreeUtil.getParentOfType(sequenceDefinition, DsSchemaSection::class.java)!!
    if (getSequenceDefinitions(schema).firstOrNull { sequenceDefinition != it && name == it.name } != null)
        holder.error(id, "sequence")
}

public fun annotatePackage(packageDefinition: DsPackageDefinition, holder: AnnotationHolder) {
    val isDefault = packageDefinition.isDefault != null

    val element = (if (isDefault) packageDefinition.isDefault else packageDefinition.id) ?: return

    val name = packageDefinition.name
    val schema = PsiTreeUtil.getParentOfType(packageDefinition, DsSchemaSection::class.java)!!

    if (getPackageDefinitions(schema).firstOrNull {
        packageDefinition != it &&
                ((isDefault && it.isDefault != null) || name == it.name)
    } != null)
        holder.error(element, "package")
}

public fun annotateCallable(callable: DsSqlCallable, holder: AnnotationHolder) {
    val signature = getSignature(callable) ?: return

    val packageDefinition = PsiTreeUtil.getParentOfType(callable, DsPackageDefinition::class.java)!!
    if (getCallableDefinitions(packageDefinition).firstOrNull { callable != it && signature == getSignature(it) } != null)
        holder.createErrorAnnotation(callable.firstChild.nextSibling.nextSibling, "Duplicate signature of callable")
}

public fun annotateSimpleColumnRef(ref: DsSqlSimpleColumnRefExpression, holder: AnnotationHolder) {
    val primaryKeyClause = PsiTreeUtil.getParentOfType(ref, DsPrimaryKeyClause::class.java)
    if (primaryKeyClause != null) {
        val id = ref.id.text.toUpperCase()
        val cols = PsiTreeUtil.findChildrenOfType(primaryKeyClause, DsSqlSimpleColumnRefExpression::class.java)
        if (cols.firstOrNull { ref != it && id == it.id.text } != null) {
            holder.error(ref, "primary column")
        } else {
            val table = PsiTreeUtil.getParentOfType(primaryKeyClause, DsTableDefinition::class.java)!!
            val column = findColumn(table, id)
            if (column == null) {
                holder.createErrorAnnotation(ref, "Column not exists")
            } else if (!validPrimaryTypes.containsRaw(column.inferType?.sqlType)) {
                holder.createErrorAnnotation(ref, "Type of column not valid for primary key")
            }
        }
    }

}

public fun annotateDsEnumDefinition(enumDefinition: DsEnumDefinition, holder: AnnotationHolder) {
    val name = enumDefinition.name ?: return

    val result = com.acc.datascript.lang.types.checkType(enumDefinition)
    if (result is TypeCheckResult.Error) {
        holder.createErrorAnnotation(result.psiElement, result.text)
        return
    }

    val element = enumDefinition.id!!

    val dup = getEnumDefinitions(enumDefinition.project).firstOrNull { enumDefinition != it && name == it.name }
    if (dup != null) {
        val namespace = PsiTreeUtil.getParentOfType(dup, DsNamespaceSection::class.java)!!
        holder.createErrorAnnotation(element, "Duplicate enumeration name with ${namespace.name}.name")
    } else {
        val namespace = PsiTreeUtil.getParentOfType(enumDefinition, DsNamespaceSection::class.java)!!
        if (namespace.entityDefinitionList.firstOrNull { name == it.className } != null)
            holder.error(element, "enumeration")
        else if (namespace.classDefinitionList.firstOrNull { name == it.name } != null)
            holder.error(element, "enumeration")
    }
}

public fun annotateEntityDefinition(entityDefinition: DsEntityDefinition, holder: AnnotationHolder) {
    val name = entityDefinition.className ?: return

    val namespace = PsiTreeUtil.getParentOfType(entityDefinition, DsNamespaceSection::class.java)!!
    val error =
            if (namespace.entityDefinitionList.firstOrNull { entityDefinition != it && name == it.className } != null) true
            else if (namespace.classDefinitionList.firstOrNull { name == it.name } != null) true
            else if (namespace.enumDefinitionList.firstOrNull { name == it.name } != null) true
            else false

    if (error) holder.error(entityDefinition.qualifiedName!!, "entity")
}

public fun annotateClassDefinition(classDefinition: DsClassDefinition, holder: AnnotationHolder) {
    val name = classDefinition.name ?: return

    val namespace = PsiTreeUtil.getParentOfType(classDefinition, DsNamespaceSection::class.java)!!
    val error =
            if (namespace.classDefinitionList.firstOrNull { classDefinition != it && name == it.name } != null) true
            else if (namespace.entityDefinitionList.firstOrNull { name == it.className } != null) true
            else if (namespace.enumDefinitionList.firstOrNull { name == it.name } != null) true
            else false

    if (error) holder.error(classDefinition.id!!, "class")
}

public fun annotateClassElement(classElement: DsClassElement, holder: AnnotationHolder) {
    val classDefinition = classElement.parent
    when (classDefinition) {
        is DsClassDefinition -> {
            val name =
                    when (classElement) {
                        is DsCallGenerator -> classElement.methodName
                        is DsSequenceGenerator -> classElement.methodName
                        is DsQueryGenerator -> classElement.name
                        else -> ""
                    }
            if (classDefinition.classElementList.firstOrNull {
                val n =
                        when (it) {
                            is DsCallGenerator -> it.methodName
                            is DsSequenceGenerator -> it.methodName
                            is DsQueryGenerator -> it.name
                            else -> ""
                        }
                classElement != it && name == n
            } != null) holder.error(classElement.firstChild.nextSibling.nextSibling, "class element")
        }
        is DsEntityDefinition -> {
            classElement as DsEntityQueryGenerator
            val name = classElement.name
            if (classDefinition.entityQueryGeneratorList.firstOrNull { classElement != it && it.name == name } != null)
                holder.error(classElement.id, "query")
        }
    }
}

public fun annotateEntityFunction(entityFunction: DsEntityFunction, holder: AnnotationHolder) {
    val entity = entityFunction.parent as DsEntityDefinition
    val name = entityFunction.methodName ?: return
    val qualifiedName = entity.qualifiedName ?: return

    if (entity.entityFunctionList.firstOrNull { entityFunction != it && it.methodName == name } != null)
        holder.error(entityFunction, "entity function")
    else if (entityFunctionForPk(name)) {
        val table = findTable(qualifiedName)
        if (table != null && !table.hasPrimaryKey)
            holder.createErrorAnnotation(entityFunction, "table does not have a primary key")
    }
}

public fun annotateEntitySelector(entitySelector: DsEntitySelector, holder: AnnotationHolder) {
    val qualifiedName = entitySelector.qualifiedName ?: return
    val table = findTable(qualifiedName)
    if (table == null)
        holder.createErrorAnnotation(qualifiedName, "table does not exists")
    else {
        val name = entitySelector.name
        val element = entitySelector.aliasClause ?: qualifiedName
        val fromClause = PsiTreeUtil.getParentOfType(entitySelector, DsFromClause::class.java)!!
        if (fromClause.entitySelectorList.firstOrNull { entitySelector != it && it.name == name } != null)
            holder.error(element, "table selector")
    }
}

public fun annotateSelectListClause(selectListClause: DsSelectListClause, holder: AnnotationHolder) {
    val uniqueSet = HashSet<String>()
    val elementsCount = (selectListClause.allInGroupQualifierList + selectListClause.selectDerivedColumnList).size

    val checkName = { n: String, element: PsiElement ->
        if (uniqueSet.contains(n))
            holder.createErrorAnnotation(element, "element is duplicated")
        else uniqueSet.add(n)
    }

    for (element in selectListClause.allInGroupQualifierList) {
        val refName = element.id.text
        val query = PsiTreeUtil.getParentOfType(selectListClause, DsFullSelect::class.java)!!
        val fromClause = query.fromClause
        val selectorList = fromClause.entitySelectorList
        val qn = selectorList.firstOrNull {
            val ac = it.aliasClause
            ac != null && ac.id.text == refName
        }?.qualifiedName
        if (qn != null) {
            val table = findTable(qn)
            if (table != null) table.columnList.forEach {
                val n = it.name
                if (n!= null) checkName(n, element)
            }
        }
    }

    for (element in selectListClause.selectDerivedColumnList) {
        val n = element.name
        if (n == null) {
            if (elementsCount > 1) holder.createWarningAnnotation(element, "element must have name")
        } else  checkName.invoke(n, element)
    }

}
