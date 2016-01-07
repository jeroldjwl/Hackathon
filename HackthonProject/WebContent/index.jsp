<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.och.hackthon.services.BookService"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.och.hackthon.services.UserService"%>
<%@page import="com.och.hackthon.util.DBConnUtil"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/index.css" />
<title>home</title>
</head>
<body>
	<div class="toplogin">
		<div class="loginright">
			<div class="loginbutton">
				<form id="formlogin"
					action="/HackthonProject/servlet/UserLoginServlet" method="post"
					class="toplogin">
					<label for="user" class="entypo-user"></label> <input id="user"
						type="text" class="toplogin" name="username"
						placeholder="username"> <label for="pwd"
						class="entypo-lock"></label> <input id="id" type="password"
						class="pass" name="password" placeholder="password">
					<button id="userloginbutton" class="submit">Login</button>
					<a id="userregister" href="/register.jsp"
						style="margin-right: 10px;">Register</a>
				</form>
			</div>
		</div>
	</div>
	<div class="upper">
		<div class="wrap">
			<div class="right">
				<div class="searchModule">
					<div class="searchWrap">
						<div class="form">
							<input type="text"
								onkeydown="javascript:if(event.keyCode==13) search('key');"
								autocomplete="off" id="key" accesskey="s" class="text"
								clstag="shangpin|keycount|toplist1|b02">
							<button onclick="search('key');return false;"
								class="button cw-icon" clstag="shangpin|keycount|toplist1|b03">
								<i></i>Search
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="results_container">
		<div class="tabletoolbar">Table Tool Bar</div>
		<div class="pag_chunk">pag_chunk</div>
		<table class="searchRes_table " id="searchanchor_9781784399092"
			cellspacing="0" cellpadding="0" style="margin-top: 10px;">
			<tbody>
				<%
					ResultSet rs = null;
					UserService us = new UserService();
					BookService bs = new BookService();
					Connection conn = DBConnUtil.getConnection();
					rs = bs.getAllBooks(conn);
					 while (rs.next()) {
						out.println(
								rs.getString("BookNo") + ", " + rs.getString("BookName") + ", " + rs.getString("Description")+","+rs.getString("imgPath")+rs.getString("Publisher")+rs.getString("Author"));
				%>
				<tr valign="top">
					<td class="searchRes_number" width="6%">
						<div style="width: 100%;"></div> <input class="booklistcheckbox"
						type="checkbox" name="vehicle" value="1" />
					</td>
					<td class="searchRes_details" width="45%">
						<div style="width: 100%;"></div>
						<div class="result_itemBlock">
							<div class="bluBrdrBox1">
								<div class="blubr1ct">
									<div class="blubr1cl"></div>
									<div class="blubrBoxContent">
										<div class="bookpicture">
											<img class="bookCover"
												alt="RESTful Java Web Services - Second Edition"
												title="RESTful Java Web Services - Second Edition"
												width="76" src=<%= rs.getString("imgPath") %>>
										</div>
										<div class="bookData">
											<p class="p bookTitle"><%= rs.getString("BookName")%></p>
											<p class="p bookText bookAuthors">
												<strong class="strong">By:&nbsp;</strong>
												<%= rs.getString("Author")%>
											</p>
											<p class="p bookText bookPublisher">
												<strong class="strong">Publisher:&nbsp;</strong>
												<%= rs.getString("Publisher") %>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</td>
					<td class="searchRes_content" width="30%">
						<div style="width: 100%;">
							<p class="p section_info">Chapter Title: Asynchronous RESTful
								web services</p>
							<div class="snippet">
								<%=rs.getString("Description")%>
							</div>
						</div>
					</td>
				</tr>
				<%}
		%>	 
			</tbody>
		</table>
		<div class="bottom"></div>

	</div>
</body>
</html>