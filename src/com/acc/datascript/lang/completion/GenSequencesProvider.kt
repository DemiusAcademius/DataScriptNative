package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getSequenceDefinitions
import com.acc.datascript.lang.extensions.getTableDefinitions
import com.acc.datascript.lang.extensions.hasPrimaryKey
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsClassDefinition
import com.acc.datascript.lang.psi.DsSchemaSection
import com.acc.datascript.lang.psi.DsSequenceGenerator
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
class GenSequencesProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val classDefinition = PsiTreeUtil.getParentOfType(parameters.position, DsClassDefinition::class.java)!!
        val currentSequences = classDefinition.classElementList.filter { it is DsSequenceGenerator }.map { (it as DsSequenceGenerator).qualifiedName.text }.toSet()

        val sequences = getSequenceDefinitions(parameters.position.project).filter {
            val schema = PsiTreeUtil.getParentOfType(it, DsSchemaSection::class.java)!!.name
            val seqName = it.name!!
            currentSequences.containsRaw("$schema.$seqName")
        }

        if (sequences.size > 0) {
            resultSet.addAllElements(
                    sequences.filter { it.name != null }.
                            map {
                                val schema = PsiTreeUtil.getParentOfType(it, DsSchemaSection::class.java)!!.name
                                val seqName = it.name!!
                                LookupElementBuilder.create(seqName).withTypeText(schema, true).
                                        withCaseSensitivity(false).
                                        withInsertHandler { insertionContext, lookupElement ->
                                            val document = insertionContext.getDocument()
                                            val startOffset = insertionContext.getStartOffset()
                                            val tailOffset = insertionContext.getTailOffset()

                                            val string = "$schema.$seqName\n    "

                                            document.replaceString(startOffset, tailOffset, string);
                                            insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length);
                                        }.
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )

        }
    }

}