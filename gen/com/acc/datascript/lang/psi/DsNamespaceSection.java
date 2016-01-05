// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsNamespaceSection extends PsiElement {

  @NotNull
  List<DsClassDefinition> getClassDefinitionList();

  @NotNull
  List<DsEntityDefinition> getEntityDefinitionList();

  @NotNull
  List<DsEnumDefinition> getEnumDefinitionList();

  @Nullable
  DsQualifiedName getQualifiedName();

}
