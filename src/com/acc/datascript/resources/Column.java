package com.acc.datascript.resources;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by demius on 12.10.2015.
 */
public class Column {

    public final String name;
    public final int precision;
    public final int scale;
    public final boolean nullable;
    public final ColumnType type;

    public Column(ResultSet rs) throws SQLException {
        this.name = rs.getString(1);
        this.precision = rs.getInt(3);
        this.scale = rs.getInt(4);
        this.nullable = rs.getString(5).equals("Y");

        switch (rs.getString(2)) {
            case "CHAR":
            case "VARCHAR2":
                type = ColumnType.STRING;
                break;
            case "DATE":
                type = ColumnType.DATE;
                break;
            case "NUMBER": {
                if (scale == 0) {
                    if (precision == 0 || precision > 9) {
                        if (nullable)
                            type = ColumnType.NULLABLE_LONG;
                        else type = ColumnType.LONG;
                    } else {
                        if (nullable)
                            type = ColumnType.NULLABLE_INT;
                        else type = ColumnType.INT;
                    }
                } else {
                    if (nullable)
                        type = ColumnType.DECIMAL;
                    else type = ColumnType.DOUBLE;
                }
                break;
            }
            case "BLOB":
                type = ColumnType.BLOB;
                break;
            case "CLOB":
                type = ColumnType.CLOB;
                break;
            default:
                type = null;
        }
    }

    public ColumnType reinterpret() {
        if (type == ColumnType.DATE) {
            if (name.startsWith("SYS")) return ColumnType.TIMESTAMP;
        } else if ((type == ColumnType.INT || type == ColumnType.NULLABLE_INT) && precision == 1 && name.contains("_E_"))
            return ColumnType.BOOLEAN;
        return null;
    }

}
