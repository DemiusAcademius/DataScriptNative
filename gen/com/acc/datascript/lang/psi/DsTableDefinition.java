// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsTableDefinition extends PsiElement {

  @NotNull
  List<DsColumn> getColumnList();

  @Nullable
  DsPrimaryKeyClause getPrimaryKeyClause();

  @Nullable
  PsiElement getId();

}
