package com.acc.datascript.lang.ui

import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import java.util.*

/**
 * Created by nataly on 02.01.16.
 */
class DataScriptFoldingBuilder: FoldingBuilderEx() {

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<out FoldingDescriptor> {
        val descriptors = ArrayList<FoldingDescriptor>()

        PsiTreeUtil.findChildrenOfType(root, DsEnumDefinition::class.java).forEach {
            val grp = FoldingGroup.newGroup("dsEnums")
            val range = it.textRange
            descriptors.add(
                    object: FoldingDescriptor(it.node, TextRange(range.startOffset, range.endOffset), grp) {
                        override fun getPlaceholderText(): String? = "enum ${it.name}"
                    }
            )
        }

        PsiTreeUtil.findChildrenOfType(root, DsEntityDefinition::class.java).forEach {
            val grp = FoldingGroup.newGroup("dsEntities")
            val range = it.textRange
            descriptors.add(
                    object: FoldingDescriptor(it.node, TextRange(range.startOffset, range.endOffset), grp) {
                        override fun getPlaceholderText(): String? = "entity [${it.qualifiedName?.text}]"
                    }
            )
        }

        PsiTreeUtil.findChildrenOfType(root, DsClassDefinition::class.java).forEach {
            val grp = FoldingGroup.newGroup("dsClasses")
            val range = it.textRange
            descriptors.add(
                    object: FoldingDescriptor(it.node, TextRange(range.startOffset, range.endOffset), grp) {
                        override fun getPlaceholderText(): String? = "class ${it.name}"
                    }
            )
        }

        PsiTreeUtil.findChildrenOfType(root, DsTableDefinition::class.java).forEach {
            val grp = FoldingGroup.newGroup("dsTables")
            val range = it.textRange
            descriptors.add(
                    object: FoldingDescriptor(it.node, TextRange(range.startOffset, range.endOffset), grp) {
                        override fun getPlaceholderText(): String? = "table ${it.name}"
                    }
            )
        }

        PsiTreeUtil.findChildrenOfType(root, DsViewDefinition::class.java).forEach {
            val grp = FoldingGroup.newGroup("dsViews")
            val range = it.textRange
            descriptors.add(
                    object: FoldingDescriptor(it.node, TextRange(range.startOffset, range.endOffset), grp) {
                        override fun getPlaceholderText(): String? = "view ${it.name}"
                    }
            )
        }

        PsiTreeUtil.findChildrenOfType(root, DsPackageDefinition::class.java).forEach {
            val grp = FoldingGroup.newGroup("dsPackages")
            val range = it.textRange
            val name = if (it.isDefault != null) "default" else it.name
            descriptors.add(
                    object: FoldingDescriptor(it.node, TextRange(range.startOffset, range.endOffset), grp) {
                        override fun getPlaceholderText(): String? = "package $name"
                    }
            )
        }

        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String? = "..."
}