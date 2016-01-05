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

public class DsSchemaSectionImpl extends ASTWrapperPsiElement implements DsSchemaSection {

  public DsSchemaSectionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitSchemaSection(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsConnection getConnection() {
    return findChildByClass(DsConnection.class);
  }

  @Override
  @NotNull
  public List<DsPackageDefinition> getPackageDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsPackageDefinition.class);
  }

  @Override
  @NotNull
  public List<DsSequenceDefinition> getSequenceDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsSequenceDefinition.class);
  }

  @Override
  @NotNull
  public List<DsTableDefinition> getTableDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsTableDefinition.class);
  }

  @Override
  @NotNull
  public List<DsViewDefinition> getViewDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, DsViewDefinition.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

}
