package com.user.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import com.dao.*;
import com.db.*;

public class RemoveOldBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int bid = Integer.parseInt(request.getParameter("bid"));
		String category = request.getParameter("category");
		String email = request.getParameter("email");
		BookDAOImplement bookdao = new BookDAOImplement(ConnectionProvider.getConnection());
		HttpSession session = request.getSession();
		if(bookdao.deleteOldBook(bid,category,email)) {
			session.setAttribute("successmsg", "Old Book removed Successfully");
			response.sendRedirect("RemoveBook.jsp");
		}else {
			session.setAttribute("failedmsg", "Something went wrong!");
			response.sendRedirect("RemoveBook.jsp");
		}
		
	}	
}
