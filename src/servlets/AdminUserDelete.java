package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/AdminUserDelete")
public class AdminUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminUserDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String bookdelete=request.getParameter("bookdelete");
		String from=request.getParameter("from");
		request.setAttribute("from", from);
		
		if("delete".equals(bookdelete)) {
			if("out".equals(from)) {
				request.getRequestDispatcher("Book/Select/admin_selectUser_output.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Book/Select/admin_selectUser_all.jsp").forward(request, response);
			}
		}else {
			String operation=request.getParameter("operation");
			if("delete".equals(operation)) {
				String account=request.getParameter("account");
				request.setAttribute("account", account);
				UserDao ud=new UserDao();
				try {
					ud.delete(account);
					out.print("<script>alert('删除用户成功！');window.location='AdminUserDelete?bookdelete=delete&operation="+operation+"&from="+from+"&account="+account+"';</script>");
				} catch (Exception e) {
					out.print("<script>alert('删除用户失败！');window.location='AdminUserDelete?bookdelete=delete&operation="+operation+"&from="+from+"&account="+account+"';</script>");
					e.printStackTrace();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
