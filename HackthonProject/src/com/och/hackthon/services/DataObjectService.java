package com.och.hackthon.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataObjectService {
	public Connection getConnection() {
		return ConnectionFactory.getConnection();
	}

	public void getPerson() throws SQLException {
		Connection conn = getConnection();
		ResultSet set = null;
		Statement stat = null;
		stat = conn.createStatement();
		set = stat.executeQuery(getPersonSQL);
		while (set.next()) {
			String name = set.getString("name");
			int age = set.getInt("age");
			System.out.println("Name is" + name + " age is:" + age);
		}
	}

	private String getPersonSQL = "select * from person;";
}
