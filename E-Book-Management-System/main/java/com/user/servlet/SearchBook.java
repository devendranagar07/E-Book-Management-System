package com.user.servlet;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SearchBook extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try{
			String ch = request.getParameter("ch");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
