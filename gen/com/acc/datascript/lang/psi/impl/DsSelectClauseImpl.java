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

public class DsSelectClauseImpl extends ASTWrapperPsiElement implements DsSelectClause {

  public DsSelectClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSelectClause(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsAllDistinct getAllDistinct() {
    return findChildByClass(DsAllDistinct.class);
  }

  @Override
  @Nullable
  public DsSelectListClause getSelectListClause() {
    return findChildByClass(DsSelectListClause.class);
  }

  @Override
  @Nullable
  public DsSelectStarClause getSelectStarClause() {
    return findChildByClass(DsSelectStarClause.class);
  }

}
