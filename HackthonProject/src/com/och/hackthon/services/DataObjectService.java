package com.och.hackthon.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.och.hackthon.models.Person;
import com.och.hackthon.util.DBConnUtil;

public class DataObjectService {

	public void getOperation(Connection conn) {
		ResultSet set = null;
		Statement stat = null;
		try {
			stat = conn.createStatement();
			set = stat.executeQuery(selectSQL);
			while (set.next()) {
				String name = set.getString("name");
				int age = set.getInt("age");
				System.out.println("Name is" + name + " age is:" + age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertOperation(Person p, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(insertSQL);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setInt(3, p.getHeight());
			ps.setString(4, p.getAddress());
			int flag = ps.executeUpdate();
			if (flag == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.releaseConn();
		}
		return true;
	}

	public boolean updateOperation(Person p, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(updateSQL);
			ps.setString(1, p.getAddress());
			int flag = ps.executeUpdate();
			if (flag == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.releaseConn();
		}
		return true;
	}

	public boolean delete(Person p, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(deleteSQL);
			ps.setString(1, p.getName());
			int flag = ps.executeUpdate();
			if (flag == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.releaseConn();
		}
		return true;
	}

	private String selectSQL = "select * from person";

	private String insertSQL = "insert into person (name, age, height, address) values(?,?,?,?)";

	private String updateSQL = "update person set name=?";

	private String deleteSQL = "delete from person where id=?";
}
