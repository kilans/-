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

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		String loginjudge=request.getParameter("loginjudge");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		request.setAttribute("account", account);
		UserDao dao=new UserDao();
		if("wrong".equals(loginjudge)) {
			request.getRequestDispatcher("Book/Login/user_register.jsp").forward(request, response);
		}else if("right".equals(loginjudge)) {
			request.getRequestDispatcher("Book/Login/user_login.jsp").forward(request, response);
		}else {
				if(!"".equals(account))
				{
					String sid=request.getParameter("sid");
					String name=request.getParameter("name");
					String sex=request.getParameter("sex");
					String major=request.getParameter("major");
					User user=new User(sid,name,sex,major,0,account,password);
					try {
						dao.insert(user);
						out.print("<script>alert('用户注册成功！');window.location='UserRegister?loginjudge=right';</script>");
					} catch (Exception e) {
						out.print("<script>alert('用户注册失败！');window.location='UserRegister?loginjudge=wrong';</script>");
						e.printStackTrace();
					}
				}else {
					out.print("<script>alert('用户注册失败！');window.location='UserRegister?loginjudge=wrong';</script>");
				    }
			} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
