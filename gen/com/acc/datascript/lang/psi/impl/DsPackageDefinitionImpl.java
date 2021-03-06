// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.acc.datascript.lang.psi.DataScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.acc.datascript.lang.psi.*;

public class DsPackageDefinitionImpl extends ASTWrapperPsiElement implements DsPackageDefinition {

  public DsPackageDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitPackageDefinition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsIsDefault getIsDefault() {
    return findChildByClass(DsIsDefault.class);
  }

  @Override
  @NotNull
  public List<DsSqlCallable> getSqlCallableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsSqlCallable.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

}
