package com.acc.datascript.resources;

import java.sql.ResultSet;

@FunctionalInterface
public interface SqlConstructor<T> {
	public T construct(ResultSet resultSet) throws Exception;
	
}
