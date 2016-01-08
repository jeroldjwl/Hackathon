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
		Connection conn = DBConnUtil.getConnection();

		String username = req.getParameter("username");

		String password = req.getParameter("password");

		UserService service = new UserService();
		
		User user = service.getUser(username, conn);
		
		if(user.equals(null)){
			System.out.println("sorry, user does not exists.");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
		
		if(user.getUserRole() == 0)
		{
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/admin.jsp").forward(req, resp);
		}
		else {
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/pages/userHome.jsp").forward(req, resp);
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
