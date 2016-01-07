<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/div.css" type="text/css" rel=stylesheet>
</head>
<body>
		<div id="info_table">
			<div id="stuInfo"><br><br><font size="3">User editing info<br><br>
				<table border="0" align="center">
				<tr>
					<td align="Left">User ID:</td>
					<td>
						<input type="text" name="newNO" value=" ">
					</td>
				</tr>
				<tr>
					<td align="Left">Name：</td>
					<td>
						<input type="text" name="stuName" value=" ">
					</td>
				</tr>
				<tr>
					<td align="Left">Age：</td>
					<td>
						<input type="text" name="age" value=" ">
					</td>
				</tr>
				<tr>
					<td align="Left">Gender：</td>
					<td>
						<input type="radio" name="gender" value="Female" checked="true">Female
						<input type="radio" name="gender" value="Male" checked="true">Male
					</td>
				</tr>
				<tr>
					<td>
						<input type="hidden" name="action" value="save_stu">
						<input type="hidden" name="stuNO" value=" ">						
					</td>					
					<td>
						 <input type="button" value="save" onclick="checkEditStu()"> 
						<input type="reset" value="reset">  
					</td>
				</tr>
				<tr>
				</tr>
				</table>
			</div>
		</div>
</body>
</html>