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
<title>普通用户借书页面</title>
</head>
<body>
      
      <%
      request.setCharacterEncoding("UTF-8");
      String bid=(String)request.getParameter("id");//书号
      String idx=(String)session.getAttribute("idx");
      BookDao ncd = new BookDao();
      if(ncd.borrow_query01(bid, idx).equals("借书")||ncd.borrow_query01(bid, idx).equals("续借"))
      {
    	%>
      	<script type="text/javascript">
  		  alert("已借此书，请归还后再借");
  		  window.history.back(-1);
  		</script>
  	    <%
      }
      else if(ncd.borrow_query01(bid, idx).equals("预约"))
      {
    	  Book book01=ncd.query_book(bid);
		  ncd.borrow_book01(idx,book01,"借书");
		  ncd.book_num_subtract(book01, bid);
		  ncd.borrow_plus_one(idx);
		  %>
	      	<script type="text/javascript">
	  		  alert("通过预约借书一本！");
	  		  window.history.back(-1);
	  		  location.reload();
	  		</script>
	  	  <%
      }

      else
      {
    	  if(ncd.judge_book_num(bid))
          {
        	  %>
            	<script type="text/javascript">
        		  alert("该图书量为0，不可借阅！");
        		  window.history.back(-1);
        		</script>
        	  <%
          }
          else
          {
        	  if(ncd.judge_borrow_num(idx))
              {
            	  if(ncd.borrow_plus_one(idx)!=0)
            	  {
            		  Book book01=ncd.query_book(bid);
            		  ncd.borrow_book01(idx,book01,"借书");
            		  ncd.book_num_subtract(book01, bid);
            		  %>
            	      	<script type="text/javascript">
            	  		  alert("成功借书一本！");
            	  		  window.history.back(-1);
            	  		  location.reload();
            	  		</script>
            	  	  <%
            	  }
              }
              else
              {
            	%>
              	<script type="text/javascript">
          		  alert("已借图书大于8本！");
          		  window.history.back(-1);
          		</script>
          		<%
              }
          }
      }
      %>

</body>
</html>