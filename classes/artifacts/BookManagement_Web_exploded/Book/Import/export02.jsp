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
<title>借阅记录信息导出excel</title>
</head>
<body>
     <%
     request.setCharacterEncoding("UTF-8");
     String id=(String)session.getAttribute("id");
     BookDao ncd=new BookDao();
     Excel01 Excel01=new Excel01();
     List<borrow> list=new ArrayList<borrow>();
     list=ncd.find_ALLRecord(id);
	 int x=Excel01.excleOut(id, list);
	 if(x>1) {
     	out.print("记录导出成功！");
     }else {
     	out.print("记录导出失败！");
     }
     %>
</body>
</html>