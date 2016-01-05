package com.acc.datascript.resources;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

/**
 * Created by demius on 12.11.2015.
 */
public class Table {
    private static final String SQL_PRIMARY = "select CONSTRAINT_NAME from sys.all_constraints where owner = ? AND CONSTRAINT_TYPE = 'P' AND STATUS = 'ENABLED' and TABLE_NAME = ?";
    private static final String SQL_PRM_COLUMNS = "SELECT COLUMN_NAME FROM SYS.ALL_CONS_COLUMNS WHERE OWNER = ? and TABLE_NAME = ? and CONSTRAINT_NAME = ? ORDER BY POSITION";

    public final String schema;
    public final String name;

    public final List<Column> columns;

    public final List<String> primaryColumns;

    public Table(String schema, String name, List<Column> columns, Connection connection) throws Exception {
        this.schema = schema;
        this.name = name;
        this.columns = columns;

        String primaryKey = SqlRuntime.fetchOne(connection, SQL_PRIMARY, rs -> rs.getString(1), st -> {
            st.setString(1, schema);
            st.setString(2, name);
        });

        if (primaryKey != null) {
            primaryColumns = SqlRuntime.fetchList(connection, SQL_PRM_COLUMNS, rs -> rs.getString(1), st -> {
                st.setString(1, schema);
                st.setString(2, name);
                st.setString(3, primaryKey);
            }, 2);
        } else {
            primaryColumns = Collections.emptyList();
        }

    }

}
