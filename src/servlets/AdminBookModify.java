package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

@WebServlet("/AdminBookModify")
public class AdminBookModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminBookModify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String bookdelete=request.getParameter("bookdelete");
		String bookname=request.getParameter("bookname");
		request.setAttribute("bookname", bookname);
		String from=request.getParameter("from");
		request.setAttribute("from", from);

		if("edit".equals(bookdelete)) {
			if("out".equals(from)) {
				request.getRequestDispatcher("Book/Select/admin_selectBook_output.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Book/Select/admin_selectBook_all.jsp").forward(request, response);
			}
		}else{
		
			String operation=request.getParameter("operation");
			String id=request.getParameter("id");
			if("change".equals(operation)) {
				request.getRequestDispatcher("Book/Select/admin_selectBook_edit.jsp").forward(request, response);
			}else {
				BookDao ncd=new BookDao();
				try {
					ncd.delete(id);
					out.print("<script>alert('图书删除成功！');window.location='AdminBookModify?bookdelete=edit&operation="+operation+"&from="+from+"&bookname="+bookname+"';</script>");
				} catch (Exception e) {
					out.print("<script>alert('图书删除失败！');window.location='AdminBookModify?bookdelete=edit&operation="+operation+"&from="+from+"&bookname="+bookname+"';</script>");
					e.printStackTrace();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
