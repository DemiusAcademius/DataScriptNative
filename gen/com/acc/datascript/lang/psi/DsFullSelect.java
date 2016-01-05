// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsFullSelect extends PsiElement {

  @NotNull
  DsFromClause getFromClause();

  @Nullable
  DsGroupClause getGroupClause();

  @Nullable
  DsOrderClause getOrderClause();

  @NotNull
  DsSelectClause getSelectClause();

  @Nullable
  DsWhereClause getWhereClause();

}
