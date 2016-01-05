package com.acc.datascript.lang;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by nataly on 21.12.15.
 */
public class DataScriptLexerAdapter extends FlexAdapter {

    public DataScriptLexerAdapter() {
        super(new _DataScriptLexer((Reader) null));
    }
}
