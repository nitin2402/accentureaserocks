package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;

/**
 * Servlet implementation class AddEmployeeManual
 */
public class AddTeamManual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamManual() {
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
	    TeamReportUpdateDTO reportUpdateDTO = new TeamReportUpdateDTO();
	    TeamReportController reportController = new TeamReportController();
		HttpSession session1 = request.getSession();
		
		String TeamName = request.getParameter("Tname");
		String Teamid = request.getParameter("Tno");
		String ModuleId = request.getParameter("Mname");
		String TeamDesc = request.getParameter("desc");
		TeamDetailsFlatDTO detailsDO = new TeamDetailsFlatDTO();
		detailsDO.setTeamName(TeamName);
		detailsDO.setTeamId(Teamid);
		detailsDO.setModuleId(ModuleId);
		detailsDO.setTeamDescription(TeamDesc);
		
		java.sql.Date sqlDate=null;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String timestamp= df.format(date);
		sqlDate= new java.sql.Date(date.getTime());
		
		TeamController TeamManager = new TeamController();
		int c = 0;
		c = TeamManager.addTeamManual(detailsDO);
		
		if(c!=0){
			request.setAttribute("message","Record Inserted");
			if(session1!= null){
				reportUpdateDTO.setTeamId(Teamid);
				reportUpdateDTO.setTeamName(TeamName);
				reportUpdateDTO.setModuleId(ModuleId);
				reportUpdateDTO.setTeamDescription(TeamDesc);
				reportUpdateDTO.setUsername((String)session1.getAttribute("user"));
				reportUpdateDTO.setAction("added");
				reportUpdateDTO.setTimestamp(timestamp);
				reportUpdateDTO.setDate(sqlDate);
				reportController.updateTeamReport(reportUpdateDTO);
			}
			
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		if(c == 0){
			request.setAttribute("message","Record insertion failed");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
	}

}
