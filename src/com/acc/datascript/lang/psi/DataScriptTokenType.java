package com.acc.datascript.lang.psi;

import com.acc.datascript.lang.DataScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by nataly on 21.12.15.
 */
public class DataScriptTokenType extends IElementType {

    public DataScriptTokenType(@NotNull @NonNls String debugName) {
        super(debugName, DataScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "DataScriptTokenType." + super.toString();
    }
}
