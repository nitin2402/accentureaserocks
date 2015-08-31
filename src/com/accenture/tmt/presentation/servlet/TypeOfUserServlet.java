package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.dao.dto.EmployeeReportDetailsFlatDTO;
import com.accenture.tmt.manager.AuthorizeEmployeeController;
import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;
import com.accenture.tmt.presentation.dto.LoginDTO;
import com.accenture.tmt.manager.ReportController;

/**
 * Servlet implementation class TypeOfUserServlet
 */
public class TypeOfUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeOfUserServlet() {
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
		
		String empId = request.getParameter("empid");
		/*String empId = request.getParameter("idno");
		String empName = request.getParameter("name");
		String designation = request.getParameter("desig");
		String expertise = request.getParameter("area");
		String level = request.getParameter("level");
		String clientId = request.getParameter("client");
		String email = request.getParameter("email");
		String teamId = request.getParameter("idno");
		String teamName = request.getParameter("idno");
		String profCamps = request.getParameter("camps");
		String profProj = request.getParameter("Project");
		String doj = request.getParameter("doj");
		String billability = request.getParameter("bill");
		String lastWD = request.getParameter("last");
		String active = request.getParameter("active");
		String cost = request.getParameter("cost");*/
		
		LoginDTO dto = new LoginDTO();
		String select = request.getParameter("select");
		String action = request.getParameter("action");
		dto.setLoginid(select);
		
		java.sql.Date sqlDate=null;
		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String timestamp= df.format(date);
		sqlDate= new java.sql.Date(date.getTime());
		
		ReportController reportUpdate = new ReportController();
		EmployeeReportUpdateDTO reportUpdateDTO = new EmployeeReportUpdateDTO();
		
		if("Viewer".equals(action)){
			int a = 0;
				 a =  authorizecontroller.vieweremployee(dto);
				if(a == 1){
					request.setAttribute("message", "Authorised as viewer");
				
					if(session1!= null){
		
						/*reportUpdateDTO.setEmpName(empName);
						reportUpdateDTO.setDesignation(designation);
						reportUpdateDTO.setExpertise(expertise);
						reportUpdateDTO.setLevel(level);
						reportUpdateDTO.setClientId(clientId);
						reportUpdateDTO.setEmail(email);
						reportUpdateDTO.setTeamId(teamId);
						reportUpdateDTO.setTeamName(teamName);
						reportUpdateDTO.setProfCamps(profCamps);
						reportUpdateDTO.setProfProject(profProj);
						reportUpdateDTO.setDoj(doj);
						reportUpdateDTO.setLastWD(lastWD);
						reportUpdateDTO.setIsBillable(billability);
						reportUpdateDTO.setIsActive(active);
						reportUpdateDTO.setCost(cost);*/
						reportUpdateDTO.setEmpId(empId);
						reportUpdateDTO.setUserName((String)session1.getAttribute("user"));
						reportUpdateDTO.setAction("Authorized");
						reportUpdateDTO.setAuthorizedAs("Viewer");
						reportUpdateDTO.setTimeStamp(timestamp);
						reportUpdateDTO.setDate(sqlDate);
						
						reportUpdate.updateEmpReport_Aurthorized(reportUpdateDTO);
					}
					request.getRequestDispatcher("authorizeemployee.jsp").forward(request, response);
				}
			}
		
			else if("User".equals(action)){
			int a =0;
			 a =  authorizecontroller.useremployee(dto);
			 if(a == 1){
				 	request.setAttribute("message", "Authorised as user");
				 	if(session1!= null){
					
						reportUpdateDTO.setEmpId(empId);
						reportUpdateDTO.setUserName((String)session1.getAttribute("user"));
						reportUpdateDTO.setAction("Authorized");
						reportUpdateDTO.setAuthorizedAs("User");
						reportUpdateDTO.setTimeStamp(timestamp);
						reportUpdateDTO.setDate(sqlDate);
						
						reportUpdate.updateEmpReport_Aurthorized(reportUpdateDTO);
					}
					request.getRequestDispatcher("authorizeemployee.jsp").forward(request, response);
			 	}
			}
		
			 else if("Admin".equals(action)){
				 int a = 0;
				 a =  authorizecontroller.adminemployee(dto);
				 if(a == 1){
					 request.setAttribute("message", "Authorised as admin");
					 if(session1!= null) {
							reportUpdateDTO.setEmpId(empId);
							reportUpdateDTO.setUserName((String)session1.getAttribute("user"));
							reportUpdateDTO.setAction("Authorized");
							reportUpdateDTO.setAuthorizedAs("Admin");
							reportUpdateDTO.setTimeStamp(timestamp);
							reportUpdateDTO.setDate(sqlDate);
							
							reportUpdate.updateEmpReport_Aurthorized(reportUpdateDTO);
						}
					 request.getRequestDispatcher("admintool.jsp").forward(request, response);
				 	}
			 }
		
	}
	
}
