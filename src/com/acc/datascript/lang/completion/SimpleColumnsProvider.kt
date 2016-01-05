package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getPrimaryColumns
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsPrimaryKeyClause
import com.acc.datascript.lang.psi.DsTableDefinition
import com.acc.datascript.lang.types.inferType
import com.acc.datascript.lang.types.validPrimaryTypes
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
class SimpleColumnsProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val primaryKeyClause = PsiTreeUtil.getParentOfType(parameters.position, DsPrimaryKeyClause::class.java)
        if (primaryKeyClause != null) {
            val tableDefinition = PsiTreeUtil.getParentOfType(primaryKeyClause, DsTableDefinition::class.java)!!
            val currentPrimaryColumns = getPrimaryColumns(tableDefinition).map { it.name }.toSet()

            resultSet.addAllElements(
                    tableDefinition.columnList.
                            filter { validPrimaryTypes.containsRaw(it.inferType?.sqlType) && !currentPrimaryColumns.contains(it.name)}.
                            map { LookupElementBuilder.create(it.name!!).
                                    withCaseSensitivity(false).
                            withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE) }
            )
        }
    }
}