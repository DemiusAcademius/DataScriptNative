// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.acc.datascript.lang.psi.DataScriptTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class DataScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ALIAS_CLAUSE) {
      r = aliasClause(b, 0);
    }
    else if (t == ALL_DISTINCT) {
      r = allDistinct(b, 0);
    }
    else if (t == ALL_IN_GROUP_QUALIFIER) {
      r = allInGroupQualifier(b, 0);
    }
    else if (t == BATCH_FUNCTION) {
      r = batchFunction(b, 0);
    }
    else if (t == CALL_GENERATOR) {
      r = callGenerator(b, 0);
    }
    else if (t == CALLABLE_CARDINALITY) {
      r = callableCardinality(b, 0);
    }
    else if (t == CLASS_DEFINITION) {
      r = classDefinition(b, 0);
    }
    else if (t == CLASS_ELEMENT) {
      r = classElement(b, 0);
    }
    else if (t == COLUMN) {
      r = column(b, 0);
    }
    else if (t == CONNECT_BY_C_LAUSE) {
      r = connectByCLause(b, 0);
    }
    else if (t == CONNECTION) {
      r = connection(b, 0);
    }
    else if (t == DATA_TYPE) {
      r = dataType(b, 0);
    }
    else if (t == ENTITY_DEFINITION) {
      r = entityDefinition(b, 0);
    }
    else if (t == ENTITY_FUNCTION) {
      r = entityFunction(b, 0);
    }
    else if (t == ENTITY_QUERY_GENERATOR) {
      r = entityQueryGenerator(b, 0);
    }
    else if (t == ENTITY_SELECT) {
      r = entitySelect(b, 0);
    }
    else if (t == ENTITY_SELECTOR) {
      r = entitySelector(b, 0);
    }
    else if (t == ENUM_DEFINITION) {
      r = enumDefinition(b, 0);
    }
    else if (t == ENUM_ELEMENT) {
      r = enumElement(b, 0);
    }
    else if (t == FETCH_LIST) {
      r = fetchList(b, 0);
    }
    else if (t == FETCH_ONE) {
      r = fetchOne(b, 0);
    }
    else if (t == FETCH_STREAM) {
      r = fetchStream(b, 0);
    }
    else if (t == FIND_FUNCTION) {
      r = findFunction(b, 0);
    }
    else if (t == FROM_CLAUSE) {
      r = fromClause(b, 0);
    }
    else if (t == FULL_SELECT) {
      r = fullSelect(b, 0);
    }
    else if (t == GROUP_CLAUSE) {
      r = groupClause(b, 0);
    }
    else if (t == HAVING_CLAUSE) {
      r = havingClause(b, 0);
    }
    else if (t == HIERARCHY_CLAUSE) {
      r = hierarchyClause(b, 0);
    }
    else if (t == IN_MODIFIER) {
      r = inModifier(b, 0);
    }
    else if (t == INDEX_FUNCTION) {
      r = indexFunction(b, 0);
    }
    else if (t == IS_DEFAULT) {
      r = isDefault(b, 0);
    }
    else if (t == NAMESCPACE_RECOVER) {
      r = namescpaceRecover(b, 0);
    }
    else if (t == NAMESPACE_SECTION) {
      r = namespaceSection(b, 0);
    }
    else if (t == ORDER_CLAUSE) {
      r = orderClause(b, 0);
    }
    else if (t == OUT_MODIFIER) {
      r = outModifier(b, 0);
    }
    else if (t == PACKAGE_DEFINITION) {
      r = packageDefinition(b, 0);
    }
    else if (t == PREFETCH_STATEMENT) {
      r = prefetchStatement(b, 0);
    }
    else if (t == PRIMARY_KEY_CLAUSE) {
      r = primaryKeyClause(b, 0);
    }
    else if (t == QUALIFIED_NAME) {
      r = qualifiedName(b, 0);
    }
    else if (t == QUERY_GENERATOR) {
      r = queryGenerator(b, 0);
    }
    else if (t == QUERY_PARAMETER) {
      r = queryParameter(b, 0);
    }
    else if (t == QUERY_PARAMETERS_LIST) {
      r = queryParametersList(b, 0);
    }
    else if (t == SCHEMA_RECOVER) {
      r = schemaRecover(b, 0);
    }
    else if (t == SCHEMA_SECTION) {
      r = schemaSection(b, 0);
    }
    else if (t == SELECT_CLAUSE) {
      r = selectClause(b, 0);
    }
    else if (t == SELECT_DERIVED_COLUMN) {
      r = selectDerivedColumn(b, 0);
    }
    else if (t == SELECT_LIST_CLAUSE) {
      r = selectListClause(b, 0);
    }
    else if (t == SELECT_STAR_CLAUSE) {
      r = selectStarClause(b, 0);
    }
    else if (t == SEQUENCE_DEFINITION) {
      r = sequenceDefinition(b, 0);
    }
    else if (t == SEQUENCE_GENERATOR) {
      r = sequenceGenerator(b, 0);
    }
    else if (t == SORT_ORDER) {
      r = sortOrder(b, 0);
    }
    else if (t == SORT_SPECIFICATION) {
      r = sortSpecification(b, 0);
    }
    else if (t == SQL_AND_EXPRESSION) {
      r = sqlAndExpression(b, 0);
    }
    else if (t == SQL_ATOMIC_LIST) {
      r = sqlAtomicList(b, 0);
    }
    else if (t == SQL_BETWEEN_EXPRESSION) {
      r = sqlBetweenExpression(b, 0);
    }
    else if (t == SQL_CALLABLE) {
      r = sqlCallable(b, 0);
    }
    else if (t == SQL_CALLABLE_PARAMETER) {
      r = sqlCallableParameter(b, 0);
    }
    else if (t == SQL_CALLABLE_PARAMETERS_LIST) {
      r = sqlCallableParametersList(b, 0);
    }
    else if (t == SQL_COLUMN_REF_EXPRESSION) {
      r = sqlColumnRefExpression(b, 0);
    }
    else if (t == SQL_COMPARISON_EXPRESSION) {
      r = sqlComparisonExpression(b, 0);
    }
    else if (t == SQL_COMPARISON_OP) {
      r = sqlComparisonOp(b, 0);
    }
    else if (t == SQL_COUNT_FUNCTION_EXPRESSION) {
      r = sqlCountFunctionExpression(b, 0);
    }
    else if (t == SQL_DATE_LITERAL_EXPRESSION) {
      r = sqlDateLiteralExpression(b, 0);
    }
    else if (t == SQL_EXPRESSION) {
      r = sqlExpression(b, 0);
    }
    else if (t == SQL_FUNCTION_CALLABLE) {
      r = sqlFunctionCallable(b, 0);
    }
    else if (t == SQL_FUNCTION_EXPRESSION) {
      r = sqlFunctionExpression(b, 0);
    }
    else if (t == SQL_IN_EXPRESSION) {
      r = sqlInExpression(b, 0);
    }
    else if (t == SQL_INT_LITERAL_EXPRESSION) {
      r = sqlIntLiteralExpression(b, 0);
    }
    else if (t == SQL_MUL_OR_DIV_EXPRESSION) {
      r = sqlMulOrDivExpression(b, 0);
    }
    else if (t == SQL_MUL_OR_DIV_OP) {
      r = sqlMulOrDivOp(b, 0);
    }
    else if (t == SQL_NOT_EXPRESSION) {
      r = sqlNotExpression(b, 0);
    }
    else if (t == SQL_NULL_LITERAL_EXPRESSION) {
      r = sqlNullLiteralExpression(b, 0);
    }
    else if (t == SQL_OR_EXPRESSION) {
      r = sqlOrExpression(b, 0);
    }
    else if (t == SQL_ORA_8_RIGHT_OUTER) {
      r = sqlOra8RightOuter(b, 0);
    }
    else if (t == SQL_PARAMETER_EXPRESSION) {
      r = sqlParameterExpression(b, 0);
    }
    else if (t == SQL_PARANTHESIS_EXPRESSION) {
      r = sqlParanthesisExpression(b, 0);
    }
    else if (t == SQL_PLUS_OR_MINUS_EXPRESSION) {
      r = sqlPlusOrMinusExpression(b, 0);
    }
    else if (t == SQL_PLUS_OR_MINUS_OP) {
      r = sqlPlusOrMinusOp(b, 0);
    }
    else if (t == SQL_PROCEDURE_CALLABLE) {
      r = sqlProcedureCallable(b, 0);
    }
    else if (t == SQL_SIMPLE_COLUMN_REF_EXPRESSION) {
      r = sqlSimpleColumnRefExpression(b, 0);
    }
    else if (t == SQL_STRING_LITERAL_EXPRESSION) {
      r = sqlStringLiteralExpression(b, 0);
    }
    else if (t == SQL_SYS_DATE_LITERAL_EXPRESSION) {
      r = sqlSysDateLiteralExpression(b, 0);
    }
    else if (t == SQL_TYPE) {
      r = sqlType(b, 0);
    }
    else if (t == SUB_SELECT) {
      r = subSelect(b, 0);
    }
    else if (t == TABLE_DEFINITION) {
      r = tableDefinition(b, 0);
    }
    else if (t == TRANS_LAT) {
      r = transLat(b, 0);
    }
    else if (t == TRANS_MODIFIER) {
      r = transModifier(b, 0);
    }
    else if (t == TRANS_ROM) {
      r = transRom(b, 0);
    }
    else if (t == TYPE_MODIFIER) {
      r = typeModifier(b, 0);
    }
    else if (t == VIEW_DEFINITION) {
      r = viewDefinition(b, 0);
    }
    else if (t == WHERE_CLAUSE) {
      r = whereClause(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return datascriptFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(SQL_CALLABLE, SQL_FUNCTION_CALLABLE, SQL_PROCEDURE_CALLABLE),
    create_token_set_(CALL_GENERATOR, CLASS_ELEMENT, ENTITY_QUERY_GENERATOR, QUERY_GENERATOR,
      SEQUENCE_GENERATOR),
    create_token_set_(SQL_AND_EXPRESSION, SQL_BETWEEN_EXPRESSION, SQL_COLUMN_REF_EXPRESSION, SQL_COMPARISON_EXPRESSION,
      SQL_COUNT_FUNCTION_EXPRESSION, SQL_DATE_LITERAL_EXPRESSION, SQL_EXPRESSION, SQL_FUNCTION_EXPRESSION,
      SQL_INT_LITERAL_EXPRESSION, SQL_IN_EXPRESSION, SQL_MUL_OR_DIV_EXPRESSION, SQL_NOT_EXPRESSION,
      SQL_NULL_LITERAL_EXPRESSION, SQL_OR_EXPRESSION, SQL_PARAMETER_EXPRESSION, SQL_PARANTHESIS_EXPRESSION,
      SQL_PLUS_OR_MINUS_EXPRESSION, SQL_SIMPLE_COLUMN_REF_EXPRESSION, SQL_STRING_LITERAL_EXPRESSION, SQL_SYS_DATE_LITERAL_EXPRESSION),
  };

  /* ********************************************************** */
  // AS ID
  public static boolean aliasClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasClause")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, ID);
    exit_section_(b, m, ALIAS_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // ALL | DISTINCT
  public static boolean allDistinct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "allDistinct")) return false;
    if (!nextTokenIs(b, "<all distinct>", ALL, DISTINCT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<all distinct>");
    r = consumeToken(b, ALL);
    if (!r) r = consumeToken(b, DISTINCT);
    exit_section_(b, l, m, ALL_DISTINCT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID '.' '*'
  public static boolean allInGroupQualifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "allInGroupQualifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && consumeToken(b, DOT);
    r = r && consumeToken(b, MUL);
    exit_section_(b, m, ALL_IN_GROUP_QUALIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // BATCH? (UPDATE|INSERT|DELETE)
  public static boolean batchFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<batch function>");
    r = batchFunction_0(b, l + 1);
    r = r && batchFunction_1(b, l + 1);
    exit_section_(b, l, m, BATCH_FUNCTION, r, false, null);
    return r;
  }

  // BATCH?
  private static boolean batchFunction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFunction_0")) return false;
    consumeToken(b, BATCH);
    return true;
  }

  // UPDATE|INSERT|DELETE
  private static boolean batchFunction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "batchFunction_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UPDATE);
    if (!r) r = consumeToken(b, INSERT);
    if (!r) r = consumeToken(b, DELETE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CALL qualifiedName callableCardinality?
  public static boolean callGenerator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callGenerator")) return false;
    if (!nextTokenIs(b, CALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL);
    r = r && qualifiedName(b, l + 1);
    r = r && callGenerator_2(b, l + 1);
    exit_section_(b, m, CALL_GENERATOR, r);
    return r;
  }

  // callableCardinality?
  private static boolean callGenerator_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callGenerator_2")) return false;
    callableCardinality(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' INT ']'
  public static boolean callableCardinality(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callableCardinality")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && consumeToken(b, INT);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, CALLABLE_CARDINALITY, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS ID '{' classElement* '}'
  public static boolean classDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<class definition>");
    r = consumeTokens(b, 1, CLASS, ID);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LBRACE));
    r = p && report_error_(b, classDefinition_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, CLASS_DEFINITION, r, p, namescpaceRecover_parser_);
    return r || p;
  }

  // classElement*
  private static boolean classDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDefinition_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!classElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "classDefinition_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // sequenceGenerator | callGenerator | queryGenerator
  public static boolean classElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<class element>");
    r = sequenceGenerator(b, l + 1);
    if (!r) r = callGenerator(b, l + 1);
    if (!r) r = queryGenerator(b, l + 1);
    exit_section_(b, l, m, CLASS_ELEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID sqlType typeModifier? transModifier?
  public static boolean column(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "column")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && sqlType(b, l + 1);
    r = r && column_2(b, l + 1);
    r = r && column_3(b, l + 1);
    exit_section_(b, m, COLUMN, r);
    return r;
  }

  // typeModifier?
  private static boolean column_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "column_2")) return false;
    typeModifier(b, l + 1);
    return true;
  }

  // transModifier?
  private static boolean column_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "column_3")) return false;
    transModifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<param>> ( ',' <<param>> ) *
  static boolean comma_separated_list(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && comma_separated_list_1(b, l + 1, _param);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' <<param>> ) *
  private static boolean comma_separated_list_1(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!comma_separated_list_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "comma_separated_list_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' <<param>>
  private static boolean comma_separated_list_1_0(PsiBuilder b, int l, final Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONNECT BY NOCYCLE? PRIOR? sqlExpression
  public static boolean connectByCLause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connectByCLause")) return false;
    if (!nextTokenIs(b, CONNECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONNECT, BY);
    r = r && connectByCLause_2(b, l + 1);
    r = r && connectByCLause_3(b, l + 1);
    r = r && sqlExpression(b, l + 1);
    exit_section_(b, m, CONNECT_BY_C_LAUSE, r);
    return r;
  }

  // NOCYCLE?
  private static boolean connectByCLause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connectByCLause_2")) return false;
    consumeToken(b, NOCYCLE);
    return true;
  }

  // PRIOR?
  private static boolean connectByCLause_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connectByCLause_3")) return false;
    consumeToken(b, PRIOR);
    return true;
  }

  /* ********************************************************** */
  // USE ID STRING
  public static boolean connection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connection")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<connection>");
    r = consumeTokens(b, 1, USE, ID, STRING);
    p = r; // pin = 1
    exit_section_(b, l, m, CONNECTION, r, p, schemaRecover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // sqlType | ID
  public static boolean dataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<data type>");
    r = sqlType(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, DATA_TYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // namespaceSection | schemaSection
  static boolean datascriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datascriptFile")) return false;
    if (!nextTokenIs(b, "", NAMESPACE, SCHEMA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namespaceSection(b, l + 1);
    if (!r) r = schemaSection(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ENTITY qualifiedName '{'
  //         <<comma_separated_list ( entityFunction )>>
  //         entityQueryGenerator*
  //         '}'
  public static boolean entityDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<entity definition>");
    r = consumeToken(b, ENTITY);
    p = r; // pin = 1
    r = r && report_error_(b, qualifiedName(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, comma_separated_list(b, l + 1, entityDefinition_3_0_parser_)) && r;
    r = p && report_error_(b, entityDefinition_4(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, ENTITY_DEFINITION, r, p, namescpaceRecover_parser_);
    return r || p;
  }

  // ( entityFunction )
  private static boolean entityDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entityFunction(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // entityQueryGenerator*
  private static boolean entityDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityDefinition_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!entityQueryGenerator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entityDefinition_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // PREPARED? (findFunction|indexFunction|batchFunction)
  public static boolean entityFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityFunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<entity function>");
    r = entityFunction_0(b, l + 1);
    r = r && entityFunction_1(b, l + 1);
    exit_section_(b, l, m, ENTITY_FUNCTION, r, false, null);
    return r;
  }

  // PREPARED?
  private static boolean entityFunction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityFunction_0")) return false;
    consumeToken(b, PREPARED);
    return true;
  }

  // findFunction|indexFunction|batchFunction
  private static boolean entityFunction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityFunction_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = findFunction(b, l + 1);
    if (!r) r = indexFunction(b, l + 1);
    if (!r) r = batchFunction(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PREPARED? QUERY ID queryParametersList? '{' entitySelect '}' queryFetch?
  public static boolean entityQueryGenerator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityQueryGenerator")) return false;
    if (!nextTokenIs(b, "<entity query generator>", PREPARED, QUERY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<entity query generator>");
    r = entityQueryGenerator_0(b, l + 1);
    r = r && consumeTokens(b, 0, QUERY, ID);
    r = r && entityQueryGenerator_3(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && entitySelect(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && entityQueryGenerator_7(b, l + 1);
    exit_section_(b, l, m, ENTITY_QUERY_GENERATOR, r, false, null);
    return r;
  }

  // PREPARED?
  private static boolean entityQueryGenerator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityQueryGenerator_0")) return false;
    consumeToken(b, PREPARED);
    return true;
  }

  // queryParametersList?
  private static boolean entityQueryGenerator_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityQueryGenerator_3")) return false;
    queryParametersList(b, l + 1);
    return true;
  }

  // queryFetch?
  private static boolean entityQueryGenerator_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityQueryGenerator_7")) return false;
    queryFetch(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // whereClause? orderClause? hierarchyClause?
  public static boolean entitySelect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelect")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<entity select>");
    r = entitySelect_0(b, l + 1);
    r = r && entitySelect_1(b, l + 1);
    r = r && entitySelect_2(b, l + 1);
    exit_section_(b, l, m, ENTITY_SELECT, r, false, null);
    return r;
  }

  // whereClause?
  private static boolean entitySelect_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelect_0")) return false;
    whereClause(b, l + 1);
    return true;
  }

  // orderClause?
  private static boolean entitySelect_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelect_1")) return false;
    orderClause(b, l + 1);
    return true;
  }

  // hierarchyClause?
  private static boolean entitySelect_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelect_2")) return false;
    hierarchyClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (qualifiedName|subSelect) aliasClause?
  public static boolean entitySelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelector")) return false;
    if (!nextTokenIs(b, "<entity selector>", LPAREN, ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<entity selector>");
    r = entitySelector_0(b, l + 1);
    r = r && entitySelector_1(b, l + 1);
    exit_section_(b, l, m, ENTITY_SELECTOR, r, false, null);
    return r;
  }

  // qualifiedName|subSelect
  private static boolean entitySelector_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelector_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualifiedName(b, l + 1);
    if (!r) r = subSelect(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // aliasClause?
  private static boolean entitySelector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entitySelector_1")) return false;
    aliasClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ENUM ID '{' enumElement* '}'
  public static boolean enumDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<enum definition>");
    r = consumeTokens(b, 1, ENUM, ID);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LBRACE));
    r = p && report_error_(b, enumDefinition_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, ENUM_DEFINITION, r, p, namescpaceRecover_parser_);
    return r || p;
  }

  // enumElement*
  private static boolean enumDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDefinition_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!enumElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumDefinition_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ID (sqlIntLiteralExpression | sqlStringLiteralExpression | sqlNullLiteralExpression) isDefault?
  public static boolean enumElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumElement")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && enumElement_1(b, l + 1);
    r = r && enumElement_2(b, l + 1);
    exit_section_(b, m, ENUM_ELEMENT, r);
    return r;
  }

  // sqlIntLiteralExpression | sqlStringLiteralExpression | sqlNullLiteralExpression
  private static boolean enumElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumElement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlIntLiteralExpression(b, l + 1);
    if (!r) r = sqlStringLiteralExpression(b, l + 1);
    if (!r) r = sqlNullLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // isDefault?
  private static boolean enumElement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumElement_2")) return false;
    isDefault(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FETCH LIST prefetchStatement?
  public static boolean fetchList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fetchList")) return false;
    if (!nextTokenIs(b, FETCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FETCH, LIST);
    r = r && fetchList_2(b, l + 1);
    exit_section_(b, m, FETCH_LIST, r);
    return r;
  }

  // prefetchStatement?
  private static boolean fetchList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fetchList_2")) return false;
    prefetchStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FETCH ONE
  public static boolean fetchOne(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fetchOne")) return false;
    if (!nextTokenIs(b, FETCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FETCH, ONE);
    exit_section_(b, m, FETCH_ONE, r);
    return r;
  }

  /* ********************************************************** */
  // FETCH STREAM prefetchStatement?
  public static boolean fetchStream(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fetchStream")) return false;
    if (!nextTokenIs(b, FETCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FETCH, STREAM);
    r = r && fetchStream_2(b, l + 1);
    exit_section_(b, m, FETCH_STREAM, r);
    return r;
  }

  // prefetchStatement?
  private static boolean fetchStream_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fetchStream_2")) return false;
    prefetchStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FIND
  public static boolean findFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "findFunction")) return false;
    if (!nextTokenIs(b, FIND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FIND);
    exit_section_(b, m, FIND_FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // FROM <<comma_separated_list ( entitySelector )>>
  public static boolean fromClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fromClause")) return false;
    if (!nextTokenIs(b, FROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && comma_separated_list(b, l + 1, fromClause_1_0_parser_);
    exit_section_(b, m, FROM_CLAUSE, r);
    return r;
  }

  // ( entitySelector )
  private static boolean fromClause_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fromClause_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entitySelector(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // selectClause fromClause whereClause? groupClause? orderClause?
  public static boolean fullSelect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSelect")) return false;
    if (!nextTokenIs(b, SELECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selectClause(b, l + 1);
    r = r && fromClause(b, l + 1);
    r = r && fullSelect_2(b, l + 1);
    r = r && fullSelect_3(b, l + 1);
    r = r && fullSelect_4(b, l + 1);
    exit_section_(b, m, FULL_SELECT, r);
    return r;
  }

  // whereClause?
  private static boolean fullSelect_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSelect_2")) return false;
    whereClause(b, l + 1);
    return true;
  }

  // groupClause?
  private static boolean fullSelect_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSelect_3")) return false;
    groupClause(b, l + 1);
    return true;
  }

  // orderClause?
  private static boolean fullSelect_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fullSelect_4")) return false;
    orderClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // GROUP BY <<comma_separated_list ( sqlExpression )>> havingClause?
  public static boolean groupClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupClause")) return false;
    if (!nextTokenIs(b, GROUP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GROUP, BY);
    r = r && comma_separated_list(b, l + 1, groupClause_2_0_parser_);
    r = r && groupClause_3(b, l + 1);
    exit_section_(b, m, GROUP_CLAUSE, r);
    return r;
  }

  // ( sqlExpression )
  private static boolean groupClause_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupClause_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // havingClause?
  private static boolean groupClause_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupClause_3")) return false;
    havingClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // HAVING sqlExpression
  public static boolean havingClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "havingClause")) return false;
    if (!nextTokenIs(b, HAVING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAVING);
    r = r && sqlExpression(b, l + 1);
    exit_section_(b, m, HAVING_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // START WITH sqlExpression connectByCLause
  public static boolean hierarchyClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hierarchyClause")) return false;
    if (!nextTokenIs(b, START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, START, WITH);
    r = r && sqlExpression(b, l + 1);
    r = r && connectByCLause(b, l + 1);
    exit_section_(b, m, HIERARCHY_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // IN
  public static boolean inModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inModifier")) return false;
    if (!nextTokenIs(b, IN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    exit_section_(b, m, IN_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // INDEX prefetchStatement?
  public static boolean indexFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexFunction")) return false;
    if (!nextTokenIs(b, INDEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDEX);
    r = r && indexFunction_1(b, l + 1);
    exit_section_(b, m, INDEX_FUNCTION, r);
    return r;
  }

  // prefetchStatement?
  private static boolean indexFunction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexFunction_1")) return false;
    prefetchStatement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // DEFAULT
  public static boolean isDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isDefault")) return false;
    if (!nextTokenIs(b, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    exit_section_(b, m, IS_DEFAULT, r);
    return r;
  }

  /* ********************************************************** */
  // !(ENUM|ENTITY|COMMENT|CLASS)
  public static boolean namescpaceRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namescpaceRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, "<namescpace recover>");
    r = !namescpaceRecover_0(b, l + 1);
    exit_section_(b, l, m, NAMESCPACE_RECOVER, r, false, null);
    return r;
  }

  // ENUM|ENTITY|COMMENT|CLASS
  private static boolean namescpaceRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namescpaceRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, ENTITY);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CLASS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // enumDefinition | entityDefinition | classDefinition
  static boolean namespaceElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaceElement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumDefinition(b, l + 1);
    if (!r) r = entityDefinition(b, l + 1);
    if (!r) r = classDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAMESPACE qualifiedName namespaceElement*
  public static boolean namespaceSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaceSection")) return false;
    if (!nextTokenIs(b, NAMESPACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, NAMESPACE);
    p = r; // pin = 1
    r = r && report_error_(b, qualifiedName(b, l + 1));
    r = p && namespaceSection_2(b, l + 1) && r;
    exit_section_(b, l, m, NAMESPACE_SECTION, r, p, null);
    return r || p;
  }

  // namespaceElement*
  private static boolean namespaceSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespaceSection_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!namespaceElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespaceSection_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ORDER BY <<comma_separated_list ( sortSpecification )>>
  public static boolean orderClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderClause")) return false;
    if (!nextTokenIs(b, ORDER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ORDER, BY);
    r = r && comma_separated_list(b, l + 1, orderClause_2_0_parser_);
    exit_section_(b, m, ORDER_CLAUSE, r);
    return r;
  }

  // ( sortSpecification )
  private static boolean orderClause_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderClause_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sortSpecification(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OUT
  public static boolean outModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outModifier")) return false;
    if (!nextTokenIs(b, OUT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OUT);
    exit_section_(b, m, OUT_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // PACKAGE (isDefault|ID) '{' sqlCallable* '}'
  public static boolean packageDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "packageDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<package definition>");
    r = consumeToken(b, PACKAGE);
    p = r; // pin = 1
    r = r && report_error_(b, packageDefinition_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, packageDefinition_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, PACKAGE_DEFINITION, r, p, schemaRecover_parser_);
    return r || p;
  }

  // isDefault|ID
  private static boolean packageDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "packageDefinition_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = isDefault(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlCallable*
  private static boolean packageDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "packageDefinition_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlCallable(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "packageDefinition_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // PREFETCH INT ROWS
  public static boolean prefetchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefetchStatement")) return false;
    if (!nextTokenIs(b, PREFETCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PREFETCH, INT, ROWS);
    exit_section_(b, m, PREFETCH_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // PRIMARY_KEY <<comma_separated_list ( sqlSimpleColumnRefExpression )>>
  public static boolean primaryKeyClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryKeyClause")) return false;
    if (!nextTokenIs(b, PRIMARY_KEY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PRIMARY_KEY);
    r = r && comma_separated_list(b, l + 1, primaryKeyClause_1_0_parser_);
    exit_section_(b, m, PRIMARY_KEY_CLAUSE, r);
    return r;
  }

  // ( sqlSimpleColumnRefExpression )
  private static boolean primaryKeyClause_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryKeyClause_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlSimpleColumnRefExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID ('.' ID)*
  public static boolean qualifiedName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedName")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && qualifiedName_1(b, l + 1);
    exit_section_(b, m, QUALIFIED_NAME, r);
    return r;
  }

  // ('.' ID)*
  private static boolean qualifiedName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedName_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!qualifiedName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualifiedName_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' ID
  private static boolean qualifiedName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fetchOne | fetchList | fetchStream
  static boolean queryFetch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryFetch")) return false;
    if (!nextTokenIs(b, FETCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fetchOne(b, l + 1);
    if (!r) r = fetchList(b, l + 1);
    if (!r) r = fetchStream(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PREPARED? QUERY ID queryParametersList? '{' fullSelect '}' queryFetch?
  public static boolean queryGenerator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryGenerator")) return false;
    if (!nextTokenIs(b, "<query generator>", PREPARED, QUERY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<query generator>");
    r = queryGenerator_0(b, l + 1);
    r = r && consumeTokens(b, 0, QUERY, ID);
    r = r && queryGenerator_3(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && fullSelect(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && queryGenerator_7(b, l + 1);
    exit_section_(b, l, m, QUERY_GENERATOR, r, false, null);
    return r;
  }

  // PREPARED?
  private static boolean queryGenerator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryGenerator_0")) return false;
    consumeToken(b, PREPARED);
    return true;
  }

  // queryParametersList?
  private static boolean queryGenerator_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryGenerator_3")) return false;
    queryParametersList(b, l + 1);
    return true;
  }

  // queryFetch?
  private static boolean queryGenerator_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryGenerator_7")) return false;
    queryFetch(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID dataType
  public static boolean queryParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryParameter")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, QUERY_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // '(' <<comma_separated_list ( queryParameter )>> ')'
  public static boolean queryParametersList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryParametersList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && comma_separated_list(b, l + 1, queryParametersList_1_0_parser_);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, QUERY_PARAMETERS_LIST, r);
    return r;
  }

  // ( queryParameter )
  private static boolean queryParametersList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queryParametersList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = queryParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // tableDefinition | viewDefinition | sequenceDefinition | packageDefinition
  static boolean schemaElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemaElement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tableDefinition(b, l + 1);
    if (!r) r = viewDefinition(b, l + 1);
    if (!r) r = sequenceDefinition(b, l + 1);
    if (!r) r = packageDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(USE|TABLE|VIEW|SEQUENCE|PACKAGE|'}'|COMMENT)
  public static boolean schemaRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemaRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, "<schema recover>");
    r = !schemaRecover_0(b, l + 1);
    exit_section_(b, l, m, SCHEMA_RECOVER, r, false, null);
    return r;
  }

  // USE|TABLE|VIEW|SEQUENCE|PACKAGE|'}'|COMMENT
  private static boolean schemaRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemaRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USE);
    if (!r) r = consumeToken(b, TABLE);
    if (!r) r = consumeToken(b, VIEW);
    if (!r) r = consumeToken(b, SEQUENCE);
    if (!r) r = consumeToken(b, PACKAGE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SCHEMA ID connection? schemaElement*
  public static boolean schemaSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemaSection")) return false;
    if (!nextTokenIs(b, SCHEMA)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, SCHEMA, ID);
    p = r; // pin = 1
    r = r && report_error_(b, schemaSection_2(b, l + 1));
    r = p && schemaSection_3(b, l + 1) && r;
    exit_section_(b, l, m, SCHEMA_SECTION, r, p, null);
    return r || p;
  }

  // connection?
  private static boolean schemaSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemaSection_2")) return false;
    connection(b, l + 1);
    return true;
  }

  // schemaElement*
  private static boolean schemaSection_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemaSection_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!schemaElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schemaSection_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // SELECT allDistinct? (selectStarClause|selectListClause)
  public static boolean selectClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectClause")) return false;
    if (!nextTokenIs(b, SELECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SELECT);
    r = r && selectClause_1(b, l + 1);
    r = r && selectClause_2(b, l + 1);
    exit_section_(b, m, SELECT_CLAUSE, r);
    return r;
  }

  // allDistinct?
  private static boolean selectClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectClause_1")) return false;
    allDistinct(b, l + 1);
    return true;
  }

  // selectStarClause|selectListClause
  private static boolean selectClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectClause_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selectStarClause(b, l + 1);
    if (!r) r = selectListClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sqlExpression aliasClause?
  public static boolean selectDerivedColumn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectDerivedColumn")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<select derived column>");
    r = sqlExpression(b, l + 1);
    r = r && selectDerivedColumn_1(b, l + 1);
    exit_section_(b, l, m, SELECT_DERIVED_COLUMN, r, false, null);
    return r;
  }

  // aliasClause?
  private static boolean selectDerivedColumn_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectDerivedColumn_1")) return false;
    aliasClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // <<comma_separated_list ( selectSublist )>>
  public static boolean selectListClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectListClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<select list clause>");
    r = comma_separated_list(b, l + 1, selectListClause_0_0_parser_);
    exit_section_(b, l, m, SELECT_LIST_CLAUSE, r, false, null);
    return r;
  }

  // ( selectSublist )
  private static boolean selectListClause_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectListClause_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selectSublist(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '*'
  public static boolean selectStarClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectStarClause")) return false;
    if (!nextTokenIs(b, MUL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    exit_section_(b, m, SELECT_STAR_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // allInGroupQualifier | selectDerivedColumn
  static boolean selectSublist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selectSublist")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = allInGroupQualifier(b, l + 1);
    if (!r) r = selectDerivedColumn(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SEQUENCE ID
  public static boolean sequenceDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<sequence definition>");
    r = consumeTokens(b, 1, SEQUENCE, ID);
    p = r; // pin = 1
    exit_section_(b, l, m, SEQUENCE_DEFINITION, r, p, schemaRecover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // PREPARED? NEXT qualifiedName
  public static boolean sequenceGenerator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceGenerator")) return false;
    if (!nextTokenIs(b, "<sequence generator>", NEXT, PREPARED)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sequence generator>");
    r = sequenceGenerator_0(b, l + 1);
    r = r && consumeToken(b, NEXT);
    r = r && qualifiedName(b, l + 1);
    exit_section_(b, l, m, SEQUENCE_GENERATOR, r, false, null);
    return r;
  }

  // PREPARED?
  private static boolean sequenceGenerator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequenceGenerator_0")) return false;
    consumeToken(b, PREPARED);
    return true;
  }

  /* ********************************************************** */
  // ASC|DESC
  public static boolean sortOrder(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sortOrder")) return false;
    if (!nextTokenIs(b, "<sort order>", ASC, DESC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sort order>");
    r = consumeToken(b, ASC);
    if (!r) r = consumeToken(b, DESC);
    exit_section_(b, l, m, SORT_ORDER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // sqlExpression sortOrder?
  public static boolean sortSpecification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sortSpecification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sort specification>");
    r = sqlExpression(b, l + 1);
    r = r && sortSpecification_1(b, l + 1);
    exit_section_(b, l, m, SORT_SPECIFICATION, r, false, null);
    return r;
  }

  // sortOrder?
  private static boolean sortSpecification_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sortSpecification_1")) return false;
    sortOrder(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // sqlComparison sqlAndExpression*
  static boolean sqlAnd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlAnd")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlComparison(b, l + 1);
    r = r && sqlAnd_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlAndExpression*
  private static boolean sqlAnd_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlAnd_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlAndExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sqlAnd_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // AND sqlComparison
  public static boolean sqlAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlAndExpression")) return false;
    if (!nextTokenIs(b, AND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, AND);
    r = r && sqlComparison(b, l + 1);
    exit_section_(b, l, m, SQL_AND_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // sqlLiteral | sqlParameterExpression | sqlColumnRefExpression
  static boolean sqlAtomicExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlAtomicExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlLiteral(b, l + 1);
    if (!r) r = sqlParameterExpression(b, l + 1);
    if (!r) r = sqlColumnRefExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' <<comma_separated_list ( sqlAtomicExpression )>>  ')'
  public static boolean sqlAtomicList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlAtomicList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && comma_separated_list(b, l + 1, sqlAtomicList_1_0_parser_);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SQL_ATOMIC_LIST, r);
    return r;
  }

  // ( sqlAtomicExpression )
  private static boolean sqlAtomicList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlAtomicList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlAtomicExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sqlIn sqlBetweenExpression?
  static boolean sqlBetween(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlBetween")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlIn(b, l + 1);
    r = r && sqlBetween_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlBetweenExpression?
  private static boolean sqlBetween_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlBetween_1")) return false;
    sqlBetweenExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BETWEEN sqlAtomicExpression AND sqlAtomicExpression
  public static boolean sqlBetweenExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlBetweenExpression")) return false;
    if (!nextTokenIs(b, BETWEEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, BETWEEN);
    r = r && sqlAtomicExpression(b, l + 1);
    r = r && consumeToken(b, AND);
    r = r && sqlAtomicExpression(b, l + 1);
    exit_section_(b, l, m, SQL_BETWEEN_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // sqlProcedureCallable | sqlFunctionCallable
  public static boolean sqlCallable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCallable")) return false;
    if (!nextTokenIs(b, "<sql callable>", FUNCTION, PROCEDURE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<sql callable>");
    r = sqlProcedureCallable(b, l + 1);
    if (!r) r = sqlFunctionCallable(b, l + 1);
    exit_section_(b, l, m, SQL_CALLABLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID (inModifier|outModifier) dataType
  public static boolean sqlCallableParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCallableParameter")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && sqlCallableParameter_1(b, l + 1);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, SQL_CALLABLE_PARAMETER, r);
    return r;
  }

  // inModifier|outModifier
  private static boolean sqlCallableParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCallableParameter_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inModifier(b, l + 1);
    if (!r) r = outModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' <<comma_separated_list ( sqlCallableParameter )>> ')'
  public static boolean sqlCallableParametersList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCallableParametersList")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && comma_separated_list(b, l + 1, sqlCallableParametersList_1_0_parser_);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SQL_CALLABLE_PARAMETERS_LIST, r);
    return r;
  }

  // ( sqlCallableParameter )
  private static boolean sqlCallableParametersList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCallableParametersList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlCallableParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID ('.' ID)*
  public static boolean sqlColumnRefExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlColumnRefExpression")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && sqlColumnRefExpression_1(b, l + 1);
    exit_section_(b, m, SQL_COLUMN_REF_EXPRESSION, r);
    return r;
  }

  // ('.' ID)*
  private static boolean sqlColumnRefExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlColumnRefExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlColumnRefExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sqlColumnRefExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' ID
  private static boolean sqlColumnRefExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlColumnRefExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sqlPlusOrMinus sqlComparisonExpression*
  static boolean sqlComparison(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlComparison")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlPlusOrMinus(b, l + 1);
    r = r && sqlComparison_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlComparisonExpression*
  private static boolean sqlComparison_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlComparison_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlComparisonExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sqlComparison_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // sqlComparisonOp sqlPlusOrMinus sqlOra8RightOuter?
  public static boolean sqlComparisonExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlComparisonExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<sql comparison expression>");
    r = sqlComparisonOp(b, l + 1);
    r = r && sqlPlusOrMinus(b, l + 1);
    r = r && sqlComparisonExpression_2(b, l + 1);
    exit_section_(b, l, m, SQL_COMPARISON_EXPRESSION, r, false, null);
    return r;
  }

  // sqlOra8RightOuter?
  private static boolean sqlComparisonExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlComparisonExpression_2")) return false;
    sqlOra8RightOuter(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "=" | "<>" | ">=" | "<=" | ">" | "<" | IS | LIKE
  public static boolean sqlComparisonOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlComparisonOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sql comparison op>");
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NEQ);
    if (!r) r = consumeToken(b, GT_EQ);
    if (!r) r = consumeToken(b, LT_EQ);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, IS);
    if (!r) r = consumeToken(b, LIKE);
    exit_section_(b, l, m, SQL_COMPARISON_OP, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COUNT '(' ('*'| DISTINCT? sqlExpression) ')'
  public static boolean sqlCountFunctionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCountFunctionExpression")) return false;
    if (!nextTokenIs(b, COUNT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COUNT);
    r = r && consumeToken(b, LPAREN);
    r = r && sqlCountFunctionExpression_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SQL_COUNT_FUNCTION_EXPRESSION, r);
    return r;
  }

  // '*'| DISTINCT? sqlExpression
  private static boolean sqlCountFunctionExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCountFunctionExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    if (!r) r = sqlCountFunctionExpression_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DISTINCT? sqlExpression
  private static boolean sqlCountFunctionExpression_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCountFunctionExpression_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlCountFunctionExpression_2_1_0(b, l + 1);
    r = r && sqlExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DISTINCT?
  private static boolean sqlCountFunctionExpression_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlCountFunctionExpression_2_1_0")) return false;
    consumeToken(b, DISTINCT);
    return true;
  }

  /* ********************************************************** */
  // DATE
  public static boolean sqlDateLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlDateLiteralExpression")) return false;
    if (!nextTokenIs(b, DATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATE);
    exit_section_(b, m, SQL_DATE_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // sqlAnd sqlOrExpression*
  public static boolean sqlExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<sql expression>");
    r = sqlAnd(b, l + 1);
    r = r && sqlExpression_1(b, l + 1);
    exit_section_(b, l, m, SQL_EXPRESSION, r, false, null);
    return r;
  }

  // sqlOrExpression*
  private static boolean sqlExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlOrExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sqlExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // FUNCTION ID sqlCallableParametersList? RETURN dataType
  public static boolean sqlFunctionCallable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlFunctionCallable")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION, ID);
    r = r && sqlFunctionCallable_2(b, l + 1);
    r = r && consumeToken(b, RETURN);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, SQL_FUNCTION_CALLABLE, r);
    return r;
  }

  // sqlCallableParametersList?
  private static boolean sqlFunctionCallable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlFunctionCallable_2")) return false;
    sqlCallableParametersList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // qualifiedName '(' <<comma_separated_list ( sqlExpression )>> ')'
  public static boolean sqlFunctionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlFunctionExpression")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualifiedName(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && comma_separated_list(b, l + 1, sqlFunctionExpression_2_0_parser_);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SQL_FUNCTION_EXPRESSION, r);
    return r;
  }

  // ( sqlExpression )
  private static boolean sqlFunctionExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlFunctionExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sqlAtomicExpression sqlInExpression?
  static boolean sqlIn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlIn")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlAtomicExpression(b, l + 1);
    r = r && sqlIn_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlInExpression?
  private static boolean sqlIn_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlIn_1")) return false;
    sqlInExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IN ( subSelect | sqlAtomicList )
  public static boolean sqlInExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlInExpression")) return false;
    if (!nextTokenIs(b, IN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && sqlInExpression_1(b, l + 1);
    exit_section_(b, m, SQL_IN_EXPRESSION, r);
    return r;
  }

  // subSelect | sqlAtomicList
  private static boolean sqlInExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlInExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subSelect(b, l + 1);
    if (!r) r = sqlAtomicList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INT
  public static boolean sqlIntLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlIntLiteralExpression")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT);
    exit_section_(b, m, SQL_INT_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // sqlIntLiteralExpression | sqlStringLiteralExpression | sqlDateLiteralExpression | sqlSysDateLiteralExpression | sqlNullLiteralExpression
  static boolean sqlLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlIntLiteralExpression(b, l + 1);
    if (!r) r = sqlStringLiteralExpression(b, l + 1);
    if (!r) r = sqlDateLiteralExpression(b, l + 1);
    if (!r) r = sqlSysDateLiteralExpression(b, l + 1);
    if (!r) r = sqlNullLiteralExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sqlPrimaryExpression sqlMulOrDivExpression*
  static boolean sqlMulOrDiv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlMulOrDiv")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlPrimaryExpression(b, l + 1);
    r = r && sqlMulOrDiv_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlMulOrDivExpression*
  private static boolean sqlMulOrDiv_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlMulOrDiv_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlMulOrDivExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sqlMulOrDiv_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // sqlMulOrDivOp sqlPrimaryExpression
  public static boolean sqlMulOrDivExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlMulOrDivExpression")) return false;
    if (!nextTokenIs(b, "<sql mul or div expression>", MUL, DIV)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<sql mul or div expression>");
    r = sqlMulOrDivOp(b, l + 1);
    r = r && sqlPrimaryExpression(b, l + 1);
    exit_section_(b, l, m, SQL_MUL_OR_DIV_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "*" | "/"
  public static boolean sqlMulOrDivOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlMulOrDivOp")) return false;
    if (!nextTokenIs(b, "<sql mul or div op>", MUL, DIV)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sql mul or div op>");
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    exit_section_(b, l, m, SQL_MUL_OR_DIV_OP, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT sqlExpression
  public static boolean sqlNotExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlNotExpression")) return false;
    if (!nextTokenIs(b, NOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && sqlExpression(b, l + 1);
    exit_section_(b, m, SQL_NOT_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // NULL
  public static boolean sqlNullLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlNullLiteralExpression")) return false;
    if (!nextTokenIs(b, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL);
    exit_section_(b, m, SQL_NULL_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // OR sqlAnd
  public static boolean sqlOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlOrExpression")) return false;
    if (!nextTokenIs(b, OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, null);
    r = consumeToken(b, OR);
    r = r && sqlAnd(b, l + 1);
    exit_section_(b, l, m, SQL_OR_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' '+' ')'
  public static boolean sqlOra8RightOuter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlOra8RightOuter")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && consumeToken(b, PLUS);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SQL_ORA_8_RIGHT_OUTER, r);
    return r;
  }

  /* ********************************************************** */
  // ':' ID
  public static boolean sqlParameterExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlParameterExpression")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && consumeToken(b, ID);
    exit_section_(b, m, SQL_PARAMETER_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // '(' sqlExpression ')'
  public static boolean sqlParanthesisExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlParanthesisExpression")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && sqlExpression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SQL_PARANTHESIS_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // sqlMulOrDiv sqlPlusOrMinusExpression*
  static boolean sqlPlusOrMinus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlPlusOrMinus")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlMulOrDiv(b, l + 1);
    r = r && sqlPlusOrMinus_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sqlPlusOrMinusExpression*
  private static boolean sqlPlusOrMinus_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlPlusOrMinus_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!sqlPlusOrMinusExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sqlPlusOrMinus_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // sqlPlusOrMinusOp sqlMulOrDiv
  public static boolean sqlPlusOrMinusExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlPlusOrMinusExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<sql plus or minus expression>");
    r = sqlPlusOrMinusOp(b, l + 1);
    r = r && sqlMulOrDiv(b, l + 1);
    exit_section_(b, l, m, SQL_PLUS_OR_MINUS_EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "+" | "-" | CONCATENATE
  public static boolean sqlPlusOrMinusOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlPlusOrMinusOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sql plus or minus op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, CONCATENATE);
    exit_section_(b, l, m, SQL_PLUS_OR_MINUS_OP, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // sqlParanthesisExpression | sqlNotExpression | sqlCountFunctionExpression | sqlFunctionExpression | sqlBetween
  static boolean sqlPrimaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlPrimaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sqlParanthesisExpression(b, l + 1);
    if (!r) r = sqlNotExpression(b, l + 1);
    if (!r) r = sqlCountFunctionExpression(b, l + 1);
    if (!r) r = sqlFunctionExpression(b, l + 1);
    if (!r) r = sqlBetween(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROCEDURE ID sqlCallableParametersList?
  public static boolean sqlProcedureCallable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlProcedureCallable")) return false;
    if (!nextTokenIs(b, PROCEDURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROCEDURE, ID);
    r = r && sqlProcedureCallable_2(b, l + 1);
    exit_section_(b, m, SQL_PROCEDURE_CALLABLE, r);
    return r;
  }

  // sqlCallableParametersList?
  private static boolean sqlProcedureCallable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlProcedureCallable_2")) return false;
    sqlCallableParametersList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean sqlSimpleColumnRefExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlSimpleColumnRefExpression")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, SQL_SIMPLE_COLUMN_REF_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean sqlStringLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlStringLiteralExpression")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, SQL_STRING_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // SYSDATE
  public static boolean sqlSysDateLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlSysDateLiteralExpression")) return false;
    if (!nextTokenIs(b, SYSDATE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYSDATE);
    exit_section_(b, m, SQL_SYS_DATE_LITERAL_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // INT_TYPE|NULLABLE_INT_TYPE|LONG_TYPE|NULLABLE_LONG_TYPE|DOUBLE_TYPE|DECIMAL_TYPE|STRING_TYPE|BOOLEAN_TYPE|DATE_TYPE|TIMESTAMP_TYPE
  public static boolean sqlType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqlType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<sql type>");
    r = consumeToken(b, INT_TYPE);
    if (!r) r = consumeToken(b, NULLABLE_INT_TYPE);
    if (!r) r = consumeToken(b, LONG_TYPE);
    if (!r) r = consumeToken(b, NULLABLE_LONG_TYPE);
    if (!r) r = consumeToken(b, DOUBLE_TYPE);
    if (!r) r = consumeToken(b, DECIMAL_TYPE);
    if (!r) r = consumeToken(b, STRING_TYPE);
    if (!r) r = consumeToken(b, BOOLEAN_TYPE);
    if (!r) r = consumeToken(b, DATE_TYPE);
    if (!r) r = consumeToken(b, TIMESTAMP_TYPE);
    exit_section_(b, l, m, SQL_TYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' fullSelect ')'
  public static boolean subSelect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subSelect")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && fullSelect(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SUB_SELECT, r);
    return r;
  }

  /* ********************************************************** */
  // TABLE ID '{' column* '}' primaryKeyClause?
  public static boolean tableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<table definition>");
    r = consumeTokens(b, 1, TABLE, ID);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LBRACE));
    r = p && report_error_(b, tableDefinition_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && tableDefinition_5(b, l + 1) && r;
    exit_section_(b, l, m, TABLE_DEFINITION, r, p, schemaRecover_parser_);
    return r || p;
  }

  // column*
  private static boolean tableDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableDefinition_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!column(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tableDefinition_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // primaryKeyClause?
  private static boolean tableDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableDefinition_5")) return false;
    primaryKeyClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "lat"
  public static boolean transLat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "transLat")) return false;
    if (!nextTokenIs(b, LAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LAT);
    exit_section_(b, m, TRANS_LAT, r);
    return r;
  }

  /* ********************************************************** */
  // TRANS (transRom|transLat)
  public static boolean transModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "transModifier")) return false;
    if (!nextTokenIs(b, TRANS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRANS);
    r = r && transModifier_1(b, l + 1);
    exit_section_(b, m, TRANS_MODIFIER, r);
    return r;
  }

  // transRom|transLat
  private static boolean transModifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "transModifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = transRom(b, l + 1);
    if (!r) r = transLat(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "rom"
  public static boolean transRom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "transRom")) return false;
    if (!nextTokenIs(b, ROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROM);
    exit_section_(b, m, TRANS_ROM, r);
    return r;
  }

  /* ********************************************************** */
  // AS dataType
  public static boolean typeModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeModifier")) return false;
    if (!nextTokenIs(b, AS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, TYPE_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // VIEW ID '{' column* '}'
  public static boolean viewDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<view definition>");
    r = consumeTokens(b, 1, VIEW, ID);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LBRACE));
    r = p && report_error_(b, viewDefinition_3(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, VIEW_DEFINITION, r, p, schemaRecover_parser_);
    return r || p;
  }

  // column*
  private static boolean viewDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewDefinition_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!column(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "viewDefinition_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // WHERE sqlExpression
  public static boolean whereClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whereClause")) return false;
    if (!nextTokenIs(b, WHERE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHERE);
    r = r && sqlExpression(b, l + 1);
    exit_section_(b, m, WHERE_CLAUSE, r);
    return r;
  }

  final static Parser entityDefinition_3_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return entityDefinition_3_0(b, l + 1);
    }
  };
  final static Parser fromClause_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return fromClause_1_0(b, l + 1);
    }
  };
  final static Parser groupClause_2_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return groupClause_2_0(b, l + 1);
    }
  };
  final static Parser namescpaceRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return namescpaceRecover(b, l + 1);
    }
  };
  final static Parser orderClause_2_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return orderClause_2_0(b, l + 1);
    }
  };
  final static Parser primaryKeyClause_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return primaryKeyClause_1_0(b, l + 1);
    }
  };
  final static Parser queryParametersList_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return queryParametersList_1_0(b, l + 1);
    }
  };
  final static Parser schemaRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return schemaRecover(b, l + 1);
    }
  };
  final static Parser selectListClause_0_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return selectListClause_0_0(b, l + 1);
    }
  };
  final static Parser sqlAtomicList_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return sqlAtomicList_1_0(b, l + 1);
    }
  };
  final static Parser sqlCallableParametersList_1_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return sqlCallableParametersList_1_0(b, l + 1);
    }
  };
  final static Parser sqlFunctionExpression_2_0_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return sqlFunctionExpression_2_0(b, l + 1);
    }
  };
}
