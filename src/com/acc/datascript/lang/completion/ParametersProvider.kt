package com.acc.datascript.lang.completion

import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsEntityQueryGenerator
import com.acc.datascript.lang.psi.DsQueryGenerator
import com.acc.datascript.lang.psi.DsQueryParameter
import com.acc.datascript.lang.types.inferType
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
class ParametersProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val commonParent = PsiTreeUtil.findFirstParent(parameters.position, { it is DsQueryGenerator || it is DsEntityQueryGenerator })

        resultSet.addAllElements(
                PsiTreeUtil.findChildrenOfType(commonParent, DsQueryParameter::class.java).map {
                    LookupElementBuilder.create(it.name).withTypeText(it.inferType.toString(),true).
                            withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                }

        )
    }
}