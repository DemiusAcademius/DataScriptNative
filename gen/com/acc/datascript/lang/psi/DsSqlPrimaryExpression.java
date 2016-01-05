// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsSqlPrimaryExpression extends DsSqlExpression {

  @Nullable
  DsQualifiedName getQualifiedName();

  @Nullable
  DsSqlCountFunction getSqlCountFunction();

  @NotNull
  List<DsSqlExpression> getSqlExpressionList();

  @Nullable
  DsSqlFunction getSqlFunction();

}
