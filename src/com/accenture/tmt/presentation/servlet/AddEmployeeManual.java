package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.manager.ReportController;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;
import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;


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
		
		String cost = request.getParameter("cost");

		java.sql.Date sqlDate=null;
		
		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		
		EmployeeDetailsDTO detailsDO = new EmployeeDetailsDTO();
		detailsDO.setEmpId(empId);
		detailsDO.setEmpName(empName);
		detailsDO.setLevel(level);
		detailsDO.setDesignation(designation);
		detailsDO.setExpertise(expertise);
		detailsDO.setClientId(clientId);
		detailsDO.setEmail(email);
		detailsDO.setTeamName(team);
		detailsDO.setProfCamps(camps);
		detailsDO.setProfProject(proj);
		detailsDO.setDoj(doj);
		detailsDO.setLastWD(lwd);
		detailsDO.setIsBillable(bill);
		detailsDO.setIsActive(active);
		detailsDO.setCost(cost);
	EmployeeReportUpdateDTO reportupdatedto=new EmployeeReportUpdateDTO();
	ReportController update=new ReportController();
		EmployeeController employeeManager = new EmployeeController();
		
		int c=employeeManager.addEmployee(detailsDO);
		if(c !=0){
			request.setAttribute("message","Record Inserted");
			if(session1!= null){
				
				reportupdatedto.setEmpId(empId);
				reportupdatedto.setEmpName(empName);
				reportupdatedto.setLevel(level);
				reportupdatedto.setDesignation(designation);
				reportupdatedto.setExpertise(expertise);
				reportupdatedto.setClientId(clientId);
				reportupdatedto.setEmail(email);
				reportupdatedto.setTeamId(team);
				reportupdatedto.setProfCamps(camps);
				reportupdatedto.setProfProject(proj);
				reportupdatedto.setDoj(doj);
				reportupdatedto.setLastWD(lwd);
				reportupdatedto.setIsBillable(bill);
				reportupdatedto.setIsActive(active);
				reportupdatedto.setCost(cost);
				reportupdatedto.setUserName((String)session1.getAttribute("user"));
				reportupdatedto.setAction("added");
				reportupdatedto.setTimeStamp(timestamp);;
				reportupdatedto.setDate(sqlDate);
				update.updateEmpreport(reportupdatedto);
				}
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		if(c ==0){
			request.setAttribute("message","Record insertion failed");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
	}

}
