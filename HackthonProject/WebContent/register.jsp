<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>用户注册</title>
	</head>

	<body style="text-align: center;">
		<form action="${pageContext.request.contextPath}/servlet/UserRegisterServlet" method="post">
			<table width="60%" border="1">
				<tr>
					<td>username(telephone number)</td>
					<td>
						<%--01使用EL表达式${}提取存储在request对象中的formbean对象中封装的表单数据(formbean.userName)以及错误提示消息(formbean.errors.userName)--%>
						<input type="text" name="userName">
					</td>
				</tr>
				<tr>
					<td>password(3-8 digit number)</td>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td>confirm</td>
					<td>
						<input type="password" name="confirmPwd">
					</td>
				</tr>
				<tr>
				<!--  
					<td>邮箱</td>
					<td>
						<input type="text" name="email" value="${formbean.email}">${formbean.errors.email}
					</td>
				</tr>
				<tr>
					<td>生日</td>
					<td>
						<input type="text" name="birthday" value="${formbean.birthday}">${formbean.errors.birthday}
					</td>
				</tr>
				-->
				<tr>
					<td>
						<input type="reset" value="reset">
					</td>
					<td>
						<input type="submit" value="register">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
