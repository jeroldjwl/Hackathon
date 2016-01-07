<%@page import="com.och.hackthon.services.BookService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.och.hackthon.services.UserService"%>
<%@page import="com.och.hackthon.util.DBConnUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This is a test2 page!

	<%
	ResultSet rs = null;
	UserService us = new UserService();
	BookService bs = new BookService();
	Connection conn = DBConnUtil.getConnection();
	/* rs = us.getAllUsers(conn);
	while (rs.next()) {
		out.println(rs.getString("UserName") + ", " + rs.getString("NickName") + ", " + rs.getInt("Age"));
	} */
	rs = bs.getAllBooks(conn);
	while (rs.next()) {
		out.println(
				rs.getString("BookNo") + ", " + rs.getString("BookName"));
	}
%>
</body>
</html>