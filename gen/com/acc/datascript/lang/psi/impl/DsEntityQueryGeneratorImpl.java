// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.acc.datascript.lang.psi.DataScriptTypes.*;
import com.acc.datascript.lang.psi.*;

public class DsEntityQueryGeneratorImpl extends DsClassElementImpl implements DsEntityQueryGenerator {

  public DsEntityQueryGeneratorImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitEntityQueryGenerator(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public DsEntitySelect getEntitySelect() {
    return findNotNullChildByClass(DsEntitySelect.class);
  }

  @Override
  @Nullable
  public DsFetchList getFetchList() {
    return findChildByClass(DsFetchList.class);
  }

  @Override
  @Nullable
  public DsFetchOne getFetchOne() {
    return findChildByClass(DsFetchOne.class);
  }

  @Override
  @Nullable
  public DsFetchStream getFetchStream() {
    return findChildByClass(DsFetchStream.class);
  }

  @Override
  @Nullable
  public DsQueryParametersList getQueryParametersList() {
    return findChildByClass(DsQueryParametersList.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
