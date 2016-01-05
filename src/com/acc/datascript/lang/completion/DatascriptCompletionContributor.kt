package com.acc.datascript.lang.completion

import com.acc.datascript.lang.DataScriptLanguage.INSTANCE
import com.acc.datascript.lang.psi.*
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType.BASIC
import com.intellij.patterns.PlatformPatterns.psiElement

/**
 * Created by nataly on 25.12.15.
 */

class DatascriptCompletionContributor : CompletionContributor() {

    init {
        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.USE)).withLanguage(INSTANCE),
                ConnectionProvider())

        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.SEQUENCE)).withLanguage(INSTANCE),
                SequencesProvider())

        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.TABLE)).withLanguage(INSTANCE),
                TablesProvider())

        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.VIEW)).withLanguage(INSTANCE),
                ViewsProvider())

        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.ENTITY)).withLanguage(INSTANCE),
                EntitiesProvider())

        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.NEXT)).withLanguage(INSTANCE),
                GenSequencesProvider())

        extend(BASIC,
                psiElement().afterLeaf(psiElement(DataScriptTypes.CALL)).withLanguage(INSTANCE),
                GenCallablesProvider())

        extend(BASIC,
                psiElement(DataScriptTypes.ID).inside(DsDataType::class.java).withLanguage(INSTANCE),
                DataTypesProvider())

        extend(BASIC,
                psiElement().inside(DsSqlSimpleColumnRefExpression::class.java).withLanguage(INSTANCE),
                SimpleColumnsProvider())

        extend(BASIC,
                psiElement().inside(DsSqlParameterExpression::class.java).withLanguage(INSTANCE),
                ParametersProvider())

        extend(BASIC,
                psiElement().
                        inside(DsEntitySelector::class.java).
                        andNot(psiElement().afterLeaf(psiElement(DataScriptTypes.AS))).
                        withLanguage(INSTANCE),
                EntitySelectorProvider())

        extend(BASIC,
                psiElement().inside(DsSqlColumnRefExpression::class.java).withLanguage(INSTANCE),
                ColumnRefProvider())

    }


}
