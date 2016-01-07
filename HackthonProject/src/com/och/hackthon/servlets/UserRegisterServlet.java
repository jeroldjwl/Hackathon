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

/**
 * 澶勭悊鐢ㄦ埛娉ㄥ唽鐨凷ervlet
 * @author gacl
 *
 */
public class UserRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			
			DBConnUtil dbConnUtil = new DBConnUtil();
			
			Connection conn = dbConnUtil.getConnection();
			
			String username = req.getParameter("username");
			
			String password = req.getParameter("password");

			User user = new User();
			
			user.setUserName(username);
			user.setPassword(password);
			
			
			UserService service = new UserService();
			
			if(service.getUser(username, conn)!=null){
				System.out.println("对不起, 用户已存在.");
				req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
				return;
			}
			
			service.registerUser(user, conn);
			String message = String.format(
					"注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
					req.getContextPath()+"/servlet/LoginUIServlet");
			req.setAttribute("message",message);
			req.getRequestDispatcher("/message.jsp").forward(req,resp);

		} catch (Exception e) {
			e.printStackTrace(); 
			req.setAttribute("message", "对不起，注册失败！！");
			req.getRequestDispatcher("/message.jsp").forward(req,resp);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
