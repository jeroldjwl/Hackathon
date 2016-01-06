package com.och.hackthon.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnUtil {
	private static Connection conn;

	public static Connection getConnection() {
		if (conn == null)
			return ConnectionFactory.getConnection();
		else
			return conn;
	}

	public static void releaseConn() {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
