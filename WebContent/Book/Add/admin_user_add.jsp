<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生增加界面</title>
<style type="text/css">
.add{
    position:relative;
	top:60%;
}
</style>
</head>
<body>
<center>
<div class="add">
	<form action="http://localhost:8080/BookManagement/AdminUserAdd" method="post">
		<table  border="0" >
		    <tr><td ></td><td><input type="hidden" name="nameuserAdd" value="null"/></td></tr><tr><td></td><td></td></tr>
			<tr><td >学号</td><td><input type="text" name="sid" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >姓名</td><td><input type="text" name="name" size="40" /></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >性别</td><td><input type="text" name="sex" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >专业</td><td><input type="text" name="major" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >已借图书</td><td><input type="text" name="lend" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >账号</td><td><input type="text" name="account" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >密码</td><td><input type="text" name="password" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr align="center">
				<td colspan="5">
					<input type="submit" value="添 加">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="取消">
				</td>
			</tr>
		</table>
	</form>
</div>
</center>
</body>
</html>