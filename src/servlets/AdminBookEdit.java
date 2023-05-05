package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Book;
import dao.BookDao;

@WebServlet("/AdminBookEdit")
public class AdminBookEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminBookEdit() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out =response.getWriter();
		
		String bookname=request.getParameter("bookname");
		request.setAttribute("bookname", bookname);
		String id=request.getParameter("id");
		request.setAttribute("id", id);
		String bookedit=request.getParameter("bookedit");
		String from=request.getParameter("from");
		request.setAttribute("bookedit",bookedit);
		request.setAttribute("from",from);
		
		
		if("edit".equals(bookedit)) {
			if("out".equals(from)) {
				request.getRequestDispatcher("Book/Select/admin_selectBook_output.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Book/Select/admin_selectBook_all.jsp").forward(request, response);
			}
		}else if("fail".equals(bookedit)) {
			request.getRequestDispatcher("Book/Select/admin_selectBook_edit.jsp").forward(request, response);
		}else {

		    String author=request.getParameter("author");
            String price=request.getParameter("price");
		    String remark=request.getParameter("remark");
		    String number=request.getParameter("number");
            int number1=Integer.parseInt(number);
            double price1=Double.parseDouble(price);
		    Book nc=new Book(id,bookname,author,price1,remark,number1);
			BookDao ncd=new BookDao();
			try {
				ncd.update(nc);
				out.print("<script>alert('图书更改成功！');window.location='AdminBookEdit?bookedit=edit&from="+from+"&id="+id+"&bookname="+bookname+"';</script>");
			} catch (Exception e) {
				out.print("<script>alert('图书更改失败！');window.location='AdminBookEdit?bookedit=fail&from="+from+"&id="+id+"&bookname="+bookname+"';</script>");
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
