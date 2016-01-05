package com.acc.datascript.generator.helpers

import com.acc.datascript.lang.names.name
import com.acc.datascript.lang.types.DataScriptType
import com.acc.datascript.resources.ColumnType

/**
 * Created by demius on 05.01.2016.
 */

public fun sqlGetter(type: DataScriptType, sqlVar: String): CharSequence =
    when (type) {
        is DataScriptType.Enum -> "${type.enumRef.name}.select($sqlVar,1)"
        is DataScriptType.Sql -> {
            val sqlType = type.sqlType
            if (sqlType == null) ""
            else {
                val ts = sqlType.partOfExpression()
                val postfix = if (sqlType == ColumnType.BOOLEAN) " == 1" else ""
                val v = "$sqlVar.get$ts(1)$postfix"
                if (sqlType.isNullableNumeric)
                    """
                    {
                        ${sqlType.serviceDeclaration()} v = $v;
                        $sqlVar.wasNull() ? null : v;
                    }"""
                else v
            }
        }
    }

public fun sqlGetter(type: DataScriptType, name: String, index: Int, prefix: String?, transUtf: Boolean): CharSequence =
        when (type) {
            is DataScriptType.Enum ->
                if (prefix != null) """
                    $prefix.$name = ${type.enumRef.name}.select(rs,$index);
                    """
                else "${type.enumRef.name}.select(rs,$index)"
            is DataScriptType.Sql -> {
                val sqlType = type.sqlType
                if (sqlType == null) ""
                else {
                    val ts = sqlType.partOfExpression()
                    val postfix = if (sqlType == ColumnType.BOOLEAN) " == 1" else ""
                    val v = "rs.get$ts($index)$postfix"
                    if (sqlType.isNullableNumeric) {
                        val sp = if (prefix != null) "$prefix.$name = " else "return "
                        val se = if (prefix != null) ";\n" else ""
                        """
                        {
                        ${sqlType.serviceDeclaration()} v = $v;
                        $sp = rs.wasNull() ? null : v;
                        }$se"""
                    }
                    else {
                        val vv = if (transUtf) "com.acc.server.utils.TranslateRomUtf.translate($v)" else v
                        if (prefix != null) """
                            $prefix.$name = $vv;
                            """
                        else vv
                    }
                }
            }
        }

public fun statementSetter(type: DataScriptType, name: String, index: Int, source: String): CharSequence =
        when (type) {
            is DataScriptType.Enum -> """
                $source$name.setValue(st,$index);
                """
            is DataScriptType.Sql -> {
                val sqlType = type.sqlType
                if (sqlType == null) ""
                else {
                    val ts = sqlType.partOfExpression()
                    if (sqlType.isNullableNumeric) """
                        if ($source$name == null) {
                            st.setNull($index, java.sql.Types.INTEGER);
                        } else {
                            st.set$ts($index, $source$name.${sqlType.serviceDeclaration()}Value());
                        }
                        """
                    else {
                        val postfix = if (sqlType == ColumnType.BOOLEAN) " ? 1 : 0" else ""
                        """
                        st.set$ts($index,$source$name$postfix);
                        """
                    }
                }
            }
        }
