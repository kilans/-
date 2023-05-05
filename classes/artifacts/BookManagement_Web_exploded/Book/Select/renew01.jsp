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
<title>普通用户续借页面</title>
</head>
<body>
     <%
     request.setCharacterEncoding("UTF-8");
     String bid=(String)request.getParameter("id");//书号
     String idx=(String)session.getAttribute("idx");
     BookDao ncd = new BookDao();
     if(ncd.borrow_query01(bid, idx).equals("借书"))
     {
    	 Book book01=ncd.query_book(bid);
    	 ncd.borrow_book01(idx, book01, "续借");
    	 %>
      	<script type="text/javascript">
  		  alert("续借成功！");
  		  window.history.back(-1);
  		</script>
  	    <%
     }
     else if(ncd.borrow_query01(bid, idx).equals("预约"))
     {
    	 %>
      	<script type="text/javascript">
  		  alert("正在预约，不可续借！");
  		  window.history.back(-1);
  		</script>
  	   <%
     }
     else if(ncd.borrow_query01(bid, idx).equals("null"))
     {
   	  %>
       	<script type="text/javascript">
   		  alert("没有记录，不可续借！");
   		  window.history.back(-1);
   		</script>
   	   <%
     }
     else if(ncd.borrow_query01(bid, idx).equals("还书"))
     {
      %>
     	<script type="text/javascript">
 		  alert("未借此书，不可续借！");
 		  window.history.back(-1);
 		</script>
 	  <%
     }
     else if(ncd.borrow_query01(bid, idx).equals("续借"))
     {
      %>
     	<script type="text/javascript">
 		  alert("续借失败，仅可续借一次！");
 		  window.history.back(-1);
 		</script>
 	  <%
     }
     %>
</body>
</html>