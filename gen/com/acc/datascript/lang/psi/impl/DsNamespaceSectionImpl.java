// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.acc.datascript.lang.psi.DataScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.acc.datascript.lang.psi.*;

public class DsNamespaceSectionImpl extends ASTWrapperPsiElement implements DsNamespaceSection {

  public DsNamespaceSectionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitNamespaceSection(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DsClassDefinition> getClassDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsClassDefinition.class);
  }

  @Override
  @NotNull
  public List<DsEntityDefinition> getEntityDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsEntityDefinition.class);
  }

  @Override
  @NotNull
  public List<DsEnumDefinition> getEnumDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsEnumDefinition.class);
  }

  @Override
  @Nullable
  public DsQualifiedName getQualifiedName() {
    return findChildByClass(DsQualifiedName.class);
  }

}
