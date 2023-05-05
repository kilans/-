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

@WebServlet("/AdminBookAdd")
public class AdminBookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminBookAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String namebookAdd=request.getParameter("namebookAdd");
		if("add".equals(namebookAdd)) {
			request.getRequestDispatcher("Book/Add/admin_book_add.jsp").forward(request, response);
		}else {
			BookDao ncd=new BookDao();
            String id=request.getParameter("id");
			String bookname=request.getParameter("bookname");
		    String author=request.getParameter("author");
			String price=request.getParameter("price");
			String remark=request.getParameter("remark");
			int number=1;
				try {
					if(ncd.findBook3(id))
					{
						number=ncd.findBook4(id).getNumber()+1;
						ncd.delete(id);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			double price2=Double.parseDouble(price);
			Book nc=new Book(id,bookname,author,price2,remark,number);
						
			try {
					  ncd.insert(nc);
					  out.print("<script>alert('图书添加成功！');window.location='AdminBookAdd?namebookAdd=add';</script>");
				 } catch (Exception e) {
				      out.print("<script>alert('图书添加失败！');window.location='AdminBookAdd?namebookAdd=add';</script>");
					  e.printStackTrace();
				 }			
			 }
		}
			    
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
