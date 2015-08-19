package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		

		String username = request.getParameter(CONSTANTS.USER_NAME);
		String password = request.getParameter(CONSTANTS.PASS_WORD);
	
		LoginDTO loginCred = new LoginDTO();
		
		loginCred.setUsername(username);
		loginCred.setPassword(password);
		LoginController ctrl = new LoginController();
		LoginDTO loggedInDto = ctrl.checkLogin(loginCred);
		
		String userType = loggedInDto.getUserType();
		

		if (password.equals(loggedInDto.getPassword())){
		
		if( CONSTANTS.ADMIN .equals(userType)){
			HttpSession session1 = request.getSession();
			
			session1.setAttribute("user",username);
			session1.setAttribute("userType",userType);
			session1.setAttribute("admin", "admin");
			response.sendRedirect("adminhome.jsp?name="+username);
			
		}
		if(CONSTANTS.USER .equals(userType)){
			
			HttpSession session1 = request.getSession();
			
			session1.setAttribute("user", username);
			session1.setAttribute("userType", userType);
			session1.setAttribute("admin", "user");
			response.sendRedirect("userhome.jsp?name="+username);
			
			
		}
		if(CONSTANTS.VIEWER .equals(userType)){
			HttpSession session1 = request.getSession();
			
			session1.setAttribute("user", username);
			session1.setAttribute("userType", userType);
			session1.setAttribute("admin", "viewer");
			 response.sendRedirect("viewerhome.jsp?name="+username);
		}
		
		}
		else if(CONSTANTS.NOT_A_USER .equals(userType) ){
			response.sendRedirect("login.jsp?msg=Please Register First to access this Application");
		}
		
		else{
			response.sendRedirect("login.jsp?msg=Password is incorrect");
		}
		
		}
		
		
		
	}


