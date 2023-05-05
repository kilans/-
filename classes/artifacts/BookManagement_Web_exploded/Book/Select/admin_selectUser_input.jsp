<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理端查询用户页面</title>
</head>
<body>
<center>
	<form action="http://localhost:8080/BookManagement/Book/Select/admin_selectUser_output.jsp">
	<table>
	       <tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr>
		   <tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr>
	       <tr><td>账号：</td> <td><input type="text" name="account" size="30"></td></tr> 
		   <tr><td></td><td><input type="submit" value="查询">
		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <input type="reset" value="取消"></td></tr>
	</table>
	</form>
</center>
</body>
</html>