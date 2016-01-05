// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsColumn extends PsiElement {

  @NotNull
  DsSqlType getSqlType();

  @Nullable
  DsTransModifier getTransModifier();

  @Nullable
  DsTypeModifier getTypeModifier();

  @NotNull
  PsiElement getId();

}
