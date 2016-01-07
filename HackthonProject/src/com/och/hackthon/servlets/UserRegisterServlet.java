package com.och.hackthon.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.och.hackthon.models.User;
import com.och.hackthon.util.DBConnUtil;

import com.och.hackthon.services.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 澶勭悊鐢ㄦ埛娉ㄥ唽鐨凷ervlet
 * @author gacl
 *
 */
public class UserRegisterServlet extends HttpServlet {
	
	
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		boolean isOk = true;
		
		Connection conn = DBConnUtil.getConnection();
		
		String username = req.getParameter("userName");
		
		System.out.println(username);
		
		String password = req.getParameter("password");
		
		System.out.println(password);
		
		if (username == null || username.trim().equals("")) {
			isOk = false;
			System.out.println("username must not be null.");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		} else {
			if (!username.matches("^1[0-9]{10}$")) {
				isOk = false;
				System.out.println("username must be 11 number");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			}
		}

		if (password == null || password.trim().equals("")) {
			isOk = false;
			System.out.println("password can not be empty");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		} else {
			if (!password.matches("\\d{3,8}")) {
				isOk = false;
				System.out.println("password must be 3-8 number.");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
			}
		}
		
		try {
			

			User user = new User();
			
			user.setUserName(username);
			user.setPassword(password);
			
			
			UserService service = new UserService();
			
			
			if(service.getUser(username, conn)!=null){
				System.out.println("sorry, user exists.");
				req.getRequestDispatcher("/register.jsp").forward(req, resp);
				return;
			}
			
			service.registerUser(user, conn);
			
			req.getRequestDispatcher("/WEB-INF/pages/userHome.jsp").forward(req,resp);

		} catch (Exception e) {
			e.printStackTrace(); 
			req.getRequestDispatcher("/register.jsp").forward(req,resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
