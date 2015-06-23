package com.accenture.tmt.presentation.servlet;
import com.accenture.tmt.dao.dto.EmployeeDetailsDTO;
import com.accenture.tmt.manager.EmployeeController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Hi im AddEmployee servlet of doGet");
		doPost(request,response);
/*		EmployeeManager employeeManager = new EmployeeManager();
		EmployeeDetailsDO detailsDO = new EmployeeDetailsDO();
		List<EmployeeDetailsDO> empDetails = employeeManager.fetchEmployeeDetails(detailsDO);
		response.sendRedirect("View.jsp?msg=Record Fetched!");
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String empId = request.getParameter("idno");

		String empName = request.getParameter("name");
		String expertise = request.getParameter("area");
		String designation = request.getParameter("desig");
		String level = request.getParameter("level"); 
		/*String experience = request.getParameter("exp");*/
		String attId = request.getParameter("att");
		String email = request.getParameter("email");
		
		EmployeeDetailsDTO detailsDO = new EmployeeDetailsDTO();
		
		detailsDO.setEmpId(empId);
		detailsDO.setEmpName(empName);
		detailsDO.setLevel(level);
		detailsDO.setDesignation(designation);
		detailsDO.setExpertise(expertise);
	/*	detailsDO.setExperience(experience);*/
		detailsDO.setAtt(attId);
		detailsDO.setEmail(email);
		EmployeeController employeeManager = new EmployeeController();
		
		int b=employeeManager.addEmployee(detailsDO);
		if(b !=0){
			request.setAttribute("message","Record Inserted");
			request.getRequestDispatcher("addempvia.jsp").forward(request, response);}
		if(b ==0){
			request.setAttribute("message","Record insertion failed");
			request.getRequestDispatcher("addempvia.jsp").forward(request, response);}
	/*if(b != 0)
	{
		System.out.println("Record Inserted");
	}*/
		
		//getServletConfig().getServletContext().getRequestDispatcher(viewName).forward(request,response);
		
	
	}
}
