package com.och.hackthon.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.och.hackthon.models.User;


import com.och.hackthon.services.UserService;
import service.impl.UserServiceImpl;
import com.och.hackthon.util.DBConnUtil;

public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		DBConnUtil dbConnUtil = new DBConnUtil();
		
		Connection conn = dbConnUtil.getConnection();
		
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
				
		UserService service = new UserService();
		
		User user = service.getUser(username, conn);
				
		if(password != user.getPassword()){
				String message = String.format(
						"对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'", 
						req.getContextPath()+"/servlet/LoginUIServlet");
				req.setAttribute("message",message);
				req.getRequestDispatcher("/message.jsp").forward(req, resp);
				return;
			}
		
		req.getSession().setAttribute("user", user);
		String message = String.format(
				"恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'", 
				user.getUserName(),
				req.getContextPath()+"userHome.jsp");
		req.setAttribute("message",message);
		req.getRequestDispatcher("/message.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
}
