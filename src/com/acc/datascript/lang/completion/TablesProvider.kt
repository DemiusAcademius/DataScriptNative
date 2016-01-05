package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getConnectionPack
import com.acc.datascript.lang.extensions.getSchema
import com.acc.datascript.lang.extensions.getTableNames
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
class TablesProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val schemaSection = getSchema(parameters.originalFile)
        val schemaName = schemaSection.name
        val connectionPack = getConnectionPack(schemaSection)

        if (connectionPack != null && schemaName != null) {
            val connectionManager = ConnectionManager.getInstance()
            val currentTables = getTableNames(schemaSection).toSet()

            resultSet.addAllElements(
                    connectionManager.
                            getTables(connectionPack, schemaName).
                            filter { !currentTables.containsRaw(it) }.
                            map {
                                LookupElementBuilder.create(it).
                                        withCaseSensitivity(false).
                                        withInsertHandler { insertionContext, lookupElement ->
                                            val document = insertionContext.getDocument()
                                            val startOffset = insertionContext.getStartOffset()
                                            val tailOffset = insertionContext.getTailOffset()

                                            val table = ConnectionManager.getInstance().getTable(connectionPack, schemaName, it)

                                            val string = if (table == null) "$it {\n    \n}\n" else EntityFactory.generateTableText(table);

                                            document.replaceString(startOffset, tailOffset, string);
                                            insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length);
                                        }.
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )
        }

    }

}