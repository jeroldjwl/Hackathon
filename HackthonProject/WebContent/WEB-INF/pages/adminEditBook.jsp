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
			<div id="stuInfo"><br><br><font size="3">book editing info</br></br>
					<table border="0" align="center">
						<tr>
							<td align="left">book id</td>
							<td><input type="text" name="newNO" value=" "></td>
						</tr>
						<tr>
							<td align="left">book name</td>
							<td><input type="text" name="bName" value=" "></td>
						</tr>
						<tr>
							<td align="left">author</td>
							<td><input type="text" name="author" value=" "></td>							
						</tr>
						<tr>
							<td align="left">press</td>
							<td><input type="text" name="publish" value=""></td>
						</tr>
						<tr>
							<td align="left">ISBN NO</td>
							<td><input type="text" name="isbn" value=" "></td>
						</tr>
						<tr>
							<td align="left">PRICE</td>
							<td><input type="text" name="price" value=" "></td>
						</tr>
						<tr>
							<td><input type="hidden" name="action" value="save_book">
							<input type="hidden" name="bNO" value=" "></td>
							<td>
<input type="button" value="save" > 
								
<input type="reset" value="reset"> 
</td>
</tr>					
					</table>

			</div>
</div>
</body>
</html>