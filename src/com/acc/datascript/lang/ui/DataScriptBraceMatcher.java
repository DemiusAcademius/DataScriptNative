package com.acc.datascript.lang.ui;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.acc.datascript.lang.psi.DataScriptTypes.*;

/**
 * Created by nataly on 22.12.15.
 */
public class DataScriptBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] pairs = new BracePair[] {new BracePair(LBRACE,RBRACE,false),new BracePair(LBRACKET,RBRACKET,false),new BracePair(LPAREN,RPAREN, false)};

    @Override
    public BracePair[] getPairs() {
        return pairs;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int i) {
        return 0;
    }
}
