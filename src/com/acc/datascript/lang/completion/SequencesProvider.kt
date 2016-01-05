package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getConnectionPack
import com.acc.datascript.lang.extensions.getSchema
import com.acc.datascript.lang.extensions.getSequenceNames
import com.acc.datascript.lang.names.name
import com.acc.datascript.resources.ConnectionManager
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

/**
 * Created by nataly on 26.12.15.
 */
class SequencesProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val schemaSection = getSchema(parameters.originalFile)
        val schemaName = schemaSection.name
        val connectionPack = getConnectionPack(schemaSection)

        if (connectionPack != null && schemaName != null) {
            val connectionManager = ConnectionManager.getInstance()
            val currentSequences = getSequenceNames(schemaSection).toSet()

            resultSet.addAllElements(
                    connectionManager.
                            getSequences(connectionPack, schemaName).
                            filter { !currentSequences.containsRaw(it) }.
                            map {
                                LookupElementBuilder.create(it).
                                        withCaseSensitivity(false).
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )
        }

    }
}