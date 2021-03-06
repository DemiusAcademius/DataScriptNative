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

public class DsEntitySelectImpl extends ASTWrapperPsiElement implements DsEntitySelect {

  public DsEntitySelectImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitEntitySelect(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsHierarchyClause getHierarchyClause() {
    return findChildByClass(DsHierarchyClause.class);
  }

  @Override
  @Nullable
  public DsOrderClause getOrderClause() {
    return findChildByClass(DsOrderClause.class);
  }

  @Override
  @Nullable
  public DsWhereClause getWhereClause() {
    return findChildByClass(DsWhereClause.class);
  }

}
