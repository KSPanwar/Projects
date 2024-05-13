package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.*;
@WebServlet("/Login")
public class Login extends HttpServlet {
	JSPDao userValidation = new JSPDao();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		
		if(userValidation.isVerified(username, userpassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}



}
