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
<title>名片信息编辑页面</title>
</head>
<body>
    <%
        String id=request.getParameter("id");
        
        String from=request.getParameter("from");
        
        Book nc=new Book();
        BookDao ncd=new BookDao();
        nc=ncd.findBook4(id);
    %>
	<center>
		<form action="http://118.202.41.251:8080/BookManagement/AdminBookEdit" method="post">
		<table>
		    <tr><td><input name="cardedit" value="null" type="hidden"></td></tr>
		    <tr><td><input name="from" value="<%=from %>" type="hidden"></td><td></td></tr> 
			<tr>
				<td>书号</td><td><input name="id" type="text" value="<%=nc.getId() %>" size="40"></td>
			</tr>
			<tr>
				<td>书名</td><td><input name="bookname" type="text" value="<%=nc.getBookname() %>" size="40"></td>
			</tr>
			<tr>
				<td>作者</td><td><input name="author" type="text" value="<%=nc.getAuthor() %>" size="40"></td>
			</tr>
			<tr>
				<td>价格</td><td><input name="price" type="text" value="<%=nc.getPrice()%>" size="40"></td>
			</tr>
			<tr>
				<td>备注</td><td><input name="remark" type="text" value="<%=nc.getRemark() %>" size="40"></td>
			</tr>
			<tr>
				<td>库存量</td><td><input name="number" type="text" value="<%=nc.getNumber() %>" size="40"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="修改">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="取消">
				</td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>