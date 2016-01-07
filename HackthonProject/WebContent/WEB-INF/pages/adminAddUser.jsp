<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="images/div.css" type="text/css" rel=stylesheet>
</head>
<body>
		<div id="info_table"><br>			
			<div id="stuInfo"><br><br><font size="3">Add User<br><br>
					<table border="0" align="center">
						<tr>
							<td align="Left">User ID：</td>
							<td><input type="text" name="stuNO"></td>
						</tr>
						<tr>
							<td align="Left">User Name：</td>
							<td><input type="text" name="stuName"></td>
						</tr>
						<tr>
							<td align="Left">Age：</td>
							<td><input type="text" name="age"></td>							
						</tr>
						<tr>
							<td align="Left">Gender：</td>
							<td>
								<input type="radio" name="gender" value="Female" checked="true">Female
								<input type="radio" name="gender" value="Male">Male
							</td>
						</tr>
						<tr>
							<td><input type="hidden" name="action" value="add_stu"></td>
							<td>
                    <input type="button" value="Add" onclick="checkAddStu()"> 

                    <input type="reset" value="Empty"> 							
							</td>
						</tr>
					</table>

			</div>

		</div>
</body>
</html>