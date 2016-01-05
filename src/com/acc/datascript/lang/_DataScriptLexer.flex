package com.acc.datascript.lang;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.acc.datascript.lang.psi.DataScriptTypes.*;

%%

%{
  public _DataScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _DataScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

DATE=d"/"[0-9]+"/"
COMMENT="//".*
INT=[0-9]+
NUMBER=[0-9]+(\.[0-9]*)?
ID=[:letter:][a-zA-Z_0-9]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "["                { return LBRACKET; }
  "]"                { return RBRACKET; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  ","                { return COMMA; }
  "schema"           { return SCHEMA; }
  "namespace"        { return NAMESPACE; }
  "enum"             { return ENUM; }
  "use"              { return USE; }
  "table"            { return TABLE; }
  "view"             { return VIEW; }
  "sequence"         { return SEQUENCE; }
  "package"          { return PACKAGE; }
  "default"          { return DEFAULT; }
  "entity"           { return ENTITY; }
  "class"            { return CLASS; }
  "as"               { return AS; }
  "trans"            { return TRANS; }
  "lat"              { return LAT; }
  "rom"              { return ROM; }
  "primary key"      { return PRIMARY_KEY; }
  "procedure"        { return PROCEDURE; }
  "function"         { return FUNCTION; }
  "return"           { return RETURN; }
  "prepared"         { return PREPARED; }
  "batch"            { return BATCH; }
  "find"             { return FIND; }
  "index"            { return INDEX; }
  "update"           { return UPDATE; }
  "insert"           { return INSERT; }
  "delete"           { return DELETE; }
  "call"             { return CALL; }
  "next"             { return NEXT; }
  "query"            { return QUERY; }
  "prefetch"         { return PREFETCH; }
  "rows"             { return ROWS; }
  "fetch"            { return FETCH; }
  "one"              { return ONE; }
  "list"             { return LIST; }
  "stream"           { return STREAM; }
  "in"               { return IN; }
  "out"              { return OUT; }
  "select"           { return SELECT; }
  "from"             { return FROM; }
  "where"            { return WHERE; }
  "group"            { return GROUP; }
  "having"           { return HAVING; }
  "order"            { return ORDER; }
  "by"               { return BY; }
  "start"            { return START; }
  "with"             { return WITH; }
  "asc"              { return ASC; }
  "desc"             { return DESC; }
  "connect"          { return CONNECT; }
  "nocycle"          { return NOCYCLE; }
  "prior"            { return PRIOR; }
  "int"              { return INT_TYPE; }
  "int?"             { return NULLABLE_INT_TYPE; }
  "long"             { return LONG_TYPE; }
  "long?"            { return NULLABLE_LONG_TYPE; }
  "double"           { return DOUBLE_TYPE; }
  "decimal"          { return DECIMAL_TYPE; }
  "string"           { return STRING_TYPE; }
  "boolean"          { return BOOLEAN_TYPE; }
  "date"             { return DATE_TYPE; }
  "timestamp"        { return TIMESTAMP_TYPE; }
  ";"                { return SEMICOLON; }
  ":"                { return COLON; }
  "-"                { return MINUS; }
  "+"                { return PLUS; }
  "/"                { return DIV; }
  "*"                { return MUL; }
  "||"               { return CONCATENATE; }
  "="                { return EQ; }
  "<>"               { return NEQ; }
  "."                { return DOT; }
  ">"                { return GT; }
  ">="               { return GT_EQ; }
  "<"                { return LT; }
  "<="               { return LT_EQ; }
  "or"               { return OR; }
  "and"              { return AND; }
  "not"              { return NOT; }
  "is"               { return IS; }
  "like"             { return LIKE; }
  "null"             { return NULL; }
  "sysdate"          { return SYSDATE; }
  "count"            { return COUNT; }
  "between"          { return BETWEEN; }
  "all"              { return ALL; }
  "distinct"         { return DISTINCT; }

  {DATE}             { return DATE; }
  {COMMENT}          { return COMMENT; }
  {INT}              { return INT; }
  {NUMBER}           { return NUMBER; }
  {ID}               { return ID; }
  {STRING}           { return STRING; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
