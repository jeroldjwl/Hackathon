package com.och.hackthon.tests;

import java.sql.Connection;

import org.junit.Test;

import com.och.hackthon.models.User;
import com.och.hackthon.services.UserService;
import com.och.hackthon.util.DBConnUtil;

public class UserOperationTest {

	@Test
	public void getUser() {
		UserService us = new UserService();
		Connection conn = DBConnUtil.getConnection();
		User u = us.getUser("15921169285", conn);
		System.out.println(u.getUserName());
		System.out.println(u.getPassword());
		String password="jwl1990";
		System.out.println(password.equals(u.getPassword()));
	}

	@Test
	public void registerUser() {
		UserService us = new UserService();
		Connection conn = DBConnUtil.getConnection();
		User u = new User();
		u.setUserName("15921169286");
		u.setPassword("jwl1990");
		boolean flag = us.registerUser(u, conn);
		System.out.println(flag);
	}

	@Test
	public void testJDBC() {
		DBConnUtil.getConnection();
	}

}
