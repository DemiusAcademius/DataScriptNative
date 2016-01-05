// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsSqlFunctionExpression extends DsSqlExpression {

  @NotNull
  DsQualifiedName getQualifiedName();

  @NotNull
  List<DsSqlExpression> getSqlExpressionList();

}
