<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户登陆</title>       
    <link rel="stylesheet" href="../assets/css/login.css" /> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(".user").focusin(function(){
  $(".inputUserIcon").css("color", "#e74c3c");
}).focusout(function(){
  $(".inputUserIcon").css("color", "white");
});

$(".pass").focusin(function(){
  $(".inputPassIcon").css("color", "#e74c3c");
}).focusout(function(){
  $(".inputPassIcon").css("color", "white");
});
</script>
  </head>
  
  <body>
  <!--  
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
    	用户名：<input type="text" name="username"><br/>
    	密码：<input type="password" name="password"><br/>
    	<input type="submit" value="登陆">
    </form>
    -->
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
	  <h2><span class="entypo-login"></span> Login</h2>
	  <button class="submit"><span class="entypo-lock"></span></button>
	  <span class="entypo-user inputUserIcon"></span>
	  <input type="text" class="user" placeholder="ursername"/>
	  <span class="entypo-key inputPassIcon"></span>
	  <input type="password" class="pass"placeholder="password"/>
    </form>
  </body>
</html>