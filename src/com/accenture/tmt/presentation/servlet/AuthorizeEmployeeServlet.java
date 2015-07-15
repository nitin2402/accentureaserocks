package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.AuthorizeEmployeeController;
import com.accenture.tmt.presentation.dto.LoginDTO;


/**
 * Servlet implementation class AuthorizeEmployeeServlet
 */
public class AuthorizeEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizeEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AuthorizeEmployeeController authorizecontroller = new AuthorizeEmployeeController();
		List<LoginDTO> unauthorized_employees = new ArrayList<LoginDTO>();
		unauthorized_employees = authorizecontroller.authorizeemployee();
		request.setAttribute("unauthorized_employees", unauthorized_employees);
		
		
	}

}
