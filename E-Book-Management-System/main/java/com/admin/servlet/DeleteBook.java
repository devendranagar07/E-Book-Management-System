package com.admin.servlet;

import com.db.*;
import com.dao.*;
import jakarta.servlet.http.*;

public class DeleteBook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			BookDAOImplement bookdao = new BookDAOImplement(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();
			if(bookdao.deleteBook(id)) {
				session.setAttribute("successmsg", "Book Deleted Successfully");
				response.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedmsg", "Something went wrong!");
				response.sendRedirect("admin/all_books.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
