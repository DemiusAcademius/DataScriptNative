// This is a generated file. Not intended for manual editing.
package com.acc.datascript.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.acc.datascript.lang.psi.impl.*;

public interface DataScriptTypes {

  IElementType ALIAS_CLAUSE = new DataScriptElementType("ALIAS_CLAUSE");
  IElementType ALL_DISTINCT = new DataScriptElementType("ALL_DISTINCT");
  IElementType ALL_IN_GROUP_QUALIFIER = new DataScriptElementType("ALL_IN_GROUP_QUALIFIER");
  IElementType BATCH_FUNCTION = new DataScriptElementType("BATCH_FUNCTION");
  IElementType CALLABLE_CARDINALITY = new DataScriptElementType("CALLABLE_CARDINALITY");
  IElementType CALL_GENERATOR = new DataScriptElementType("CALL_GENERATOR");
  IElementType CLASS_DEFINITION = new DataScriptElementType("CLASS_DEFINITION");
  IElementType CLASS_ELEMENT = new DataScriptElementType("CLASS_ELEMENT");
  IElementType COLUMN = new DataScriptElementType("COLUMN");
  IElementType CONNECTION = new DataScriptElementType("CONNECTION");
  IElementType CONNECT_BY_C_LAUSE = new DataScriptElementType("CONNECT_BY_C_LAUSE");
  IElementType DATA_TYPE = new DataScriptElementType("DATA_TYPE");
  IElementType ENTITY_DEFINITION = new DataScriptElementType("ENTITY_DEFINITION");
  IElementType ENTITY_FUNCTION = new DataScriptElementType("ENTITY_FUNCTION");
  IElementType ENTITY_QUERY_GENERATOR = new DataScriptElementType("ENTITY_QUERY_GENERATOR");
  IElementType ENTITY_SELECT = new DataScriptElementType("ENTITY_SELECT");
  IElementType ENTITY_SELECTOR = new DataScriptElementType("ENTITY_SELECTOR");
  IElementType ENUM_DEFINITION = new DataScriptElementType("ENUM_DEFINITION");
  IElementType ENUM_ELEMENT = new DataScriptElementType("ENUM_ELEMENT");
  IElementType FETCH_LIST = new DataScriptElementType("FETCH_LIST");
  IElementType FETCH_ONE = new DataScriptElementType("FETCH_ONE");
  IElementType FETCH_STREAM = new DataScriptElementType("FETCH_STREAM");
  IElementType FIND_FUNCTION = new DataScriptElementType("FIND_FUNCTION");
  IElementType FROM_CLAUSE = new DataScriptElementType("FROM_CLAUSE");
  IElementType FULL_SELECT = new DataScriptElementType("FULL_SELECT");
  IElementType GROUP_CLAUSE = new DataScriptElementType("GROUP_CLAUSE");
  IElementType HAVING_CLAUSE = new DataScriptElementType("HAVING_CLAUSE");
  IElementType HIERARCHY_CLAUSE = new DataScriptElementType("HIERARCHY_CLAUSE");
  IElementType INDEX_FUNCTION = new DataScriptElementType("INDEX_FUNCTION");
  IElementType IN_MODIFIER = new DataScriptElementType("IN_MODIFIER");
  IElementType IS_DEFAULT = new DataScriptElementType("IS_DEFAULT");
  IElementType NAMESCPACE_RECOVER = new DataScriptElementType("NAMESCPACE_RECOVER");
  IElementType NAMESPACE_SECTION = new DataScriptElementType("NAMESPACE_SECTION");
  IElementType ORDER_CLAUSE = new DataScriptElementType("ORDER_CLAUSE");
  IElementType OUT_MODIFIER = new DataScriptElementType("OUT_MODIFIER");
  IElementType PACKAGE_DEFINITION = new DataScriptElementType("PACKAGE_DEFINITION");
  IElementType PREFETCH_STATEMENT = new DataScriptElementType("PREFETCH_STATEMENT");
  IElementType PRIMARY_KEY_CLAUSE = new DataScriptElementType("PRIMARY_KEY_CLAUSE");
  IElementType QUALIFIED_NAME = new DataScriptElementType("QUALIFIED_NAME");
  IElementType QUERY_GENERATOR = new DataScriptElementType("QUERY_GENERATOR");
  IElementType QUERY_PARAMETER = new DataScriptElementType("QUERY_PARAMETER");
  IElementType QUERY_PARAMETERS_LIST = new DataScriptElementType("QUERY_PARAMETERS_LIST");
  IElementType SCHEMA_RECOVER = new DataScriptElementType("SCHEMA_RECOVER");
  IElementType SCHEMA_SECTION = new DataScriptElementType("SCHEMA_SECTION");
  IElementType SELECT_CLAUSE = new DataScriptElementType("SELECT_CLAUSE");
  IElementType SELECT_DERIVED_COLUMN = new DataScriptElementType("SELECT_DERIVED_COLUMN");
  IElementType SELECT_LIST_CLAUSE = new DataScriptElementType("SELECT_LIST_CLAUSE");
  IElementType SELECT_STAR_CLAUSE = new DataScriptElementType("SELECT_STAR_CLAUSE");
  IElementType SEQUENCE_DEFINITION = new DataScriptElementType("SEQUENCE_DEFINITION");
  IElementType SEQUENCE_GENERATOR = new DataScriptElementType("SEQUENCE_GENERATOR");
  IElementType SORT_ORDER = new DataScriptElementType("SORT_ORDER");
  IElementType SORT_SPECIFICATION = new DataScriptElementType("SORT_SPECIFICATION");
  IElementType SQL_AND_EXPRESSION = new DataScriptElementType("SQL_AND_EXPRESSION");
  IElementType SQL_ATOMIC_LIST = new DataScriptElementType("SQL_ATOMIC_LIST");
  IElementType SQL_BETWEEN_EXPRESSION = new DataScriptElementType("SQL_BETWEEN_EXPRESSION");
  IElementType SQL_CALLABLE = new DataScriptElementType("SQL_CALLABLE");
  IElementType SQL_CALLABLE_PARAMETER = new DataScriptElementType("SQL_CALLABLE_PARAMETER");
  IElementType SQL_CALLABLE_PARAMETERS_LIST = new DataScriptElementType("SQL_CALLABLE_PARAMETERS_LIST");
  IElementType SQL_COLUMN_REF_EXPRESSION = new DataScriptElementType("SQL_COLUMN_REF_EXPRESSION");
  IElementType SQL_COMPARISON_EXPRESSION = new DataScriptElementType("SQL_COMPARISON_EXPRESSION");
  IElementType SQL_COMPARISON_OP = new DataScriptElementType("SQL_COMPARISON_OP");
  IElementType SQL_COUNT_FUNCTION_EXPRESSION = new DataScriptElementType("SQL_COUNT_FUNCTION_EXPRESSION");
  IElementType SQL_DATE_LITERAL_EXPRESSION = new DataScriptElementType("SQL_DATE_LITERAL_EXPRESSION");
  IElementType SQL_EXPRESSION = new DataScriptElementType("SQL_EXPRESSION");
  IElementType SQL_FUNCTION_CALLABLE = new DataScriptElementType("SQL_FUNCTION_CALLABLE");
  IElementType SQL_FUNCTION_EXPRESSION = new DataScriptElementType("SQL_FUNCTION_EXPRESSION");
  IElementType SQL_INT_LITERAL_EXPRESSION = new DataScriptElementType("SQL_INT_LITERAL_EXPRESSION");
  IElementType SQL_IN_EXPRESSION = new DataScriptElementType("SQL_IN_EXPRESSION");
  IElementType SQL_MUL_OR_DIV_EXPRESSION = new DataScriptElementType("SQL_MUL_OR_DIV_EXPRESSION");
  IElementType SQL_MUL_OR_DIV_OP = new DataScriptElementType("SQL_MUL_OR_DIV_OP");
  IElementType SQL_NOT_EXPRESSION = new DataScriptElementType("SQL_NOT_EXPRESSION");
  IElementType SQL_NULL_LITERAL_EXPRESSION = new DataScriptElementType("SQL_NULL_LITERAL_EXPRESSION");
  IElementType SQL_ORA_8_RIGHT_OUTER = new DataScriptElementType("SQL_ORA_8_RIGHT_OUTER");
  IElementType SQL_OR_EXPRESSION = new DataScriptElementType("SQL_OR_EXPRESSION");
  IElementType SQL_PARAMETER_EXPRESSION = new DataScriptElementType("SQL_PARAMETER_EXPRESSION");
  IElementType SQL_PARANTHESIS_EXPRESSION = new DataScriptElementType("SQL_PARANTHESIS_EXPRESSION");
  IElementType SQL_PLUS_OR_MINUS_EXPRESSION = new DataScriptElementType("SQL_PLUS_OR_MINUS_EXPRESSION");
  IElementType SQL_PLUS_OR_MINUS_OP = new DataScriptElementType("SQL_PLUS_OR_MINUS_OP");
  IElementType SQL_PROCEDURE_CALLABLE = new DataScriptElementType("SQL_PROCEDURE_CALLABLE");
  IElementType SQL_SIMPLE_COLUMN_REF_EXPRESSION = new DataScriptElementType("SQL_SIMPLE_COLUMN_REF_EXPRESSION");
  IElementType SQL_STRING_LITERAL_EXPRESSION = new DataScriptElementType("SQL_STRING_LITERAL_EXPRESSION");
  IElementType SQL_SYS_DATE_LITERAL_EXPRESSION = new DataScriptElementType("SQL_SYS_DATE_LITERAL_EXPRESSION");
  IElementType SQL_TYPE = new DataScriptElementType("SQL_TYPE");
  IElementType SUB_SELECT = new DataScriptElementType("SUB_SELECT");
  IElementType TABLE_DEFINITION = new DataScriptElementType("TABLE_DEFINITION");
  IElementType TRANS_LAT = new DataScriptElementType("TRANS_LAT");
  IElementType TRANS_MODIFIER = new DataScriptElementType("TRANS_MODIFIER");
  IElementType TRANS_ROM = new DataScriptElementType("TRANS_ROM");
  IElementType TYPE_MODIFIER = new DataScriptElementType("TYPE_MODIFIER");
  IElementType VIEW_DEFINITION = new DataScriptElementType("VIEW_DEFINITION");
  IElementType WHERE_CLAUSE = new DataScriptElementType("WHERE_CLAUSE");

  IElementType ALL = new DataScriptTokenType("all");
  IElementType AND = new DataScriptTokenType("and");
  IElementType AS = new DataScriptTokenType("as");
  IElementType ASC = new DataScriptTokenType("asc");
  IElementType BATCH = new DataScriptTokenType("batch");
  IElementType BETWEEN = new DataScriptTokenType("between");
  IElementType BOOLEAN_TYPE = new DataScriptTokenType("boolean");
  IElementType BY = new DataScriptTokenType("by");
  IElementType CALL = new DataScriptTokenType("call");
  IElementType CLASS = new DataScriptTokenType("class");
  IElementType COLON = new DataScriptTokenType(":");
  IElementType COMMA = new DataScriptTokenType(",");
  IElementType COMMENT = new DataScriptTokenType("COMMENT");
  IElementType CONCATENATE = new DataScriptTokenType("||");
  IElementType CONNECT = new DataScriptTokenType("connect");
  IElementType COUNT = new DataScriptTokenType("count");
  IElementType DATE = new DataScriptTokenType("DATE");
  IElementType DATE_TYPE = new DataScriptTokenType("date");
  IElementType DECIMAL_TYPE = new DataScriptTokenType("decimal");
  IElementType DEFAULT = new DataScriptTokenType("default");
  IElementType DELETE = new DataScriptTokenType("delete");
  IElementType DESC = new DataScriptTokenType("desc");
  IElementType DISTINCT = new DataScriptTokenType("distinct");
  IElementType DIV = new DataScriptTokenType("/");
  IElementType DOT = new DataScriptTokenType(".");
  IElementType DOUBLE_TYPE = new DataScriptTokenType("double");
  IElementType ENTITY = new DataScriptTokenType("entity");
  IElementType ENUM = new DataScriptTokenType("enum");
  IElementType EQ = new DataScriptTokenType("=");
  IElementType FETCH = new DataScriptTokenType("fetch");
  IElementType FIND = new DataScriptTokenType("find");
  IElementType FROM = new DataScriptTokenType("from");
  IElementType FUNCTION = new DataScriptTokenType("function");
  IElementType GROUP = new DataScriptTokenType("group");
  IElementType GT = new DataScriptTokenType(">");
  IElementType GT_EQ = new DataScriptTokenType(">=");
  IElementType HAVING = new DataScriptTokenType("having");
  IElementType ID = new DataScriptTokenType("ID");
  IElementType IN = new DataScriptTokenType("in");
  IElementType INDEX = new DataScriptTokenType("index");
  IElementType INSERT = new DataScriptTokenType("insert");
  IElementType INT = new DataScriptTokenType("INT");
  IElementType INT_TYPE = new DataScriptTokenType("int");
  IElementType IS = new DataScriptTokenType("is");
  IElementType LAT = new DataScriptTokenType("lat");
  IElementType LBRACE = new DataScriptTokenType("{");
  IElementType LBRACKET = new DataScriptTokenType("[");
  IElementType LIKE = new DataScriptTokenType("like");
  IElementType LIST = new DataScriptTokenType("list");
  IElementType LONG_TYPE = new DataScriptTokenType("long");
  IElementType LPAREN = new DataScriptTokenType("(");
  IElementType LT = new DataScriptTokenType("<");
  IElementType LT_EQ = new DataScriptTokenType("<=");
  IElementType MINUS = new DataScriptTokenType("-");
  IElementType MUL = new DataScriptTokenType("*");
  IElementType NAMESPACE = new DataScriptTokenType("namespace");
  IElementType NEQ = new DataScriptTokenType("<>");
  IElementType NEXT = new DataScriptTokenType("next");
  IElementType NOCYCLE = new DataScriptTokenType("nocycle");
  IElementType NOT = new DataScriptTokenType("not");
  IElementType NULL = new DataScriptTokenType("null");
  IElementType NULLABLE_INT_TYPE = new DataScriptTokenType("int?");
  IElementType NULLABLE_LONG_TYPE = new DataScriptTokenType("long?");
  IElementType NUMBER = new DataScriptTokenType("NUMBER");
  IElementType ONE = new DataScriptTokenType("one");
  IElementType OR = new DataScriptTokenType("or");
  IElementType ORDER = new DataScriptTokenType("order");
  IElementType OUT = new DataScriptTokenType("out");
  IElementType PACKAGE = new DataScriptTokenType("package");
  IElementType PLUS = new DataScriptTokenType("+");
  IElementType PREFETCH = new DataScriptTokenType("prefetch");
  IElementType PREPARED = new DataScriptTokenType("prepared");
  IElementType PRIMARY_KEY = new DataScriptTokenType("primary key");
  IElementType PRIOR = new DataScriptTokenType("prior");
  IElementType PROCEDURE = new DataScriptTokenType("procedure");
  IElementType QUERY = new DataScriptTokenType("query");
  IElementType RBRACE = new DataScriptTokenType("}");
  IElementType RBRACKET = new DataScriptTokenType("]");
  IElementType RETURN = new DataScriptTokenType("return");
  IElementType ROM = new DataScriptTokenType("rom");
  IElementType ROWS = new DataScriptTokenType("rows");
  IElementType RPAREN = new DataScriptTokenType(")");
  IElementType SCHEMA = new DataScriptTokenType("schema");
  IElementType SELECT = new DataScriptTokenType("select");
  IElementType SEMICOLON = new DataScriptTokenType(";");
  IElementType SEQUENCE = new DataScriptTokenType("sequence");
  IElementType START = new DataScriptTokenType("start");
  IElementType STREAM = new DataScriptTokenType("stream");
  IElementType STRING = new DataScriptTokenType("STRING");
  IElementType STRING_TYPE = new DataScriptTokenType("string");
  IElementType SYSDATE = new DataScriptTokenType("sysdate");
  IElementType TABLE = new DataScriptTokenType("table");
  IElementType TIMESTAMP_TYPE = new DataScriptTokenType("timestamp");
  IElementType TRANS = new DataScriptTokenType("trans");
  IElementType UPDATE = new DataScriptTokenType("update");
  IElementType USE = new DataScriptTokenType("use");
  IElementType VIEW = new DataScriptTokenType("view");
  IElementType WHERE = new DataScriptTokenType("where");
  IElementType WITH = new DataScriptTokenType("with");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ALIAS_CLAUSE) {
        return new DsAliasClauseImpl(node);
      }
      else if (type == ALL_DISTINCT) {
        return new DsAllDistinctImpl(node);
      }
      else if (type == ALL_IN_GROUP_QUALIFIER) {
        return new DsAllInGroupQualifierImpl(node);
      }
      else if (type == BATCH_FUNCTION) {
        return new DsBatchFunctionImpl(node);
      }
      else if (type == CALLABLE_CARDINALITY) {
        return new DsCallableCardinalityImpl(node);
      }
      else if (type == CALL_GENERATOR) {
        return new DsCallGeneratorImpl(node);
      }
      else if (type == CLASS_DEFINITION) {
        return new DsClassDefinitionImpl(node);
      }
      else if (type == CLASS_ELEMENT) {
        return new DsClassElementImpl(node);
      }
      else if (type == COLUMN) {
        return new DsColumnImpl(node);
      }
      else if (type == CONNECTION) {
        return new DsConnectionImpl(node);
      }
      else if (type == CONNECT_BY_C_LAUSE) {
        return new DsConnectByCLauseImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new DsDataTypeImpl(node);
      }
      else if (type == ENTITY_DEFINITION) {
        return new DsEntityDefinitionImpl(node);
      }
      else if (type == ENTITY_FUNCTION) {
        return new DsEntityFunctionImpl(node);
      }
      else if (type == ENTITY_QUERY_GENERATOR) {
        return new DsEntityQueryGeneratorImpl(node);
      }
      else if (type == ENTITY_SELECT) {
        return new DsEntitySelectImpl(node);
      }
      else if (type == ENTITY_SELECTOR) {
        return new DsEntitySelectorImpl(node);
      }
      else if (type == ENUM_DEFINITION) {
        return new DsEnumDefinitionImpl(node);
      }
      else if (type == ENUM_ELEMENT) {
        return new DsEnumElementImpl(node);
      }
      else if (type == FETCH_LIST) {
        return new DsFetchListImpl(node);
      }
      else if (type == FETCH_ONE) {
        return new DsFetchOneImpl(node);
      }
      else if (type == FETCH_STREAM) {
        return new DsFetchStreamImpl(node);
      }
      else if (type == FIND_FUNCTION) {
        return new DsFindFunctionImpl(node);
      }
      else if (type == FROM_CLAUSE) {
        return new DsFromClauseImpl(node);
      }
      else if (type == FULL_SELECT) {
        return new DsFullSelectImpl(node);
      }
      else if (type == GROUP_CLAUSE) {
        return new DsGroupClauseImpl(node);
      }
      else if (type == HAVING_CLAUSE) {
        return new DsHavingClauseImpl(node);
      }
      else if (type == HIERARCHY_CLAUSE) {
        return new DsHierarchyClauseImpl(node);
      }
      else if (type == INDEX_FUNCTION) {
        return new DsIndexFunctionImpl(node);
      }
      else if (type == IN_MODIFIER) {
        return new DsInModifierImpl(node);
      }
      else if (type == IS_DEFAULT) {
        return new DsIsDefaultImpl(node);
      }
      else if (type == NAMESCPACE_RECOVER) {
        return new DsNamescpaceRecoverImpl(node);
      }
      else if (type == NAMESPACE_SECTION) {
        return new DsNamespaceSectionImpl(node);
      }
      else if (type == ORDER_CLAUSE) {
        return new DsOrderClauseImpl(node);
      }
      else if (type == OUT_MODIFIER) {
        return new DsOutModifierImpl(node);
      }
      else if (type == PACKAGE_DEFINITION) {
        return new DsPackageDefinitionImpl(node);
      }
      else if (type == PREFETCH_STATEMENT) {
        return new DsPrefetchStatementImpl(node);
      }
      else if (type == PRIMARY_KEY_CLAUSE) {
        return new DsPrimaryKeyClauseImpl(node);
      }
      else if (type == QUALIFIED_NAME) {
        return new DsQualifiedNameImpl(node);
      }
      else if (type == QUERY_GENERATOR) {
        return new DsQueryGeneratorImpl(node);
      }
      else if (type == QUERY_PARAMETER) {
        return new DsQueryParameterImpl(node);
      }
      else if (type == QUERY_PARAMETERS_LIST) {
        return new DsQueryParametersListImpl(node);
      }
      else if (type == SCHEMA_RECOVER) {
        return new DsSchemaRecoverImpl(node);
      }
      else if (type == SCHEMA_SECTION) {
        return new DsSchemaSectionImpl(node);
      }
      else if (type == SELECT_CLAUSE) {
        return new DsSelectClauseImpl(node);
      }
      else if (type == SELECT_DERIVED_COLUMN) {
        return new DsSelectDerivedColumnImpl(node);
      }
      else if (type == SELECT_LIST_CLAUSE) {
        return new DsSelectListClauseImpl(node);
      }
      else if (type == SELECT_STAR_CLAUSE) {
        return new DsSelectStarClauseImpl(node);
      }
      else if (type == SEQUENCE_DEFINITION) {
        return new DsSequenceDefinitionImpl(node);
      }
      else if (type == SEQUENCE_GENERATOR) {
        return new DsSequenceGeneratorImpl(node);
      }
      else if (type == SORT_ORDER) {
        return new DsSortOrderImpl(node);
      }
      else if (type == SORT_SPECIFICATION) {
        return new DsSortSpecificationImpl(node);
      }
      else if (type == SQL_AND_EXPRESSION) {
        return new DsSqlAndExpressionImpl(node);
      }
      else if (type == SQL_ATOMIC_LIST) {
        return new DsSqlAtomicListImpl(node);
      }
      else if (type == SQL_BETWEEN_EXPRESSION) {
        return new DsSqlBetweenExpressionImpl(node);
      }
      else if (type == SQL_CALLABLE) {
        return new DsSqlCallableImpl(node);
      }
      else if (type == SQL_CALLABLE_PARAMETER) {
        return new DsSqlCallableParameterImpl(node);
      }
      else if (type == SQL_CALLABLE_PARAMETERS_LIST) {
        return new DsSqlCallableParametersListImpl(node);
      }
      else if (type == SQL_COLUMN_REF_EXPRESSION) {
        return new DsSqlColumnRefExpressionImpl(node);
      }
      else if (type == SQL_COMPARISON_EXPRESSION) {
        return new DsSqlComparisonExpressionImpl(node);
      }
      else if (type == SQL_COMPARISON_OP) {
        return new DsSqlComparisonOpImpl(node);
      }
      else if (type == SQL_COUNT_FUNCTION_EXPRESSION) {
        return new DsSqlCountFunctionExpressionImpl(node);
      }
      else if (type == SQL_DATE_LITERAL_EXPRESSION) {
        return new DsSqlDateLiteralExpressionImpl(node);
      }
      else if (type == SQL_EXPRESSION) {
        return new DsSqlExpressionImpl(node);
      }
      else if (type == SQL_FUNCTION_CALLABLE) {
        return new DsSqlFunctionCallableImpl(node);
      }
      else if (type == SQL_FUNCTION_EXPRESSION) {
        return new DsSqlFunctionExpressionImpl(node);
      }
      else if (type == SQL_INT_LITERAL_EXPRESSION) {
        return new DsSqlIntLiteralExpressionImpl(node);
      }
      else if (type == SQL_IN_EXPRESSION) {
        return new DsSqlInExpressionImpl(node);
      }
      else if (type == SQL_MUL_OR_DIV_EXPRESSION) {
        return new DsSqlMulOrDivExpressionImpl(node);
      }
      else if (type == SQL_MUL_OR_DIV_OP) {
        return new DsSqlMulOrDivOpImpl(node);
      }
      else if (type == SQL_NOT_EXPRESSION) {
        return new DsSqlNotExpressionImpl(node);
      }
      else if (type == SQL_NULL_LITERAL_EXPRESSION) {
        return new DsSqlNullLiteralExpressionImpl(node);
      }
      else if (type == SQL_ORA_8_RIGHT_OUTER) {
        return new DsSqlOra8RightOuterImpl(node);
      }
      else if (type == SQL_OR_EXPRESSION) {
        return new DsSqlOrExpressionImpl(node);
      }
      else if (type == SQL_PARAMETER_EXPRESSION) {
        return new DsSqlParameterExpressionImpl(node);
      }
      else if (type == SQL_PARANTHESIS_EXPRESSION) {
        return new DsSqlParanthesisExpressionImpl(node);
      }
      else if (type == SQL_PLUS_OR_MINUS_EXPRESSION) {
        return new DsSqlPlusOrMinusExpressionImpl(node);
      }
      else if (type == SQL_PLUS_OR_MINUS_OP) {
        return new DsSqlPlusOrMinusOpImpl(node);
      }
      else if (type == SQL_PROCEDURE_CALLABLE) {
        return new DsSqlProcedureCallableImpl(node);
      }
      else if (type == SQL_SIMPLE_COLUMN_REF_EXPRESSION) {
        return new DsSqlSimpleColumnRefExpressionImpl(node);
      }
      else if (type == SQL_STRING_LITERAL_EXPRESSION) {
        return new DsSqlStringLiteralExpressionImpl(node);
      }
      else if (type == SQL_SYS_DATE_LITERAL_EXPRESSION) {
        return new DsSqlSysDateLiteralExpressionImpl(node);
      }
      else if (type == SQL_TYPE) {
        return new DsSqlTypeImpl(node);
      }
      else if (type == SUB_SELECT) {
        return new DsSubSelectImpl(node);
      }
      else if (type == TABLE_DEFINITION) {
        return new DsTableDefinitionImpl(node);
      }
      else if (type == TRANS_LAT) {
        return new DsTransLatImpl(node);
      }
      else if (type == TRANS_MODIFIER) {
        return new DsTransModifierImpl(node);
      }
      else if (type == TRANS_ROM) {
        return new DsTransRomImpl(node);
      }
      else if (type == TYPE_MODIFIER) {
        return new DsTypeModifierImpl(node);
      }
      else if (type == VIEW_DEFINITION) {
        return new DsViewDefinitionImpl(node);
      }
      else if (type == WHERE_CLAUSE) {
        return new DsWhereClauseImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
