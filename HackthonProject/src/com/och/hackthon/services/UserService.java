package com.och.hackthon.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.och.hackthon.models.Person;
import com.och.hackthon.models.User;
import com.och.hackthon.util.DBConnUtil;

public class UserService {
	public User getUser(String userName, Connection conn) {
		PreparedStatement ps = null;
		User user = null;
		try {
			ps = conn.prepareStatement(getUserSQL);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				user = new User(rs);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.releaseConn();
		}
		return user;
	}

	public boolean registerUser(User u, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(registerSQL);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
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

	public boolean insertUser(User u, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(insertSQL);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getNickName());
			ps.setString(3, u.getRealName());
			ps.setString(4, u.getAddress());
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

	private String getUserSQL = "select * from User where UserName=?";

	private String registerSQL = "insert into User (UserName, Password) values(?,?)";

	private String insertSQL = "insert into User (name, age, height, address) values(?,?,?,?)";

	private String updateSQL = "update User set name=?";

	private String deleteSQL = "delete from person where id=?";
}
