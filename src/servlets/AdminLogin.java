package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Admin;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String loginjudge=request.getParameter("loginjudge");
		if("wrong".equals(loginjudge)) {
			request.getRequestDispatcher("Book/Login/admin_login.jsp").forward(request, response);
		}else if("right".equals(loginjudge)) {
			request.getRequestDispatcher("Book/Menu/admin_menu.jsp").forward(request, response);
		}

		String account = request.getParameter("account");
		String pwd = request.getParameter("password");
		Admin mm=new Admin(account,pwd);
		try {
			if(mm.judge(mm.getAccount(),mm.getPassword())){
				out.print("<script>alert('管理员登录成功');window.location='AdminLogin?loginjudge=right';</script>");
			}else{
				out.print("<script>alert('管理员登录失败');window.location='AdminLogin?loginjudge=wrong';</script>");
			}
		} catch (ClassNotFoundException e) {
			out.print("<script>alert('管理员登录失败');window.location='AdminLogin?loginjudge=wrong';</script>");
			e.printStackTrace();
		} catch (SQLException e) {
			out.print("<script>alert('管理员登录失败');window.location='AdminLogin?loginjudge=wrong';</script>");
			e.printStackTrace();
		} catch (Exception e) {
			out.print("<script>alert('管理员登录失败');window.location='ManagerLogin?loginjudge=wrong';</script>");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
