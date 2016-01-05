package com.acc.datascript.lang.completion

import com.acc.datascript.resources.ConnectionManager
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

/**
 * Created by nataly on 25.12.15.
 */
class ConnectionProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        resultSet.addAllElements(

                ConnectionManager.getInstance().connections.map {
                    LookupElementBuilder.create(it.user).withTypeText(it.serverInfo,true).
                            withInsertHandler { insertionContext, lookupElement ->
                                val document = insertionContext.document
                                val startOffset = insertionContext.startOffset
                                val tailOffset = insertionContext.tailOffset

                                val string = "${it.user} \"${it.serverInfo}\"\n"

                                document.replaceString(startOffset, tailOffset, string);
                                insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length);
                            }.
                            withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                }

        )

    }

}