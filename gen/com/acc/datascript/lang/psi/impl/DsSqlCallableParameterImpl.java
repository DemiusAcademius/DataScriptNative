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

public class DsSqlCallableParameterImpl extends ASTWrapperPsiElement implements DsSqlCallableParameter {

  public DsSqlCallableParameterImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSqlCallableParameter(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DsDataType getDataType() {
    return findNotNullChildByClass(DsDataType.class);
  }

  @Override
  @Nullable
  public DsInModifier getInModifier() {
    return findChildByClass(DsInModifier.class);
  }

  @Override
  @Nullable
  public DsOutModifier getOutModifier() {
    return findChildByClass(DsOutModifier.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
