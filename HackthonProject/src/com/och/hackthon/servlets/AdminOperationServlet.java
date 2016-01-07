package com.och.hackthon.servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.och.hackthon.models.Book;
import com.och.hackthon.models.User;
import com.och.hackthon.services.BookService;
import com.och.hackthon.services.UserService;
import com.och.hackthon.util.DBConnUtil;


public class AdminOperationServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		    	this.doPost(req,res);
	}   	    
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		    res.setCharacterEncoding("GBK");											
		    req.setCharacterEncoding("GBK");				
		    HttpSession session = req.getSession();			
		    String action = req.getParameter("action");								
		    if(action.equals("logout")){
		    	req.getSession(true).invalidate();	
				req.getRequestDispatcher("login.jsp").forward(req,res);
		    }
		    else if(action.equals("addUser")){
		    	String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				User user = new User();
				
				Connection conn = DBConnUtil.getConnection();
				
				user.setUserName(username);
				user.setPassword(password);
				
				UserService service = new UserService();
				
				boolean flag = service.insertUser(user, conn);
				
		    }
		    else if(action.equals("deleteUser")){
		    	String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				User user = new User();
				
				Connection conn = DBConnUtil.getConnection();
				
				user.setUserName(username);
				user.setPassword(password);
				
				
				UserService service = new UserService();
				
				boolean flag = service.delete(username, conn);
				
		    }
		    else if(action.equals("addBook")){
		    	String bookNO = req.getParameter("bookNO");
				String bookName = req.getParameter("bookName");
				int toNum = Integer.parseInt(req.getParameter("toNum"));
				
				Book book = new Book();
				
				Connection conn = DBConnUtil.getConnection();
				
				book.setBookNO(bookNO);
				book.setBookName(bookName);
				
				BookService service = new BookService();
				
				boolean flag = service.insertBook(book, toNum, conn);
		    }
		    else if(action.equals("deleteBook")){
		    	String bookNO = req.getParameter("bookNO");
				String bookName = req.getParameter("bookName");
				int stock = Integer.parseInt(req.getParameter("stock"));
				
				Book book = new Book();
				
				Connection conn = DBConnUtil.getConnection();
				
				book.setBookNO(bookNO);
				book.setBookName(bookName);
				
				BookService service = new BookService();
				
				boolean flag = service.deleteBook(bookNO, bookName, stock, conn);
		    }
		    else if(action.equals("SingleBookInfo")){
		    	String bookNO = req.getParameter("bookNO");
				String bookName = req.getParameter("bookName");
				Connection conn = DBConnUtil.getConnection();
				BookService service = new BookService();
		    	Book book = service.getBook(bookNO, bookName, conn);
		    	req.getSession().setAttribute("book", book);
		    }
		    else if(action.equals("AllBookInfo")){
		    	Connection conn = DBConnUtil.getConnection();
				BookService service = new BookService();
				ResultSet rs = service.getAllBooks(conn);
				req.getSession().setAttribute("allBookInfo", rs);
		    }
		    else if(action.equals("SingleUserInfo")){
		    	String username = req.getParameter("username");
		    	Connection conn = DBConnUtil.getConnection();
		    	UserService service = new UserService();
		    	User user = service.getUser(username, conn);
		    	req.getSession().setAttribute("user", user);
		    }
		    else if(action.equals("AllUserInfo")){
		    	Connection conn = DBConnUtil.getConnection();
		    	UserService service = new UserService();
		    	ResultSet rs = service.getAllUsers(conn);
		    	req.getSession().setAttribute("allUserInfo", rs);
		    }
	}
}

