package com.acc.datascript.lang.completion

import com.acc.datascript.lang.extensions.getTableDefinitions
import com.acc.datascript.lang.extensions.hasPrimaryKey
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.DsNamespaceSection
import com.acc.datascript.lang.psi.DsSchemaSection
import com.acc.datascript.resources.ConnectionManager
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
class EntitiesProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val namespace = PsiTreeUtil.getParentOfType(parameters.position, DsNamespaceSection::class.java)!!
        val currentEntities = namespace.entityDefinitionList.filter { it.qualifiedName != null }.map { it.qualifiedName!!.text }.toSet()

        val tables = getTableDefinitions(parameters.position.project).filter {
            val schema = PsiTreeUtil.getParentOfType(it, DsSchemaSection::class.java)!!.name
            val tableName = it.name!!
            !currentEntities.containsRaw("$schema.$tableName")
        }

        if (tables.size > 0) {
            resultSet.addAllElements(
                    tables.filter { it.name != null }.
                            map {
                                val schema = PsiTreeUtil.getParentOfType(it, DsSchemaSection::class.java)!!.name
                                val tableName = it.name!!
                                LookupElementBuilder.create(tableName).withTypeText(schema, true).
                                        withCaseSensitivity(false).
                                        withInsertHandler { insertionContext, lookupElement ->
                                            val document = insertionContext.document
                                            val startOffset = insertionContext.startOffset
                                            val tailOffset = insertionContext.tailOffset

                                            val functions = "insert, index" + if (it.hasPrimaryKey) ", find, update, delete" else ""
                                            val string = "$schema.$tableName {\n    $functions\n}\n"

                                            document.replaceString(startOffset, tailOffset, string);
                                            insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length - 3);
                                        }.
                                        withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                            }
            )
        }
    }
}