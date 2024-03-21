package com.user.servlet;

import jakarta.servlet.http.*; 
import java.io.IOException;
import com.db.*;
import com.entities.*;
import com.dao.*;

import jakarta.servlet.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if("admin@gmail.com".equals(email) && "admin".equals(password)) {
			User user = new User();
			user.setName("Admin");
			session.setAttribute("obj", user);
			response.sendRedirect("admin/home.jsp");
		}else {
			UserDAOImplement userdao = new UserDAOImplement(ConnectionProvider.getConnection());
			User user = userdao.login(email, password);
			if(user != null) {
				session.setAttribute("obj", user);
				response.sendRedirect("index.jsp");
			}else {
				session.setAttribute("failedMsg","Invalid email or password!");
				response.sendRedirect("login.jsp");
			}				
		}		
	}
}