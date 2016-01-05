package com.acc.datascript.generator.helpers

/**
 * Created by demius on 05.01.2016.
 */

def resultSetGetter(DataScriptType type, String sqlVar) {
    switch type {
        DataScriptEnumType: {
        '''«type.enumRef.name».select(«sqlVar»,1)'''
    }
        default: {
        val sqlType = type.sqlType
        val ts = sqlType.partOfExpression
        val postfix = if (sqlType == ColumnType.BOOLEAN) " == 1" else ""
        val v = '''«sqlVar».get«ts»(1)«postfix»'''
        if (sqlType.nullableNumeric) {
            '''
            {
                «sqlType.serviceDeclaration» v = «v»;
                «sqlVar».wasNull() ? null : v;
            }'''
        } else {
            '''«v»'''
        }
    }
    }
}

def resultSetGetter(DataScriptType type, String name, int index, String prefix, boolean trans_utf) {
    switch type {
        DataScriptEnumType: {
        if (prefix != null) '''
        «prefix».«name» = «type.enumRef.name».select(rs,«index»);
        '''
        else '''«type.enumRef.name».select(rs,«index»)'''
    }
        default: {
        val sqlType = type.sqlType
        val ts = sqlType.partOfExpression
        val postfix = if (sqlType == ColumnType.BOOLEAN) " == 1" else ""
        val v = '''rs.get«ts»(«index»)«postfix»'''
        if (sqlType.nullableNumeric) {
            '''
            {
                «sqlType.serviceDeclaration» v = «v»;
                «IF prefix != null»«prefix».«name» = rs.wasNull() ? null : v;«ELSE»return rs.wasNull() ? null : v;«ENDIF»
            }«IF prefix != null»;
            «ENDIF»'''
        } else {
            val vv = if (trans_utf) '''com.acc.server.utils.TranslateRomUtf.translate(«v»)''' else v
            if (prefix != null) '''
            «prefix».«name» = «vv»;
            '''
            else '''«vv»'''
        }
    }
    }
}

def statementSetter(DataScriptType type, String name, int index, String source) {
    switch type {
        DataScriptEnumType: {
        '''
        «source»«name».setValue(st,«index»);
        '''
    }
        default: {
        val sqlType = type.sqlType
        val ts = sqlType.partOfExpression
        if (sqlType.nullableNumeric) {
            '''
            if («source»«name» == null) {
                st.setNull(«index»,java.sql.Types.INTEGER);
            } else {
                st.set«ts»(«index»,«source»«name».«sqlType.serviceDeclaration»Value());
            }
            '''
        } else {
            val postfix = if (sqlType == ColumnType.BOOLEAN) " ? 1 : 0" else ""
            '''
            st.set«ts»(«index»,«source»«name»«postfix»);
            '''
        }
    }
    }
}

