package com.och.hackthon.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static String URL = "jdbc:mysql://127.0.0.1:3306/hackthon";

	private static String USER = "hackthon";

	private static String PASSWORD = "hackthon";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			if (conn != null) {
				System.out.println("connect to database successfully!");
			}
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
