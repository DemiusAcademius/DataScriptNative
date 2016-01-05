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

public class DsFullSelectImpl extends ASTWrapperPsiElement implements DsFullSelect {

  public DsFullSelectImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitFullSelect(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DsFromClause getFromClause() {
    return findNotNullChildByClass(DsFromClause.class);
  }

  @Override
  @Nullable
  public DsGroupClause getGroupClause() {
    return findChildByClass(DsGroupClause.class);
  }

  @Override
  @Nullable
  public DsOrderClause getOrderClause() {
    return findChildByClass(DsOrderClause.class);
  }

  @Override
  @NotNull
  public DsSelectClause getSelectClause() {
    return findNotNullChildByClass(DsSelectClause.class);
  }

  @Override
  @Nullable
  public DsWhereClause getWhereClause() {
    return findChildByClass(DsWhereClause.class);
  }

}
