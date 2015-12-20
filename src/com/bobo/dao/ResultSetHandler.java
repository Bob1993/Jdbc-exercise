package com.bobo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler {
	abstract Object doHandler(ResultSet rs) throws SQLException;
}
 