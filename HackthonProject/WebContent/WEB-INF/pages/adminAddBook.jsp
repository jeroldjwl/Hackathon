<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- button unlink -->>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/div.css" type="text/css" rel=stylesheet>
</head>
<body>	
		<div id="info_table"><br>			
			<div id="stuInfo"><br><br><font size="3">add book<br><br>
				
					<table border="0" align="center">
						<tr>
							<td align="left">book id</td>
							<td><input type="text" name="bNO"></td>
						</tr>
						<tr>
							<td align="left">book name</td>
							<td><input type="text" name="bName"></td>
						</tr>
						<tr>
							<td align="left">author：</td>
							<td><input type="text" name="author"></td>							
						</tr>
						<tr>
							<td align="left">press</td>
							<td><input type="text" name="publish"></td>
						</tr>
						<tr>
							<td align="left">ISBN no.</td>
							<td><input type="text" name="isbn"></td>
						</tr>
						<tr>
							<td align="left">price</td>
							<td><input type="text" name="price"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="action" value="add_book"></td>
							<td><input type="button" value="add" >
							<input type="reset" value="reset"></td>
						</tr>
					</table>
			
		</div> 
</body>
</html>