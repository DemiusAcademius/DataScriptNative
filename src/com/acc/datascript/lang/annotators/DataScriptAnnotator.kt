package com.acc.datascript.lang.annotators

import com.acc.datascript.lang.extensions.allFunctionNames
import com.acc.datascript.lang.extensions.connectionPack
import com.acc.datascript.lang.extensions.findColumnOrEnumLiteral
import com.acc.datascript.lang.extensions.findEnumDefinitionByName
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.*
import com.acc.datascript.lang.types.TypeCheckResult
import com.acc.datascript.lang.types.checkType
import com.acc.datascript.resources.ConnectionManager
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement

/**
 * Created by nataly on 25.12.15.
 */
class DataScriptAnnotator: Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is DsSchemaSection -> annotateSchema(element, holder)
            is DsTableDefinition -> annotateTable(element, holder)
            is DsViewDefinition -> annotateView(element, holder)
            is DsSequenceDefinition -> annotateSequence(element, holder)
            is DsPackageDefinition -> annotatePackage(element, holder)
            is DsSqlCallable -> annotateCallable(element, holder)
            is DsSqlSimpleColumnRefExpression -> annotateSimpleColumnRef(element, holder)
            is DsEnumDefinition -> annotateDsEnumDefinition(element, holder)
            is DsEntityDefinition -> annotateEntityDefinition(element, holder)
            is DsClassDefinition -> annotateClassDefinition(element, holder)
            is DsClassElement -> annotateClassElement(element, holder)
            is DsEntityFunction -> annotateEntityFunction(element, holder)
            is DsEntitySelector -> annotateEntitySelector(element, holder)
            is DsSelectListClause -> annotateSelectListClause(element, holder)

            is DsSqlExpression -> {
                val result = checkType(element)
                if (result is TypeCheckResult.Error)
                    holder.createErrorAnnotation(result.psiElement, result.text)
                else if (element is DsSqlFunctionExpression) {
                    if (allFunctionNames.containsRaw(element.name)) {
                        val annotation = holder.createInfoAnnotation(element.qualifiedName, null)
                        annotation.textAttributes = DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
                    }
                } else if (element is DsSqlColumnRefExpression) {
                    val ref = findColumnOrEnumLiteral(element)
                    if (ref != null && ref is DsEnumElement) {
                        val annotation = holder.createInfoAnnotation(element, null)
                        annotation.textAttributes = DefaultLanguageHighlighterColors.STATIC_FIELD
                    }
                }
            }

            is DsConnection -> {
                val connectionPack = element.connectionPack()
                if (connectionPack != null) {
                    val connectionManager = ConnectionManager.getInstance()
                    if (!connectionManager.connections.contains(connectionPack)) {
                        holder.createErrorAnnotation(element, "Unresolved connection")
                    }
                }
            }

            is DsDataType -> {
                val psiRefName = element.id
                if (psiRefName != null)
                    if (findEnumDefinitionByName(element.project, psiRefName.text) == null)
                        holder.createErrorAnnotation(psiRefName, "Enumeration ${psiRefName.text} not exists");
                    else {
                        val annotation = holder.createInfoAnnotation(psiRefName, null)
                        annotation.textAttributes = DefaultLanguageHighlighterColors.STATIC_FIELD
                    }
            }

            is DsColumn -> {
                val result = com.acc.datascript.lang.types.checkType(element)
                if (result is TypeCheckResult.Error)
                    holder.createErrorAnnotation(result.psiElement, result.text)
            }
        }
    }
}