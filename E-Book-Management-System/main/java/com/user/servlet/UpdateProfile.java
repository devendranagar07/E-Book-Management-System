package com.user.servlet;

import java.io.*;

import com.dao.*;
import com.db.*;
import com.entities.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		User user = new User(id, name, email, password, phone_number);
		UserDAOImplement userDaoImplement = new UserDAOImplement(ConnectionProvider.getConnection());
		if (userDaoImplement.userUpdate(user)) {
			session.setAttribute("successmsg", "Updated successfully");
			response.sendRedirect("loginAndSecurity.jsp");
		} else {
			session.setAttribute("failedmsg", "Something went wrong!");
			response.sendRedirect("loginAndSecurity.jsp");
		}
	}
}
