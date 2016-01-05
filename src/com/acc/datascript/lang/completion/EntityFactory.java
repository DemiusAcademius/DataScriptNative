package com.acc.datascript.lang.completion;

import com.acc.datascript.resources.ColumnType;
import com.acc.datascript.resources.Table;
import com.acc.datascript.resources.View;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by demius on 12.11.2015.
 */
public class EntityFactory {

    public static String generateTableText(Table table) {
        StringBuilder sb = new StringBuilder(table.name);

        sb.append(" {\n");

        join(table.columns, sb, "\n", c -> {
            sb.append("    ");
            sb.append(c.name + " " + c.type.toText());
            ColumnType reinterpret = c.reinterpret();
            if (reinterpret != null) sb.append(" as " + reinterpret.toText());
        });

        sb.append("\n}");

        if (table.primaryColumns.size() > 0) {
            sb.append(" primary key ");
            join(table.primaryColumns, sb, ", ", null);
        }

        sb.append("\n");

        return sb.toString();
    }

    public static String generateViewText(View view) {
        StringBuilder sb = new StringBuilder(view.name);

        sb.append(" {\n");

        join(view.columns, sb, "\n", c -> {
            sb.append("    ");
            sb.append(c.name + " " + c.type.toText());
            ColumnType reinterpret = c.reinterpret();
            if (reinterpret != null) sb.append(" as " + reinterpret.toText());
        });

        sb.append("\n}\n");

        return sb.toString();
    }

    public static <T> void join(List<T> list, StringBuilder sb, String separator, Consumer<T> transformer) {
        int count = 0;
        for (T element : list) {
            if (count > 0) sb.append(separator);

            if (transformer == null)
                sb.append(element);
            else
                transformer.accept(element);

            count++;
        }
    }

}
