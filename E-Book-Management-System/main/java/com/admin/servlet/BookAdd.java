package com.admin.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import com.dao.*;
import com.db.*;
import com.entities.*;

@MultipartConfig
public class BookAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		try {
			String bookname = request.getParameter("bname");
			String authorname = request.getParameter("baname");
			Double bprice = Double.parseDouble(request.getParameter("bprice"));
			String bcategory = request.getParameter("category");
			String bstatus = request.getParameter("bstatus");
			Part part  = request.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			
			HttpSession session = request.getSession();
			BookDetails bd = new BookDetails(bookname,authorname,bprice,bcategory,bstatus,fileName,"admin@gmail.com");
			BookDAOImplement bookdao = new BookDAOImplement(ConnectionProvider.getConnection());
			if(bookdao.addBook(bd)) {
				String path = getServletContext().getRealPath("") + "books";
				System.out.println(path);
				File file = new File(path);
				part.write(file + File.separator + fileName);
				session.setAttribute("successmsg", "Book added successfully");
				response.sendRedirect("admin/add_books.jsp");
			}else {
				session.setAttribute("failedmsg", "Something went wrong!");
				response.sendRedirect("admin/add_books.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
