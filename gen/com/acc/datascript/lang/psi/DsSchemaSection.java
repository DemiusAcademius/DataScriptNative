// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsSchemaSection extends PsiElement {

  @Nullable
  DsConnection getConnection();

  @NotNull
  List<DsPackageDefinition> getPackageDefinitionList();

  @NotNull
  List<DsSequenceDefinition> getSequenceDefinitionList();

  @NotNull
  List<DsTableDefinition> getTableDefinitionList();

  @NotNull
  List<DsViewDefinition> getViewDefinitionList();

  @Nullable
  PsiElement getId();

}
