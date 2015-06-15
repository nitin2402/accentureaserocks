package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.LoginController;
import com.accenture.tmt.presentation.dto.LoginDTO;


/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int check = 0;
		String username = request.getParameter(CONSTANTS.USER_NAME);
		String password = request.getParameter(CONSTANTS.PASS_WORD);
		LoginDTO loginCred = new LoginDTO();
		
		loginCred.setUsername(username);
		loginCred.setPassword(password);
		LoginController ctrl = new LoginController();
		LoginDTO loggedInDto = ctrl.checkLogin(loginCred);
		
		if(check == 1){
			response.sendRedirect("adminhome.jsp");
		}
		if(check == 2){
			response.sendRedirect("userhome.jsp");
		}
		if(check == 0){
			response.sendRedirect("login.jsp?msg=Please Register First to access this Application");
		}
		
		/*
		LoginManager login = new LoginManager();
		check = login.CheckLogin(userName, password);*/

		/*if (check==1) {
			HttpSession session1 = request.getSession(true);
			session1.setAttribute("user", userName);
			session1.setAttribute("admin", true);
			response.sendRedirect("adminhome.jsp");
			
		} else if(check==2){
			HttpSession session1 = request.getSession(true);
			session1.setAttribute("user", userName);
			session1.setAttribute("admin", false);
			response.sendRedirect("userhome.jsp");
			
		}
		else if(check==0)
		{
			response.sendRedirect("home.jsp?msg=Enter valid Username and Password");
		}*/
	}

}
