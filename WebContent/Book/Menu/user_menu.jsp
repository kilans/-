<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="beans.*"%>
<%@ page import="dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户菜单页面</title>
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
    <%
        String account1=request.getParameter("account");
        UserDao dao=new UserDao();
        User user=dao.findUser(account1);
        session.setAttribute("account", account1);
        BookDao ncd = new BookDao();
	    String idx=ncd.find_ID(account1);//获取用户id
	    session.setAttribute("idx",idx);
    %>
	<div class="header">
		<h2>图书管理系统</h2>
		<h3>用户界面</h3>
	</div>
	<div class="main">
		<div class="daohang">			
				<li><a href="http://localhost:8080/BookManagement/Book/Select/user_select_input.jsp?" target="menuFrame">书名查找</a></li>
				<li><a href="http://localhost:8080/BookManagement/Book/Select/user_select_output.jsp" target="menuFrame">浏览图书</a></li>
				<li><a href="http://localhost:8080/BookManagement/Book/Select/user_select_all.jsp" target="menuFrame">浏览记录</a></li>
				<li><a href="http://localhost:8080/BookManagement/Book/Import/export.jsp" target="menuFrame">导出记录</a></li>
				<li><a href="http://localhost:8080/BookManagement/Book/Login/user_login.jsp">退出登录</a></li>
		</div>
		<div class="content">
			<iframe id="menuFrame" name="menuFrame" 
				style="background-color: #EEEEEE; width: 84%; height: 1000px; float: right; frameborder: 0">
			</iframe>
		</div>
	</div>
</body>
</html>