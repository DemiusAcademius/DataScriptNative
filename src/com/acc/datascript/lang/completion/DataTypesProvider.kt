package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getEnumDefinitions
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsColumn
import com.acc.datascript.lang.psi.DsNamespaceSection
import com.acc.datascript.lang.types.conformForEnum
import com.acc.datascript.lang.types.inferType
import com.acc.datascript.lang.types.legalModifierTypes
import com.acc.datascript.resources.ColumnType
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

/**
 * Created by demius on 29.12.2015.
 */
class DataTypesProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val column = PsiTreeUtil.getParentOfType(parameters.position, DsColumn::class.java)
        if (column != null) provideForModifier(column, resultSet)
        else {
            resultSet.addAllElements(ColumnType.values.map {
                LookupElementBuilder.create(it.toText()).
                    withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE) })

            val enums = getEnumDefinitions(parameters.position.project)
            resultSet.addAllElements(enums.map {
                val namespace = PsiTreeUtil.getParentOfType(it, DsNamespaceSection::class.java)!!.name
                LookupElementBuilder.create(it.name!!).withTypeText(namespace, true).
                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
            })
        }
    }

    private fun provideForModifier(column: DsColumn, resultSet: CompletionResultSet) {
        val sqlType = column.sqlType.inferType?.sqlType
        if (sqlType != null) {
            val modifiers = sqlType.legalModifierTypes()
            resultSet.addAllElements(modifiers.map {
                LookupElementBuilder.create(it.toText()).
                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
            })
            if (sqlType == ColumnType.INT || sqlType == ColumnType.NULLABLE_INT || sqlType == ColumnType.STRING) {
                val enums = getEnumDefinitions(column.project).filter {
                    val enumType = it.inferType?.sqlType
                    it.name != null && enumType != null && sqlType.conformForEnum(enumType)
                }
                if (enums.size > 0)
                    resultSet.addAllElements(enums.map {
                        val namespace = PsiTreeUtil.getParentOfType(it, DsNamespaceSection::class.java)!!.name
                        LookupElementBuilder.create(it.name!!).withTypeText(namespace, true).
                                withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                    })
            }
        }
    }
}