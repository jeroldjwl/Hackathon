package com.och.hackthon.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			if (rs.next()) {
				user = new User(rs);
			}
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.releaseConn();
		}
		return user;
	}

	public ResultSet getAllUsers(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(getAllUserSQL);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.releaseConn();
		}
		return rs;
	}

	public boolean registerUser(User u, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(registerSQL);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, 1);
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
			ps.setInt(4, u.getAge());
			ps.setInt(5, u.getGender());
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getPassword());
			ps.setInt(8, u.getUserRole());
			ps.setString(9, u.getEmail());
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

	public boolean updateUser(User u, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(updateSQL);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getNickName());
			ps.setString(3, u.getRealName());
			ps.setInt(4, u.getAge());
			ps.setInt(5, u.getGender());
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getPassword());
			ps.setInt(8, u.getUserRole());
			ps.setString(9, u.getEmail());

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

	public boolean delete(String userName, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(deleteSQL);
			ps.setString(1, userName);
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

	private String getUserSQL = "select * from User where UserName = ?";

	private String registerSQL = "insert into User (UserName, Password, UserRole) values(?,?,?)";

	private String insertSQL = "insert into User (UserName, NickName, RealName, Age, Gender, Address, Password, UserRole, Email) values(?,?,?,?,?,?,?,?,?)";

	private String updateSQL = "update User set UserName = ?, NickName = ?, RealName = ?, Age = ?, Gender = ?, Address = ?, Password = ?, UserRole = ?, Email = ?";;

	private String deleteSQL = "delete from User where UserName= ?";

	private String getAllUserSQL = "select UserName, NickName, RealName, Age, Gender, Address, UserRole, Email from User";
}
