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
<title>查询用户显示页面</title>
<style type="text/css">
a:link,a:visited{
    text-decoration: none;
    color:#0000CD;
    display:block;
    text-align:center;
    background-color:#D4F2E7;
}
a:active,a:hover{
    background-color:#00CED1;
}
</style>
</head>
<body>
	<table border="0" bgcolor="#ccceee" width="100%">
		<tr bgcolor="CCCCC" align="center">
			<th>学号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>专业</th>
			<th>已借量</th>
			<th>账号</th>
			<th>密码</th>
			<th>操作</th>
			<th></th>
		</tr>
		<%
			String account= request.getParameter("account");
			UserDao ncd = new UserDao();
			List<User> list = new ArrayList<User>();
			try{
				list =ncd.findUser1(account);
			}catch(Exception e){
				e.printStackTrace();
			}

			for (User nc : list) {
		%>
		<tr>
		<td style="text-align: center;"><%=nc.getSid() %></td>
		<td style="text-align: center;"><%=nc.getName() %></td>
		<td style="text-align: center;"><%=nc.getSex() %></td>
		<td style="text-align: center;"><%=nc.getMajor() %></td>
		<td style="text-align: center;"><%=nc.getLend() %></td>
		<td style="text-align: center;"><%=nc.getAccount() %></td>
		<td style="text-align: center;"><%=nc.getPassword() %></td>
		<td><a href="http://118.202.41.251:8080/BookManagement/AdminUserDelete?bookdelete=null&from=out&operation=delete&account=<%=nc.getAccount()%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>