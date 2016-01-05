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

public class DsSelectListClauseImpl extends ASTWrapperPsiElement implements DsSelectListClause {

  public DsSelectListClauseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSelectListClause(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DsAllInGroupQualifier> getAllInGroupQualifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsAllInGroupQualifier.class);
  }

  @Override
  @NotNull
  public List<DsSelectDerivedColumn> getSelectDerivedColumnList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsSelectDerivedColumn.class);
  }

}
