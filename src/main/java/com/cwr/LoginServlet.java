package com.cwr;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
/**
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 1. Get method sends data through the resource url and those it is not secure
//		 2. Get is slightly faster than post because value are sent in header
//		 3. With the help of Get we can send very less data. (max 2048 character)
//		 4. Get request can be bookmarked.
		 PrintWriter out = resp.getWriter();
		 out.print("Successful Login...");
		 out.print("doGet() method is called...");
	 }
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 it is slower than doget() method and it use for security purpose
//		 1. Post method sends data through http message body and those it more secured
//		 2. Post method is slow
//		 3. we can send huge amount of data
//		 4. Post request can not be bookmarked.
		 PrintWriter out = resp.getWriter();
		 out.print("Successful Login...");
		 out.print("doPost() method is called...");
	}
	 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Execute in both get and post methods declarations in view page
		PrintWriter out = resp.getWriter();
		 out.print("Login page is Running...");
	}
*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pswd = req.getParameter("pswd");
		PrintWriter out= resp.getWriter();
		if (user.equals("Abhishek") && pswd.equals("123456")) {
			RequestDispatcher rd = req.getRequestDispatcher("/Home.jsp");
			rd.forward(req, resp);
		}else {
			resp.setContentType("text/html");
			out.print("<h1>Wrong Username or Password<h1><br><br>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
		}
	}
}
