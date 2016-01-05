package com.acc.datascript.lang.psi;

import com.acc.datascript.lang.DataScriptFileType;
import com.acc.datascript.lang.DataScriptLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by nataly on 21.12.15.
 */
public class DataScriptFile extends PsiFileBase {

    public DataScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, DataScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return DataScriptFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "DataScript File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }

}
