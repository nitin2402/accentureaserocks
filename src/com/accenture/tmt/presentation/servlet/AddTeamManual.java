package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.dao.TeamDAO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;
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
	

		String TeamName = request.getParameter("tname");
		//String Teamid = request.getParameter("project1");
		String ModuleId = request.getParameter("module");
		String TeamDesc = request.getParameter("desc");
		
		TeamDAO teamDAO= new TeamDAO();
		int lastCount = teamDAO.countRows();
		String Teamid = "TE -"+ (lastCount + 1);
		
		TeamDetailsFlatDTO detailsDO = new TeamDetailsFlatDTO();
		detailsDO.setTeamName(TeamName);
		detailsDO.setTeamId(Teamid);
		detailsDO.setModuleId(ModuleId);
		detailsDO.setTeamDescription(TeamDesc);
		
		java.sql.Date sqlDate=null;
		
		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());
		TeamController TeamManager = new TeamController();
		TeamReportUpdateDTO reportupdatedto = new TeamReportUpdateDTO();
		TeamReportController update=new TeamReportController();
		int c=TeamManager.addTeamManual(detailsDO);
		TeamDetailsFlatDTO detailsFD = new TeamDetailsFlatDTO();
		detailsFD.setModuleId(ModuleId);
		detailsFD.setTeamName(TeamName);
		detailsFD.setTeamId(Teamid);
		detailsFD.setTeamDescription(TeamDesc);
		if(c !=0){
			
			request.setAttribute("message","Record Inserted");
			if(session1!= null){
		
			reportupdatedto.setModuleId(ModuleId);
			reportupdatedto.setTeamId(Teamid);
			reportupdatedto.setTeamName(TeamName);
			reportupdatedto.setTeamDescription(TeamDesc);
			reportupdatedto.setUsername((String)session1.getAttribute("user"));
			reportupdatedto.setAction("added");
			reportupdatedto.setTimestamp(timestamp);
			reportupdatedto.setDate(sqlDate);
			update.updateTeamReport(reportupdatedto);
			}
			
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		if(c ==0){
			request.setAttribute("message","Record insertion failed");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
	}

}
