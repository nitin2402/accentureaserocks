package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;



/**
 * Servlet implementation class AddEmployeeManual
 */
public class AddEmployeeManual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeManual() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String empName = request.getParameter("name");
		String empId = request.getParameter("idno");
		String expertise = request.getParameter("area");
		String designation = request.getParameter("desig");
		String level = request.getParameter("level"); 
		String clientId = request.getParameter("client");
		String email = request.getParameter("email");
		String team = request.getParameter("Team");
		String camps = request.getParameter("camps");
		String proj = request.getParameter("Project");
		String doj = request.getParameter("doj");
		String lwd = request.getParameter("last");
		String bill = request.getParameter("bill");
		String active = request.getParameter("active");
		
		

		
		EmployeeDetailsDTO detailsDO = new EmployeeDetailsDTO();
		detailsDO.setEmpId(empId);
		detailsDO.setEmpName(empName);
		detailsDO.setLevel(level);
		detailsDO.setDesignation(designation);
		detailsDO.setExpertise(expertise);
		detailsDO.setClientId(clientId);
		detailsDO.setEmail(email);
		detailsDO.setTeamId(team);
		detailsDO.setProfCamps(camps);
		detailsDO.setProfProject(proj);
		detailsDO.setDoj(doj);
		detailsDO.setLastWD(lwd);
		detailsDO.setIsBillable(bill);
		detailsDO.setIsActive(active);
		EmployeeController employeeManager = new EmployeeController();
		
		int c=employeeManager.addEmployee(detailsDO);
		if(c !=0){
			request.setAttribute("message","Record Inserted");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		if(c ==0){
			request.setAttribute("message","Record insertion failed");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
	}

}
