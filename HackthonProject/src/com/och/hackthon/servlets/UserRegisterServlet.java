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
		
		
		try {
			
			boolean isOk = true;
			
			DBConnUtil dbConnUtil = new DBConnUtil();
			
			Connection conn = dbConnUtil.getConnection();
			
			String username = req.getParameter("username");
			
			String password = req.getParameter("password");
			
			if (username == null || username.trim().equals("")) {
				isOk = false;
				errors.put("username", "用户名不能为空！！");
			} else {
				if (!username.matches("\\d{11}")) {
					isOk = false;
					errors.put("username", "用户名必须是11位的手机号码！！");
					return;
				}
			}

			if (password == null || password.trim().equals("")) {
				isOk = false;
				errors.put("userPwd", "密码不能为空！！");
			} else {
				if (!password.matches("\\d{3,8}")) {
					isOk = false;
					errors.put("userPwd", "密码必须是3-8位的数字！！");
					return;
				}
			}
			

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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

}
