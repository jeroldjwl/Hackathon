<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/index.css" />
<title>home </title>
</head>
<body>
<div class="toplogin">
<div class ="loginright">
	<div class="loginbutton" >
		<form id="formlogin" action="/HackthonProject/servlet/LoginServlet" method="post" class="toplogin">
		  <label for="user" class="entypo-user"></label>
		  <input id="user" type="text" class="toplogin" name="username" placeholder="username" style="margin-top: 10px;">
		  <button class="submit">Login</button>
	    </form>
    </div>
    <div class="registerbutton">
    <form action="/HackthonProject/servlet/UserRegisterServlet" method="post" class="toplogin" >    
	  <label for="pwd" class="entypo-lock"></label>
	  <input id ="id" type="password" class="pass" name="password" placeholder="password">	  
      <button class="submit">Register</span></button>
    </form>
    </div>
    </div>
</div>
<div class="search">
	<div class="form">
			<input type="text" onkeydown="javascript:if(event.keyCode==13) search('key');" autocomplete="off" id="key" accesskey="s" class="text" clstag="shangpin|keycount|toplist1|b02">
			<button onclick="search('key');return false;" class="button cw-icon" clstag="shangpin|keycount|toplist1|b03"><i></i>Search</button>
		</div>
</div>
<!-- 
<div class ="results_container">
<div class = "tabletoolbar">Table Tool Bar</div>
<div class = "pag_chunk">pag_chunk</div>
<table class="searchRes_table " id="searchanchor_9781784399092" cellspacing="0" cellpadding="0">
  <tbody>
  <tr valign="top">
  <td class="searchRes_number" width="6%">
  <div style="width: 100%; "><p class="p itemCount">1.&nbsp;</p></div>
  </td>
  <td class="searchRes_details" width="45%">
<div class="blubrBoxContent">
<div class="bookpicture" >
  <img class="bookCover"  alt="RESTful Java Web Services - Second Edition" title="RESTful Java Web Services - Second Edition" width="76" src="/images/9781784399092_xs.jpg">
</div>
<div class="bookData">
  <p class="p bookTitle">
  RESTful Java   
  </p>
  <p class="p bookText bookAuthors">
  <strong class="strong">By:&nbsp;</strong>Jobinesh Purushothaman
  </p>
  <p class="p bookText bookPublisher">
  <strong class="strong">Publisher:&nbsp;</strong>Packt Publishing
  </p>
  <p class="p bookText bookPublicationDate">
  </p></div>
</div>
    </td></tr>
    </tbody>
    -->
</table><div class="bottom">		
</div>
		
	</div>
</body>
</html>