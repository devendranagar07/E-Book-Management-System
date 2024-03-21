package com.user.servlet;

import jakarta.servlet.http.*;

public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("obj");
			HttpSession session1 = request.getSession();
			session1.setAttribute("successmsg", "Logout Successfully");
			response.sendRedirect("login.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
