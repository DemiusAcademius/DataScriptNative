package com.acc.datascript.lang;

import com.acc.datascript.Icons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by nataly on 21.12.15.
 */
public class DataScriptFileType extends LanguageFileType {

    public static final DataScriptFileType INSTANCE = new DataScriptFileType();

    private DataScriptFileType() {
        super(DataScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Datascript file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Datascript language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ds";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Icons.SQL_FILE;
    }
}
