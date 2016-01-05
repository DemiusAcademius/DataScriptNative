package com.acc.datascript.resources;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface SqlPreparator {
	public void prepare(PreparedStatement statement) throws SQLException;
	
}
