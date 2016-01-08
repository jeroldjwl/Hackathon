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
<link rel="stylesheet" href="assets/css/userHome.css" />
<title>home</title>
</head>
<body>
	<div class="toplogin">
		<ul class="rightLinks">
			<li><a href="#" class="dropdownToggle" id="userName"> <span
					class="text" style="margin-right: 300px; color: white;">Hello,
						Galia </span></a></li>
			<!-- <div id="userDropdown" class="dropdown"
					style="left: -999em; top: 122px;">
					<div class="inner">
						<div class="top" style="top: -32px;">
							<div class="tab">
								<div class="dropdownToggle" href="#">
									<span class="text">Haixia Cheng</span><span class="icon"></span>
								</div>
							</div>
						</div>
						<div class="dropdownBody">
							<ul class="iconizedLinks">
								<li class="account"><a href="/myaccount"><span></span><h5>Account</h5></a></li>
								<li class="orders"><a href="/mydownloads"><span></span><h5>Orders</h5>
										</a></li>
								<li><h5>
									<a href="/myrecentpages"><strong>Borrowed List</strong></a>
								</h5></li>
								<li class="signout"><a title="Sign Out"
									href="/logout?targetpage=/home?uicode=oracle"><span></span><h5>Sign
										Out</h5></a></li>
							</ul>

							
						</div>
					</div>
				</div> -->
		</ul>
	</div>
	<div class="upper">
		<div class="wrap">
			<div class="left">
				<h1 class="logo" style="" itemprop="provider" color="write">
					Jurney Library</h1>
			</div>
		</div>
	</div>
	<div class="pagewrap" id="pagewrapid">
		<div id="pagetopid"></div>
		<div class="searchRes_container ">
			<div class="BookpaneR">
				<img class="book_cover"
					alt="RESTful Java Web Services - Second Edition"
					title="RESTful Java Web Services - Second Edition" width="145"
					src="images/9781784399092_s.jpg" itemprop="image">
				<ul class="metadatalist" width=50%>
					<li><h3 class="h3 book_title">
							<span>RESTful Java Web Services - Second Edition</span>
						</h3></li>
					<li><p class="p data">
							<strong class="strong">By: </strong>Jobinesh Purushothaman
						</p></li>
					<li><p class="p data">
							<strong class="strong">Publisher: </strong><span>Packt
								Publishing</span>
						</p></li>
					<li><p class="p data">
							<strong class="strong">Pub. Date: </strong><span>September
								22, 2015</span>
						</p></li>
					<li><p class="p data">
							<strong class="strong">Print ISBN-13: </strong><span>978-1-78439-909-2</span>
						</p></li>
					<li><p class="p data">
							<strong class="strong">Web ISBN-13: </strong><span>978-1-78439-637-4</span>
						</p></li>
					<li><p class="p data">
							<strong class="strong">Pages in Print Edition: </strong><span>354</span>
						</p></li>
				</ul>
				<form action="/HackthonProject/servlet/UserOperationServlet">
				<input type = "hidden" name="action" value="borrowBooks">			
					<button type="submit" class="booklistsubmit" style="margin-top: 50px;">SUBMIT</button>
				</form>
			</div>
		</div>
		</div>
		
</body>
</html>