package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getConnectionPack
import com.acc.datascript.lang.extensions.getSchema
import com.acc.datascript.lang.extensions.getViewNames
import com.acc.datascript.lang.names.name
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
class ViewsProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val schemaSection = getSchema(parameters.originalFile)
        val schemaName = schemaSection.name
        val connectionPack = getConnectionPack(schemaSection)

        if (connectionPack != null && schemaName != null) {
            val connectionManager = ConnectionManager.getInstance()
            val currentViews = getViewNames(schemaSection).toSet()

            resultSet.addAllElements(
                    connectionManager.
                            getViews(connectionPack, schemaName).
                            filter { !currentViews.containsRaw(it) }.
                            map {
                                LookupElementBuilder.create(it).
                                        withCaseSensitivity(false).
                                        withInsertHandler { insertionContext, lookupElement ->
                                            val document = insertionContext.getDocument()
                                            val startOffset = insertionContext.getStartOffset()
                                            val tailOffset = insertionContext.getTailOffset()

                                            val view = ConnectionManager.getInstance().getView(connectionPack, schemaName, it)

                                            val string = if (view == null) "$it {\n    \n}\n" else EntityFactory.generateViewText(view);

                                            document.replaceString(startOffset, tailOffset, string);
                                            insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length);
                                        }.
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )
        }

    }

}