package com.user.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

import com.dao.*;
import com.db.*;

public class RemoveCartBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int cid = Integer.parseInt(request.getParameter("cid"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		CartDAOImplement cartdao = new CartDAOImplement(ConnectionProvider.getConnection());
		HttpSession session = request.getSession();
		if(cartdao.removeCartBook(cid, bid, uid)) {
			session.setAttribute("successmsg", "Book removed from cart");
			response.sendRedirect("cart.jsp");
		}else {
			session.setAttribute("failedmsg", "Something went wrong!");
			response.sendRedirect("cart.jsp");
		}
		
	}	
}
