package com.acc.datascript.resources;

import java.util.List;

/**
 * Created by demius on 12.11.2015.
 */
public class View {
    public final String schema;
    public final String name;

    public final List<Column> columns;

    public View(String schema, String name, List<Column> columns) {
        this.schema = schema;
        this.name = name;
        this.columns = columns;
    }

}
