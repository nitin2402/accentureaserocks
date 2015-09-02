package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.dao.WorkplanDAO;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.manager.ReportController;
import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;



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
		java.sql.Date sqlDate=null;
		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());
		EmployeeController employeeManager = new EmployeeController();
		EmployeeReportUpdateDTO reportupdatedto = new EmployeeReportUpdateDTO();
		ReportController update=new ReportController();
		int b=employeeManager.EditEmployee(detailsDO);
		String teamId = null ;
		WorkplanDAO workplanDao = new WorkplanDAO();
		teamId = workplanDao.fetchTeamId(teamName);
		if(b!=0)
		{
			
                 if(session1!= null){
				
                	 reportupdatedto.setEmpId(employeeId);
     				reportupdatedto.setEmpName(employeeName);
     				reportupdatedto.setLevel(level);
     				reportupdatedto.setDesignation(designation);
     				reportupdatedto.setExpertise(employeeExpertise);
     				reportupdatedto.setClientId(employeeClientId);
     				reportupdatedto.setEmail(employeeEmail);
     				reportupdatedto.setTeamId(teamId);
     				reportupdatedto.setTeamName(teamName);
     				reportupdatedto.setProfCamps(proficiencyCams);
     				reportupdatedto.setProfProject(proficiencyProject);
     				reportupdatedto.setDoj(dateofJoining);
     				//reportupdatedto.setLastWD(lwd);
     				reportupdatedto.setIsBillable(billable);
     				//reportupdatedto.setIsActive(active);
     				//reportupdatedto.setCost(cost);
				reportupdatedto.setUserName((String)session1.getAttribute("user"));
				reportupdatedto.setAction("edited");
				reportupdatedto.setTimeStamp(timestamp);
				reportupdatedto.setDate(sqlDate);
				update.updateEmpreport(reportupdatedto);
				}
		request.setAttribute("message", "Record updated");
		
		request.getRequestDispatcher("admintool.jsp").forward(request, response);
		}
		else
		{
		request.setAttribute("message", "Update Failed");
		
		request.getRequestDispatcher("admintool.jsp").forward(request, response);
		}
	}

}
