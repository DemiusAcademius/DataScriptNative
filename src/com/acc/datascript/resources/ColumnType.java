package com.acc.datascript.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by demius on 01.06.2015.
 */
public enum ColumnType {
    INT, LONG, NULLABLE_INT, NULLABLE_LONG, DOUBLE, DECIMAL, STRING, DATE, BLOB, CLOB, BOOLEAN, TIMESTAMP;

    public String toText() {
        switch (this) {
            case NULLABLE_INT: return "int?";
            case NULLABLE_LONG: return "long?";
            default: return this.name().toLowerCase();
        }
    }

    public String defaultValue() {
        switch (this) {
            case NULLABLE_INT:
            case NULLABLE_LONG:
            case INT:
            case LONG: return "0";
            case STRING: return "\"\"";
            default: return "";
        }
    }

    public String javaDeclaration() {
        switch (this) {
            case NULLABLE_INT: return "Integer";
            case NULLABLE_LONG: return "Long";
            case DOUBLE: return "double";
            case DECIMAL: return "java.math.BigDecimal";
            case STRING: return "String";
            case DATE: return "java.sql.Date";
            case TIMESTAMP: return "java.sql.Timestamp";
            case BLOB: return "java.sql.BLOB";
            case CLOB: return "java.sql.CLOB";
            default: return this.name().toLowerCase();
        }
    }

    public String genericJavaDeclaration() {
        switch (this) {
            case NULLABLE_INT: return "Integer";
            case NULLABLE_LONG: return "Long";
            case INT: return "Integer";
            case LONG: return "Long";
            case DOUBLE: return "Double";
            case DECIMAL: return "java.math.BigDecimal";
            case STRING: return "String";
            case DATE: return "java.sql.Date";
            case TIMESTAMP: return "java.sql.Timestamp";
            case BLOB: return "java.sql.BLOB";
            case CLOB: return "java.sql.CLOB";
            case BOOLEAN: return "Boolean";
            default: return this.name().toLowerCase();
        }
    }

    public String serviceDeclaration() {
        switch (this) {
            case NULLABLE_INT: return "int";
            case NULLABLE_LONG: return "long";
            default: return this.name().toLowerCase();
        }
    }


    public String partOfExpression() {
        switch (this) {
            case INT: return "Int";
            case LONG: return "Long";
            case NULLABLE_INT: return "Int";
            case NULLABLE_LONG: return "Long";
            case DOUBLE: return "Double";
            case DECIMAL: return "BigDecimal";
            case STRING: return "String";
            case DATE: return "Date";
            case TIMESTAMP: return "Timestamp";
            case BOOLEAN: return "Int";
            default: return this.name().toLowerCase();
        }
    }

    // import java.sql.Types;
    public String javaSqlType() {
        switch (this) {
            case INT: return "INTEGER";
            case LONG: return "INTEGER";
            case NULLABLE_INT: return "INTEGER";
            case NULLABLE_LONG: return "INTEGER";
            case DOUBLE: return "DOUBLE";
            case DECIMAL: return "DECIMAL";
            case STRING: return "VARCHAR";
            case DATE: return "DATE";
            case TIMESTAMP: return "TIMESTAMP";
            case BOOLEAN: return "INTEGER";
            default: return this.name();
        }
    }

    public ColumnType toNullable() {
        switch (this) {
            case INT: return NULLABLE_INT;
            case LONG: return NULLABLE_LONG;
            default: return this;
        }
    }

    public ColumnType toNonNullable() {
        switch (this) {
            case NULLABLE_INT: return INT;
            case NULLABLE_LONG: return LONG;
            default: return this;
        }
    }

    public Set<ColumnType> superTypes() {
        switch (this) {
            case INT:
                return new HashSet<>(Arrays.asList(new ColumnType[]{LONG,NULLABLE_INT,NULLABLE_LONG,DOUBLE,DECIMAL}));
            case NULLABLE_INT:
                return new HashSet<>(Arrays.asList(new ColumnType[]{NULLABLE_LONG,DECIMAL}));
            case LONG:
                return new HashSet<>(Arrays.asList(new ColumnType[]{NULLABLE_LONG,DOUBLE,DECIMAL}));
            case NULLABLE_LONG:
                return new HashSet<>(Arrays.asList(new ColumnType[]{DECIMAL}));
            case DOUBLE:
                return new HashSet<>(Arrays.asList(new ColumnType[]{DECIMAL}));
            default: return Collections.emptySet();
        }
    }

    public boolean isNumeric() {
        return NUMERIC_TYPES.contains(this);
    }

    public boolean isDate() {
        return DATE_TYPES.contains(this);
    }

    public boolean isNullableNumeric() {
        return this == NULLABLE_INT || this == NULLABLE_LONG;
    }

    public static final Set<ColumnType> NUMERIC_TYPES = new HashSet<>(Arrays.asList(new ColumnType[]{INT,LONG,NULLABLE_INT,NULLABLE_LONG,DOUBLE,DECIMAL}));

    public static final Set<ColumnType> DATE_TYPES = new HashSet<>(Arrays.asList(new ColumnType[]{DATE,TIMESTAMP}));

    public static ColumnType fromText(String text) {
        switch (text) {
            case "int": return INT;
            case "long": return LONG;
            case "int?": return NULLABLE_INT;
            case "long?": return NULLABLE_LONG;
            case "double": return DOUBLE;
            case "decimal": return DECIMAL;
            case "string": return STRING;
            case "datetime": return DATE;
            case "blob": return BLOB;
            case "clob": return CLOB;
            case "boolean": return BOOLEAN;
            case "timestamp": return TIMESTAMP;
            default: return null;
        }
    }
}
