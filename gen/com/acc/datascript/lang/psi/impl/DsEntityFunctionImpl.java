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

public class DsEntityFunctionImpl extends ASTWrapperPsiElement implements DsEntityFunction {

  public DsEntityFunctionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof DsVisitor) ((DsVisitor)visitor).visitEntityFunction(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public DsBatchFunction getBatchFunction() {
    return findChildByClass(DsBatchFunction.class);
  }

  @Override
  @Nullable
  public DsFindFunction getFindFunction() {
    return findChildByClass(DsFindFunction.class);
  }

  @Override
  @Nullable
  public DsIndexFunction getIndexFunction() {
    return findChildByClass(DsIndexFunction.class);
  }

}
