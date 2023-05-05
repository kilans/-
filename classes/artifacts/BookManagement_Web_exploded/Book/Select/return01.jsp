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
<title>普通用户还书页面</title>
</head>
<body>
      <%
      request.setCharacterEncoding("UTF-8");
      String bid=(String)request.getParameter("id");//书号
      String idx=(String)session.getAttribute("idx");
      BookDao ncd = new BookDao();
	  if(ncd.borrow_query01(bid, idx).equals("续借")||ncd.borrow_query01(bid, idx).equals("借书"))
      {
    	  String time1=ncd.time_query(bid, idx, "借书");
    	  String time2=ncd.time_query(bid, idx, "续借");
    	  String timex=ncd.time_get();
  		  String time3=ncd.time_judge02(time1, time2);
    	  int x=ncd.time_judge(timex, time3);
    	  if(x>30)//距今天超过借书30天罚款
    	  {
    		    x-=30;
    		    out.print("您已逾期，请先交罚款"+x+"元！");
    		    session.setAttribute("bidx", bid);
    		    session.setAttribute("idxx", idx);
    		    %>
    		    <br><br>
    		    <button onclick="huankuan()">还款</button>&nbsp;&nbsp;
    		    <button onclick="quxiao()">取消</button>
    	      	<script type="text/javascript">
    	      	  function huankuan()
    	      	  {
    	      		var flag = confirm("确定还书吗?");
    	      		if(flag==true)
   	      			{
    	      			location.href ="return02.jsp";
   	      			}
    	      	  }
    	      	  
	    	      function quxiao()
	  	      	  {
	    	    	  alert("未交罚款，还书失败！");
	    	    	  window.history.back(-1);
	  	      	  }
    	  		</script>
    	  	    <%
    	  } 
    	  else
    	  {
    		  Book book01=ncd.query_book(bid);
        	  ncd.borrow_num_subtract01(idx);
        	  ncd.book_num_plus01(book01, bid);
    		  ncd.borrow_book01(idx,book01,"还书");
        	  %>
            	<script type="text/javascript">
        		  alert("还书成功！");
        		  window.history.back(-1);
        		</script>
        	  <%
    	  }
    	  
      }
      else if(ncd.borrow_query01(bid, idx).equals("预约"))
	  {
		    %>
        	<script type="text/javascript">
    		  alert("正在预约，不可还书");
    		  window.history.back(-1);
    		</script>
    	    <%
	  }
      else
      {
       %>
      	<script type="text/javascript">
  		  alert("未借此书，不可还书！");
  		  window.history.back(-1);
  		</script>
  	   <%
      }
      
      %>
</body>
</html>