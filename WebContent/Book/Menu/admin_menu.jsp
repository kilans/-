<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员菜单页面</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

.header {
	text-align: center;
	width: 100%;
	height: 75px;
	background-color: #609CCE;
}

.main {
	width: 100%;
	height: 1000px;
}

.daohang {
	width: 15%;
	height: 100%;
	float: left;
	background-color: #B0D8D8;
}

ul {
	white-space: nowrap;
	overflow: hidden;
	text-align: center;
}

li {
	overflow: hidden;
	margin-bottom: 10px;
	position: relative;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 3px;
	overflow: hidden;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.content {
	height: 100%;
	background-color: #B0D8D8;
}

.daohang ul li ul li{
    float:none;
}
.daohang ul li ul{
    display:none;
}
.daohang ul li:hover{
    background-color:#48D1CC;
    display: block;
}
.daohang ul li:hover ul{
    display: block;
}
</style>
</head>
<body>
	<div class="header">
		<h2>图书管理系统</h2>
		<h3>管理员界面</h3>
	</div>
	<div class="main">
		<div class="daohang">
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Select/admin_selectUser_input.jsp" target="menuFrame">查找用户</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Select/admin_selectUser_all.jsp" target="menuFrame">浏览用户</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Add/admin_book_add.jsp" target="menuFrame">添加图书</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Select/admin_selectBook_input.jsp" target="menuFrame">书名查找</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Select/admin_selectBook_all.jsp" target="menuFrame">浏览图书</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Add/admin_user_add.jsp" target="menuFrame">添加学生</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Import/import.jsp" target="menuFrame">批量导入</a></li>
				<li><a href="http://118.202.41.251:8080/BookManagement/Book/Login/admin_login.jsp">退出登录</a></li>
		</div>
		<div class="content">
			<iframe id="menuFrame" name="menuFrame"	
			style="background:url(http://118.202.41.251:8080/BookManagement/Book/Image/bg1.jpg);
			background-size:cover;
			width: 84%;height: 100%;
			float: right; frameborder: 0">
			</iframe>
		</div>
	</div>
</body>
</html>