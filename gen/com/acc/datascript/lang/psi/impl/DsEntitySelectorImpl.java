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

public class DsEntitySelectorImpl extends ASTWrapperPsiElement implements DsEntitySelector {

  public DsEntitySelectorImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitEntitySelector(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsAliasClause getAliasClause() {
    return findChildByClass(DsAliasClause.class);
  }

  @Override
  @Nullable
  public DsQualifiedName getQualifiedName() {
    return findChildByClass(DsQualifiedName.class);
  }

  @Override
  @Nullable
  public DsSubSelect getSubSelect() {
    return findChildByClass(DsSubSelect.class);
  }

}
