package com.acc.datascript.lang.completion

import com.acc.datascript.lang.CallableSignature
import com.acc.datascript.lang.extensions.*
import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.*
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.AutoCompletionPolicy
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext
import java.util.*

/**
 * Created by demius on 29.12.2015.
 */

class GenCallablesProvider: CompletionProvider<CompletionParameters>() {

    class CallableHolder(val name: String, val prefix: String, var suffix: String) {
        override fun toString(): String = name
    }

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet) {
        val callables = getCallableDefinitions(parameters.position.project).filter { it.name != null }.sortedBy { getSignature(it) }
        if (callables.isEmpty()) return

        val classDefinition = PsiTreeUtil.getParentOfType(parameters.position, DsClassDefinition::class.java)!!
        val currentDefinitions = classDefinition.classElementList.filter { it is DsCallGenerator }.map {
            it as DsCallGenerator
            CallableSignature(it.qualifiedName.text, it.cardinality ?: 0)
        }.toSet()

        var currentName: String? = null
        var currentCallable: CallableHolder? = null
        var currentCardinality = 0

        val callableList = callables.map {
            val packageSection = PsiTreeUtil.getParentOfType(it, DsPackageDefinition::class.java)!!
            val packagePrefix = if (packageSection.isDefault != null) "" else "." + packageSection.name
            val schema = PsiTreeUtil.getParentOfType(packageSection, DsSchemaSection::class.java)!!.name

            val callableName = it.name!!
            val prefix = schema + packagePrefix

            val fullName = prefix + "." + callableName

            var suffix = ""

            val cardinality = getSignature(it)?.cardinality ?: 0

            if (currentName != null && currentName == fullName) {
                suffix = " [$cardinality]"
                if (currentCallable!!.suffix.length == 0) currentCallable!!.suffix = " [$currentCardinality]"
            }

            val pair = CallableHolder(callableName, prefix, suffix)

            currentName = fullName
            currentCallable = pair
            currentCardinality = cardinality

            pair
        }.filter {
            val len = it.suffix.length
            val cardinality = if (len == 0) 0 else Integer.parseInt(it.suffix.substring(2, len - 1))
            val signature = CallableSignature("${it.prefix}.${it.name}",cardinality)
            !currentDefinitions.contains(signature)
        }

        resultSet.addAllElements(
                callableList.
                        map {
                            LookupElementBuilder.create(it).
                                    appendTailText("${it.suffix} (${it.prefix})",true).
                                    withCaseSensitivity(false).
                                    withInsertHandler { insertionContext, lookupElement ->
                                        val document = insertionContext.document
                                        val startOffset = insertionContext.startOffset
                                        val tailOffset = insertionContext.tailOffset

                                        val string = "${it.prefix}.${it.name}${it.suffix}\n    "

                                        document.replaceString(startOffset, tailOffset, string);
                                        insertionContext.getEditor().getCaretModel().moveToOffset(startOffset + string.length)
                                    }.
                                    withAutoCompletionPolicy(AutoCompletionPolicy.ALWAYS_AUTOCOMPLETE)
                        }
        )

    }

}