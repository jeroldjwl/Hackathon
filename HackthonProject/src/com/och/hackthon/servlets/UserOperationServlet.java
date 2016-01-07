package com.och.hackthon.servlets;

import java.io.*;
import java.sql.Connection;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.och.hackthon.models.User;
import com.och.hackthon.services.BookService;
import com.och.hackthon.services.UserService;
import com.och.hackthon.util.DBConnUtil;


public class UserOperationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		    	this.doPost(req,res);
	}   	    
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException,IOException{
			
		    resp.setCharacterEncoding("GBK");											
		    req.setCharacterEncoding("GBK");				
		    HttpSession session = req.getSession();			
		    String action = req.getParameter("action");
		    
		    if(action.equals("logout")){
		    	req.getSession(true).invalidate();	
				req.getRequestDispatcher("/index.jsp").forward(req,resp);
		    }
		    else if(action.equals("editUserName")){
		    	Connection conn = DBConnUtil.getConnection();
		    	String newUserName = req.getParameter("newUserName").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setUserName(newUserName);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editNickName")){
		    	Connection conn = DBConnUtil.getConnection();
		    	String newNickName = req.getParameter("newNickName").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setNickName(newNickName);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editRealName")){
		    	Connection conn = DBConnUtil.getConnection();
		    	String newRealName = req.getParameter("newRealName").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setRealName(newRealName);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editPassword")){
		    	Connection conn = DBConnUtil.getConnection();
		    	String newPassword = req.getParameter("newPassword").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setPassword(newPassword);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editAge")){
		    	Connection conn = DBConnUtil.getConnection();
		    	int newAge = Integer.parseInt(req.getParameter("newAge"));
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setAge(newAge);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editGender")){
		    	Connection conn = DBConnUtil.getConnection();
		    	int newGender = Integer.parseInt(req.getParameter("newGender"));
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setGender(newGender);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editAddress")){
		    	Connection conn = DBConnUtil.getConnection();
		    	String newAddress = req.getParameter("newAddress").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setAddress(newAddress);
		    	UserService service = new UserService();
		    	boolean flag = service.updateUser(user, conn);
		    	req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("borrowBooks")){
		    	synchronized (this) {
		    		Connection conn = DBConnUtil.getConnection();
			    	String bookNO = req.getParameter("bookNO");
					String bookName = req.getParameter("bookName");
					int num = Integer.parseInt(req.getParameter("num"));
					BookService service = new BookService();
					int remainStock = service.borrowBook(bookNO, bookName, num, conn);
					req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
				}
		    }
		    else if(action.equals("returnBooks")){
		    	synchronized (this) {
		    		Connection conn = DBConnUtil.getConnection();
			    	String bookNO = req.getParameter("bookNO");
					String bookName = req.getParameter("bookName");
					BookService service = new BookService();
				}
		    }
		    else if(action.equals("pay")){
		    	String bookNO = req.getParameter("bookNO");
				String bookName = req.getParameter("bookName");
				int toNum = Integer.parseInt(req.getParameter("toNum"));
		    }
	}
}
