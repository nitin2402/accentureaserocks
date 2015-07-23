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
		
		String employeeId = request.getParameter("EmployeeId");
		String employeeName = request.getParameter("EmployeeName");
		String designation = request.getParameter("EmployeeDesignation");
		String level = request.getParameter("EmployeeLevel"); 
		String employeeExpertise = request.getParameter("EmployeeExpertise");
		String employeeClientId = request.getParameter("EmployeeClientId");
		String employeeEmail = request.getParameter("EmployeeEmail");
		String proficiencyCams = request.getParameter("ProficiencyCams");
		String proficiencyProject = request.getParameter("ProficiencyProject");
		String teamName = request.getParameter("TeamName");
		String dateofJoining = request.getParameter("DateofJoining");
		String billable = request.getParameter("Billable");
		
		
		EmployeeDetailsFlatDTO detailsDO = new EmployeeDetailsFlatDTO();
		
		detailsDO.setEmpId(employeeId);
		detailsDO.setEmpName(employeeName);
		detailsDO.setDesignation(designation);
		detailsDO.setLevel(level);
		detailsDO.setExpertise(employeeExpertise);
		detailsDO.setClientId(employeeClientId);
		detailsDO.setEmail(employeeEmail);
		detailsDO.setProfCamps(proficiencyCams);
		detailsDO.setProfProject(proficiencyProject);
		detailsDO.setTeamName(teamName);
		detailsDO.setDoj(dateofJoining);
		detailsDO.setIsBillable(billable);
		
		
		EmployeeController employeeManager = new EmployeeController();
		
		int b=employeeManager.EditEmployee(detailsDO);
		if(b!=0)
		{
		request.setAttribute("message", "Record updated");
		
		request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
		}
		else
		{
		request.setAttribute("message", "Update Failed");
		
		request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
		}
	}

}
