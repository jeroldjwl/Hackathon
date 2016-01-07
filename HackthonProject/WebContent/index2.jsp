<%@ page language="java" pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>首页</title>
<link rel="stylesheet" href="assets/css/main.css" />
<script type="text/javascript">
	function doLogout() {
		//访问LogoutServlet注销当前登录的用户
		window.location.href = "${pageContext.request.contextPath}/servlet/LogoutServlet";
	}
</script>
</head>

<body>
	<h1>首页网站</h1>
	<hr />
	<c:if test="${user==null}">
	
		<form name="logout" action="servlet/UserOperationServlet" method="post">
			用户名：<input type="text" name="username"><br/>
    		密码：<input type="password" name="password"><br/>
    		<input type="hidden" name="action" value="logout">
    		<input type="submit" value="logout">
		</form>
		<a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet"
			target="_blank">注册03</a>
		<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet"
			target="_blank">登陆</a>
	</c:if>
	<c:if test="${user!=null}">
   		欢迎您：${user.userName}
   		<input type="button" value="退出登陆" onclick="doLogout()">
	</c:if>
	<hr />
</body>
</html>
