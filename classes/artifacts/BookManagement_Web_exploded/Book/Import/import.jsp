<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息导入excel</title>
</head>
<body>
         请先选择导入的文件，然后点击导入：<hr width="100%" size="3"><br><br><br>
	<form action="http://localhost:8080/BookManagement/ImportStudent">
		<tr><h2><input type="file" name="file"></h2></tr>
		<tr><h2><input type="submit" value="点击导入" class="tj"></h2></tr>
	</form>
</body>
</html>