package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.findTableDefinition
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.*
import com.acc.datascript.lang.types.DataScriptType
import com.acc.datascript.lang.types.inferType
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import java.util.*

/**
 * Created by demius on 31.12.2015.
 */
class ColumnRefProvider : CompletionProvider<CompletionParameters>() {

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

        val lookupElements = ArrayList<LookupElement>()

        provideColumns(context, alias, filterPrefix, lookupElements)

        if (alias == null)
            provideEnumLiterals(context, filterPrefix, lookupElements)

        resultSet.addAllElements(lookupElements)
    }

    private fun provideEnumLiterals(context: PsiElement, filterPrefix: String?, lookupElements: ArrayList<LookupElement>) {
        val parentExpr = context.parent
        val operand = when (parentExpr) {
            is DsSqlComparisonExpression -> {
                val op = parentExpr.sqlComparisonOp.text
                if (op == "=" || op == "<>") parentExpr.sqlExpressionList[0] else null
            }
            is DsSqlInExpression -> parentExpr.sqlExpressionList[0]
            is DsSqlBetweenExpression -> parentExpr.sqlExpressionList[0]
            else -> null
        }
        if (operand != null && operand != context) {
            val type = operand.inferType
            if (type != null && type is DataScriptType.Enum) {
                lookupElements.addAll(
                        type.enumRef.enumElementList.filter {
                            val name = it.name
                            name != null && (filterPrefix == null || name.startsWith(filterPrefix!!, true))
                        }.
                        map {
                            LookupElementBuilder.create(it.name!!).
                                    withTypeText(type.enumRef.name, true).
                                    withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                        }
                )
            }
        }
    }

    private fun provideColumns(context: PsiElement, alias: String?, filterPrefix: String?, lookupElements: ArrayList<LookupElement>) {
        val commonParent = PsiTreeUtil.findFirstParent(context, { it is DsQueryGenerator || it is DsEntityQueryGenerator })!!
        val tableDefinition = findTableDefinition(commonParent, alias)

        if (tableDefinition != null) {
            lookupElements.addAll(
                    tableDefinition.columnList.
                            filter {
                                val name = it.name
                                name != null && (filterPrefix == null || name.startsWith(filterPrefix!!, true))
                            }.
                            map {
                                LookupElementBuilder.create(it.name!!).
                                        withTypeText(tableDefinition.name, true).
                                        withCaseSensitivity(false).
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )
        }

    }

    private fun getPrefix(text: String): String? {
        val textLength = text.length
        return if (textLength > 19) text.substring(0, textLength - 19) else null
    }

}