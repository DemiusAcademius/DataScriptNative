// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsEntityDefinition extends PsiElement {

  @NotNull
  List<DsEntityFunction> getEntityFunctionList();

  @NotNull
  List<DsEntityQueryGenerator> getEntityQueryGeneratorList();

  @Nullable
  DsQualifiedName getQualifiedName();

}
