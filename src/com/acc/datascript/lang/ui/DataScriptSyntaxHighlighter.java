package com.acc.datascript.lang.ui;

import com.acc.datascript.lang.DataScriptLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.acc.datascript.lang.psi.DataScriptTypes.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by nataly on 22.12.15.
 */
public class DataScriptSyntaxHighlighter extends SyntaxHighlighterBase {

    //public static final TextAttributesKey SEPARATOR = createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY = createTextAttributesKey("DATASRIPT_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey TYPE = createTextAttributesKey("DATASRIPT_TYPE", DefaultLanguageHighlighterColors.STATIC_FIELD);
    public static final TextAttributesKey SQL = createTextAttributesKey("DATASRIPT_SQL", DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE);
    public static final TextAttributesKey MINOR_KEY = createTextAttributesKey("MINOR_KEY", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
    public static final TextAttributesKey VALUE = createTextAttributesKey("DATASRIPT_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("DATASRIPT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("DATASRIPT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    // private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] MINTOR_KEYS = new TextAttributesKey[]{MINOR_KEY};
    private static final TextAttributesKey[] TYPE_KEYS = new TextAttributesKey[]{TYPE};
    private static final TextAttributesKey[] SQL_KEYS = new TextAttributesKey[]{SQL};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final Set<IElementType> keywords = Stream.of(SCHEMA, NAMESPACE, TABLE, VIEW, SEQUENCE, PACKAGE, DEFAULT, PROCEDURE, FUNCTION,
            RETURN, ENUM, PRIMARY_KEY,
            ENTITY, CLASS, CALL, NEXT, QUERY, FIND, INDEX, INSERT, UPDATE, DELETE, COLON, USE).collect(Collectors.toSet());

    private static final Set<IElementType> sqlKeywords = Stream.of(SELECT, FROM, WHERE, GROUP, BY, ORDER, BY,
            START, WITH, CONNECT, HAVING, PRIOR, NOCYCLE, AND, OR, NOT, IS, NULL, SYSDATE, ONE, LIST, STREAM, BETWEEN, IN, OUT, ALL, DISTINCT).collect(Collectors.toSet());

    private static final Set<IElementType> minorKeywords = Stream.of(AS, PREFETCH, FETCH, BATCH, ROWS, PREPARED, COUNT).collect(Collectors.toSet());

    private static final Set<IElementType> types = Stream.of(INT_TYPE, NULLABLE_INT_TYPE, LONG_TYPE, NULLABLE_LONG_TYPE, DOUBLE_TYPE, DECIMAL_TYPE,
            BOOLEAN_TYPE, STRING_TYPE, DATE_TYPE, TIMESTAMP_TYPE).collect(Collectors.toSet());

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new DataScriptLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (keywords.contains(tokenType)) {
            return KEY_KEYS;
        } else if (minorKeywords.contains(tokenType)) {
            return MINTOR_KEYS;
        } else if (types.contains(tokenType)) {
            return TYPE_KEYS;
        } else if (sqlKeywords.contains(tokenType)) {
            return SQL_KEYS;
        } else if (tokenType.equals(STRING)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(DATE)) {
            return VALUE_KEYS;
        } else if (tokenType.equals(INT)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
