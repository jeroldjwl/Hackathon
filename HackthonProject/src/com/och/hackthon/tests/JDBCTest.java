package com.och.hackthon.tests;

import java.sql.SQLException;

import com.och.hackthon.services.DataObjectService;

public class JDBCTest {
	public static void main(String args[]) throws SQLException {
		DataObjectService dos=new DataObjectService();
		dos.getConnection();
		dos.getPerson();
	}
}
