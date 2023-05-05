<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借阅记录信息导出excel</title>
</head>
<body>
<%
    String id=(String)session.getAttribute("idx");
    session.setAttribute("id", id);
    String namex=(String)session.getAttribute("namekkk");
%>
      <form action="export02.jsp" method="post" enctype="multipart/form-data">
         <input type="submit" value="mysql->excel(导出记录 )"/>
      </form>
</body>
</html>