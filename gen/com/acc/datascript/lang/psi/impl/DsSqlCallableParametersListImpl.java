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

public class DsSqlCallableParametersListImpl extends ASTWrapperPsiElement implements DsSqlCallableParametersList {

  public DsSqlCallableParametersListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSqlCallableParametersList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<DsSqlCallableParameter> getSqlCallableParameterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsSqlCallableParameter.class);
  }

}
