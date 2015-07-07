package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.manager.EmployeeController;



/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
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
		String empId = request.getParameter("id");
		
		String empName = request.getParameter("name");
		String expertise = request.getParameter("area");
		String designation = request.getParameter("desig");
		String level = request.getParameter("level"); 
		String attId = request.getParameter("att");
		String email = request.getParameter("email");
		
		
		EmployeeDetailsFlatDTO detailsDO = new EmployeeDetailsFlatDTO();
		
		detailsDO.setEmpId(empId);
		detailsDO.setEmpName(empName);
		detailsDO.setLevel(level);
		detailsDO.setDesignation(designation);
		detailsDO.setExpertise(expertise);
		detailsDO.setClientId(attId);
		detailsDO.setEmail(email);
		
		EmployeeController employeeManager = new EmployeeController();
		
		int b=employeeManager.EditEmployee(detailsDO);
		if(b!=0)
		{
		request.setAttribute("message", "Record updated");
		
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}
		else
		{
		request.setAttribute("message", "Update Failed");
		
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}
	}

}
