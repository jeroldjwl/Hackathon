<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
<link rel="stylesheet" href="assets/css/index.css" />
<title>Admin Page</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#userManage").click(function() {
			//var url = "index.jsp";
			var url = "servlet/SampleServlet";
			alert(1);
			var data = {};
			$.ajax({
				type : "get",
				async : false, //同步请求  
				url : url,
				data : data,
				timeout : 1000,
				success : function(dates) {
					alert(dates);
					$("#mainContent").html(dates);//要刷新的div  
				},
				error : function() {
					alert("failure,wait a moment!");
				}
			});
		});

		$("#bookManage").click(function() {
			//var url = "index.jsp";
			var url = "servlet/SampleServlet2";
			alert(2);
			var data = {};
			$.ajax({
				type : "get",
				async : false, //同步请求  
				url : url,
				data : data,
				timeout : 1000,
				success : function(dates) {
					alert(dates);
					$("#mainContent").html(dates);//要刷新的div  
				},
				error : function() {
					alert("failure,wait a moment!");
				}
			});
		});
	})
</script>
</head>
<body>
	<div class="toplogin">
		<div class="loginright">
			<div class="loginbutton">
				<form id="formlogin"
					action="/HackthonProject/servlet/UserLoginServlet" method="post"
					class="toplogin">
					<a id="userregister" href="index.jsp"
						style="margin-right: 10px;">logout</a>
					<p>Welcome to our library !</p>
				</form>
			</div>
		</div>
	</div>
	<div id="divnav2">
		<div class="left1">
			<table>
				<tr style="margin-top: 10px">
					<td><input type="button" id="userManage" class="userManage"
						value="User Manage" style="width:150px"/></td>
				</tr>
				<tr >
					<td style="margin-top: 50px"><input type="button" id="bookManage" class="bookManage"
						value="Book Manage" style="width: 150px" /></td>
				</tr>
			</table>
		</div>
		<div class="right1">
			<div id="mainContent"></div>
			<p>welcome</p>
		</div>
	</div>
</body>
</html>