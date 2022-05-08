package com.managementsystem.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.managementsystem.dao.LoginDao;
import com.managementsystem.model.Login;

//@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.sendRedirect("login.jsp");
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		authenticate(request,response);
	}
	
	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Login login = new Login();
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));

		try {
			if (LoginDao.validate(login)) { 
		          System.out.println("SARAAAAAAAAAAA");

		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentEmployee",LoginDao.getEmployee()); 
		          session.setAttribute("employeeRule", LoginDao.getEmployee().getEmployeeRule());
		          System.out.println("ccccccccccccccccc");
//		          response.sendRedirect("task/list.jsp");
		          RequestDispatcher dispatcher = request.getRequestDispatcher("Task?action=list");
				  dispatcher.forward(request, response);
//		          RequestDispatcher dispatcher = request.getRequestDispatcher("Task");
//		  		  dispatcher.forward(request, response);
			} else {
				  response.sendRedirect("login.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
