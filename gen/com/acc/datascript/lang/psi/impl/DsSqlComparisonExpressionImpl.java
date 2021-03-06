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

public class DsSqlComparisonExpressionImpl extends DsSqlExpressionImpl implements DsSqlComparisonExpression {

  public DsSqlComparisonExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSqlComparisonExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DsSqlComparisonOp getSqlComparisonOp() {
    return findNotNullChildByClass(DsSqlComparisonOp.class);
  }

  @Override
  @NotNull
  public List<DsSqlExpression> getSqlExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsSqlExpression.class);
  }

  @Override
  @Nullable
  public DsSqlOra8RightOuter getSqlOra8RightOuter() {
    return findChildByClass(DsSqlOra8RightOuter.class);
  }

}
