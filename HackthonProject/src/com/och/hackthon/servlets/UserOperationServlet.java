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


public class UserOperationServlet {
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
				req.getRequestDispatcher("login.jsp").forward(req,resp);
		    }
		    else if(action.equals("editUserName")){
		    	String newUserName = req.getParameter("newUserName").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setUserName(newUserName);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editNickName")){
		    	String newNickName = req.getParameter("newNickName").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setNickName(newNickName);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editRealName")){
		    	String newRealName = req.getParameter("newRealName").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setRealName(newRealName);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editPassword")){
		    	String newPassword = req.getParameter("newPassword").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setPassword(newPassword);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editAge")){
		    	int newAge = Integer.parseInt(req.getParameter("newAge"));
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setAge(newAge);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editGender")){
		    	int newGender = Integer.parseInt(req.getParameter("newGender"));
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setGender(newGender);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("editAddress")){
		    	String newAddress = req.getParameter("newAddress").trim();
		    	User user=(User)req.getSession().getAttribute("user");
		    	user.setAddress(newAddress);
		    	req.getRequestDispatcher("userHome.jsp").forward(req,resp);
		    }
		    else if(action.equals("borrowBooks")){
		    	Connection conn = DBConnUtil.getConnection();
		    	String bookNO = req.getParameter("bookNO");
				String bookName = req.getParameter("bookName");
				BookService service = new BookService();
		    }
	}
}
