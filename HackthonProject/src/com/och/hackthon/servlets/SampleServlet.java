package com.och.hackthon.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.och.hackthon.services.UserService;
import com.och.hackthon.util.DBConnUtil;

public class SampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = (String) req.getAttribute("userName");
		ResultSet rs = null;
		UserService us = new UserService();
		Connection conn = DBConnUtil.getConnection();
		rs = us.getAllUsers(conn);
		req.getSession().setAttribute("users", rs);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
