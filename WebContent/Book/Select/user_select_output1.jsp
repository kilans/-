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
<title>按书名查找</title>
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
			<th>书号</th>
			<th>书名</th>
			<th>作者</th>
			<th>价格</th>
			<th>备注字段</th>
			<th>图书数量</th>
			<th>借书</th>
			<th>还书</th>
			<th>续借</th>
			<th>预约</th>
			<th></th>
		</tr>
		<%
			BookDao ncd = new BookDao();
		    String bookname=request.getParameter("bookname");
			List<Book> list = new ArrayList<Book>();
			try{
				list = ncd.findBook1(bookname);
			}catch(Exception e){
				e.printStackTrace();
			}
			for (Book nc : list) {
		%>
		<tr>
		<td style="text-align: center;"><%=nc.getId() %></td>
		<td style="text-align: center;"><%=nc.getBookname() %></td>
		<td style="text-align: center;"><%=nc.getAuthor()%></td>
		<td style="text-align: center;"><%=nc.getPrice() %></td>
		<td style="text-align: center;"><%=nc.getRemark() %></td>
		<td style="text-align: center;"><%=nc.getNumber() %></td>
		<td><a href="borrow01.jsp?id=<%=nc.getId() %>">借书</a></td>	
		<td><a href="return01.jsp?id=<%=nc.getId() %>">还书</a></td>	
		<td><a href="renew01.jsp?id=<%=nc.getId() %>">续借</a></td>	
		<td><a href="reserve01.jsp?id=<%=nc.getId() %>">预约</a></td>	
<%-- 		<td><a href="/card/UserCardModify?carddelete=null&from=out&operation=change&account=<%=account %>&index=<%=index %>&id=<%=nc.getId()%>">修改</a></td> --%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>