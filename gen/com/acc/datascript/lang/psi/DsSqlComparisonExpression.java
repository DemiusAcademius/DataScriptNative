// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsSqlComparisonExpression extends DsSqlExpression {

  @NotNull
  DsSqlComparisonOp getSqlComparisonOp();

  @NotNull
  List<DsSqlExpression> getSqlExpressionList();

  @Nullable
  DsSqlOra8RightOuter getSqlOra8RightOuter();

}
