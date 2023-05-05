package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;

@WebServlet("/AdminUserAdd")
public class AdminUserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminUserAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("textml;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String nameuserAdd=request.getParameter("nameuserAdd");
		if("add".equals(nameuserAdd)) {
			request.getRequestDispatcher("Book/Add/admin_user_add.jsp").forward(request, response);
		}else {
			UserDao ncd=new UserDao();
            String sid=request.getParameter("sid");
			String name=request.getParameter("name");
		    String sex=request.getParameter("sex");
			String major=request.getParameter("major");
			String lend=request.getParameter("lend");
		    String account=request.getParameter("account");
		    String password=request.getParameter("password");
		    int lend1=Integer.parseInt(lend);
			
			User nc=new User(sid,name,sex,major,lend1,account,password);
						
			try {
					  ncd.insert1(nc);
					  out.print("<script>alert('学生添加成功！');window.location='AdminUserAdd?nameuserAdd=add';</script>");
				 } catch (Exception e) {
				      out.print("<script>alert('学生添加失败！');window.location='AdminUserAdd?nameuserAdd=add';</script>");
					  e.printStackTrace();
				 }			
			 }
		}
			    
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
