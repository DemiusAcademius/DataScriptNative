// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.acc.datascript.lang.psi.DataScriptTypes.*;
import com.acc.datascript.lang.psi.*;

public class DsSqlCountFunctionExpressionImpl extends DsSqlExpressionImpl implements DsSqlCountFunctionExpression {

  public DsSqlCountFunctionExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSqlCountFunctionExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsSqlExpression getSqlExpression() {
    return findChildByClass(DsSqlExpression.class);
  }

}