package com.och.hackthon.tests;

import java.sql.Connection;

import org.junit.Test;

import com.och.hackthon.models.User;
import com.och.hackthon.services.UserService;
import com.och.hackthon.util.DBConnUtil;

public class UserOperationTest {
		
	@Test
	public void registerUser()
	{
		UserService us=new UserService();
		Connection conn=DBConnUtil.getConnection();
		User u=new User();
		u.setUserName("15921169285");
		u.setPassword("jwl1990");
		boolean flag=us.registerUser(u, conn);
		System.out.println(flag);
	}
	
	
}
