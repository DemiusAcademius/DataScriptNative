package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.findTableDefinition
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DataScriptTypes
import com.acc.datascript.lang.psi.DsEntityQueryGenerator
import com.acc.datascript.lang.psi.DsQueryGenerator
import com.acc.datascript.lang.types.inferType
import com.acc.datascript.lang.types.validPrimaryTypes
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

/**
 * Created by demius on 31.12.2015.
 */
class ColumnsProvider: CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val context = parameters.position.context!!

        val nodes = context.node.getChildren(TokenSet.create(DataScriptTypes.ID))
        val nodesCnt = nodes.size

        var alias: String? = null
        var filterPrefix: String? = null

        if (nodesCnt == 1) {
            filterPrefix = getPrefix(nodes[0].text)
        } else if (nodesCnt == 2) {
            alias = nodes[0].text
            filterPrefix = getPrefix(nodes[1].text)
        } else {
            // TODO: super completion
            return
        }

        val commonParent = PsiTreeUtil.findFirstParent(context, { it is DsQueryGenerator || it is DsEntityQueryGenerator })!!
        val tableDefinition = findTableDefinition(commonParent, alias)

        if (tableDefinition != null) {
            resultSet.addAllElements(
                    tableDefinition.columnList.
                            filter {
                                val name = it.name
                                name != null && (filterPrefix == null || name.startsWith(filterPrefix!!,true))
                            }.
                            map { LookupElementBuilder.create(it.name!!).
                                    withCaseSensitivity(false).
                                    withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE) }
            )
        }

    }

    private fun getPrefix(text: String): String? {
        val textLength = text.length
        return if (textLength > 19) text.substring(0, textLength - 19) else null
    }

}