package com.acc.datascript.resources;

import java.sql.ResultSet;

@FunctionalInterface
public interface SqlConsumer {
	public void consume(ResultSet resultSet) throws Exception;
	
}
