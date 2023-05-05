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
<title>查看自己全部记录</title>
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
    <% 
    BookDao ncd = new BookDao();
    String account=(String)session.getAttribute("account");
    String idx=ncd.find_ID(account);
    %>
    <center>
	您已借<font size="5" color="red"><%=ncd.lend_num(idx) %></font>本书
	</center>
	<table border="0" bgcolor="#ccceee" width="100%">
		<tr bgcolor="CCCCC" align="center">
			<th>序号</th>
			<th>书号</th>
			<th>书名</th>
			<th>状态</th>
			<th>时间</th>
			<th></th>
		</tr>
		<%
			List<borrow> list = new ArrayList<borrow>();
			try{
				list = ncd.find_ALLRecord(idx);
			}catch(Exception e){
				e.printStackTrace();
			}
			for (borrow nc : list) {
		%>
		<tr>
		<td style="text-align: center;"><%=nc.getId() %></td>
		<td style="text-align: center;"><%=nc.getBookid() %></td>
		<td style="text-align: center;"><%=nc.getBookname() %></td>
		<td style="text-align: center;"><%=nc.getBookstate() %></td>
		<td style="text-align: center;"><%=nc.getTime() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>