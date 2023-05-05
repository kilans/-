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
<title>普通用户还书页面2</title>
</head>
<body>
     <%
        BookDao ncd = new BookDao();
        String bid=(String)session.getAttribute("bidx");
        String idx=(String)session.getAttribute("idxx");
		Book book01=ncd.query_book(bid);
	    ncd.borrow_num_subtract01(idx);
	    ncd.book_num_plus01(book01, bid);
	    ncd.borrow_book01(idx,book01,"还书");
	    %>
	    <script type="text/javascript">
	      alert("交完罚款，还书成功！");
	      window.history.back(-1);
	      window.history.back(-1);
	    </script>
	    <%
	 %>
</body>
</html>