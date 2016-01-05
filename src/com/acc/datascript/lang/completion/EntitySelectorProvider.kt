package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getTableDefinitions
import com.acc.datascript.lang.extensions.hasPrimaryKey
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsSchemaSection
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

/**
 * Created by demius on 30.12.2015.
 */
class EntitySelectorProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val tables = getTableDefinitions(parameters.position.project).filter { it.name != null }
        if (tables.size > 0) {
            resultSet.addAllElements(
                    tables.map {
                                val schema = PsiTreeUtil.getParentOfType(it, DsSchemaSection::class.java)!!.name
                                val tableName = it.name!!
                                LookupElementBuilder.create(tableName).withTypeText(schema, true).
                                        withCaseSensitivity(false).
                                        withInsertHandler { insertionContext, lookupElement ->
                                            val document = insertionContext.document
                                            val startOffset = insertionContext.startOffset
                                            val tailOffset = insertionContext.tailOffset

                                            val string = "$schema.$tableName"

                                            document.replaceString(startOffset, tailOffset, string);
                                            insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length);
                                        }.
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )

        }

    }
}