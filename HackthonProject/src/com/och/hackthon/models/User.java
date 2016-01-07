package com.och.hackthon.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private String userName;
	private String nickName;
	private String realName;
	private String password;
	private int age;
	private int gender;
	private String address;
	private int userRole;
	private String email;

	public User() {

	}

	public User(ResultSet rs) {
		try {
			this.userName = rs.getString("UserName");
			this.nickName = rs.getString("NickName");
			this.realName = rs.getString("RealName");
			this.password = rs.getString("Password");
			this.age = rs.getInt("age");
			this.gender = rs.getInt("Gender");
			this.address = rs.getString("Address");
			this.userRole = rs.getInt("UserRole");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
