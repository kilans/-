package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("textml;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String loginjudge=request.getParameter("loginjudge");
		String account1 = request.getParameter("account");
		request.setAttribute("account", account1);
		
		if("wrong".equals(loginjudge)) {
			request.getRequestDispatcher("/Book/Login/user_login.jsp").forward(request, response);
		}else if("right".equals(loginjudge)) {
			request.getRequestDispatcher("/Book/Menu/user_menu.jsp").forward(request, response);
		}

		String pwd = request.getParameter("password");
		User user=new User();

		try {
			if(user.judge(account1,pwd)){
				String namekkk=user.getName();
				request.setAttribute("namekkk", namekkk);
				out.print("<script>alert('用户登录成功');window.location='UserLogin?loginjudge=right&account="+account1+"';</script>");
			}else{
				out.print("<script>alert('用户登录失败');window.location='UserLogin?loginjudge=wrong';</script>");
			}
		} catch (ClassNotFoundException e) {
			out.print("<script>alert('用户登录失败');window.location='UserLogin?loginjudge=wrong';</script>");
			e.printStackTrace();
		} catch (SQLException e) {
			out.print("<script>alert('用户登录失败');window.location='UserLogin?loginjudge=wrong';</script>");
			e.printStackTrace();
		} catch (Exception e) {
			out.print("<script>alert('用户登录失败');window.location='UserLogin?loginjudge=wrong';</script>");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}