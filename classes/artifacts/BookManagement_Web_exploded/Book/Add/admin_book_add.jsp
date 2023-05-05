<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书增加界面</title>
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
	<form action="http://localhost:8080/BookManagement/AdminBookAdd" method="post">
		<table  border="0" >
		    <tr><td ></td><td><input type="hidden" name="namebookAdd" value="null"/></td></tr><tr><td></td><td></td></tr>
			<tr><td >书号</td><td><input type="text" name="id" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >书名</td><td><input type="text" name="bookname" size="40" /></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >作者</td><td><input type="text" name="author" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >价格</td><td><input type="text" name="price" size="40"/></td></tr>
			<tr><td></td><td></td></tr>
			<tr><td >备注</td><td><input type="text" name="remark" size="40"/></td></tr>
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