<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./assets/js/jquery.min.js"></script>
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
					alert("失败，请稍后再试！");
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
					alert("失败，请稍后再试！");
				}
			});
		});
	})
</script>
</head>
<body>
	<div>
		<div class="left">
			<table>
				<tr>
					<td><input type="button" id="userManage" class="userManage"
						value="用户管理" /></td>
				</tr>
				<tr>
					<td><input type="button" id="bookManage" class="bookManage"
					  value="图书管理" /></td>
				</tr>
			</table>
		</div>
		<div class="right">
			<div id="mainContent"></div>
		</div>
	</div>
</body>
</html>