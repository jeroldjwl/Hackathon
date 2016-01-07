<%@page import="com.och.hackthon.util.DBConnUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.och.hackthon.services.UserService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/index.css" />
<title>Insert title here</title>
</head>
<body>
	<table class="searchRes_table " id="searchanchor_9781784399092"
		cellspacing="0" cellpadding="0" style="margin-top: 10px;">
		<tbody>
			<tr>
				<td><p>UserName:</p></td>
				<td><p>NickName:</p></td>
				<td><p>RealName:</p></td>
				<td><p>Address:</p></td>
				<td><p>Email:</p></td>
			</tr>
			<%
				response.setContentType("UTF-8");
				ResultSet rs = null;
				UserService us = new UserService();
				Connection conn = DBConnUtil.getConnection();
				rs = us.getAllUsers(conn);
				while (rs.next()) {
					out.println(rs.getString("UserName") + ", " + rs.getString("NickName") + ", " + rs.getString("RealName")
							+ "," + rs.getString("Address") + rs.getString("Email"));
			%>

			<tr>
				<td><p><%=rs.getString("NickName") == null ? "No" : rs.getString("NickName")%></p></td>
				<td><p><%=rs.getString("UserName") == null ? "No" : rs.getString("UserName")%></p></td>
				<td><p><%=rs.getString("NickName") == null ? "No" : rs.getString("NickName")%></p></td>
				<td><p><%=rs.getString("RealName") == null ? "No" : rs.getString("RealName")%></p></td>
				<td><p><%=rs.getString("Address") == null ? "No" : rs.getString("Address")%></p></td>
			</tr>
			<%
				}
			%>

		</tbody>
	</table>
</body>
</html>