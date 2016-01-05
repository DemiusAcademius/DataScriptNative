package com.acc.datascript.lang;

import com.intellij.lang.Language;

/**
 * Created by nataly on 21.12.15.
 */
public class DataScriptLanguage extends Language {
    public static final DataScriptLanguage INSTANCE = new DataScriptLanguage();

    private DataScriptLanguage() {
        super("DataScript");
    }
}