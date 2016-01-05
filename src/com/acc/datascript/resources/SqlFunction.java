package com.acc.datascript.resources;

import java.sql.ResultSet;

@FunctionalInterface
public interface SqlFunction<T> {
	public T apply(ResultSet resultSet) throws Exception;
	
}
