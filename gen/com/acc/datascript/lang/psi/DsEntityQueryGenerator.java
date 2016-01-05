// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DsEntityQueryGenerator extends DsClassElement {

  @NotNull
  DsEntitySelect getEntitySelect();

  @Nullable
  DsFetchList getFetchList();

  @Nullable
  DsFetchOne getFetchOne();

  @Nullable
  DsFetchStream getFetchStream();

  @Nullable
  DsQueryParametersList getQueryParametersList();

  @NotNull
  PsiElement getId();

}
