package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.SignupController;
import com.accenture.tmt.presentation.dto.RegistrationDTO;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter(CONSTANTS.NEW_USER);
		String password = request.getParameter(CONSTANTS.NEW_USER_PASS_WORD);
		String employeeid =request.getParameter(CONSTANTS.NEW_EMPLOYEE_ID);
		
	RegistrationDTO registerCred = new RegistrationDTO();
	registerCred.setUsername(userName);
	registerCred.setPassword(password);
	registerCred.setEmployeeid(employeeid);
	SignupController registerCtrl = new SignupController();
	 int returnuserregistered = registerCtrl.UserRegistration(registerCred);
	 if(returnuserregistered==0)
		{
			response.sendRedirect("login.jsp?msg=User added ! Login to continue");
		}
	 else if(returnuserregistered==1)
		{
			response.sendRedirect("login.jsp?msg=Registration failed...User is already signed up..Please Login");
		}
	 else if(returnuserregistered==2)
	 {
		 response.sendRedirect("login.jsp?msg=Registration failed...already existing username"); 
	 }
	 else if(returnuserregistered==3)
	 {
		 response.sendRedirect("login.jsp?msg=Registration failed...Employeeid does not exist"); 
	 }
	 
	 else
	 {
		 response.sendRedirect("login.jsp?msg=Registration failed..."); 
	 }
	}

}
