package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;


/**
 * Servlet implementation class EditTeamFinal
 */
public class EditTeamFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamFinal() {
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
		
		TeamReportUpdateDTO reportUpdateDTO = new TeamReportUpdateDTO();
		TeamReportController reportController = new TeamReportController();
		HttpSession session1 = request.getSession();
		
		java.sql.Date sqlDate=null;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String timestamp= df.format(date);
		sqlDate= new java.sql.Date(date.getTime());
		
		String teamName = request.getParameter("teamname");
		String module = request.getParameter("module");
		String teamDesc = request.getParameter("teamdesc");
		String teamid = request.getParameter("teamid");
		
		ModuleController id  =new ModuleController();
		String moduleId = id.fetchModuleid(module); //converting moduleName into moduleId
		
		int a = 0;
		TeamController edit = new TeamController();
		a = edit.EditTeam(teamName, moduleId, teamDesc, teamid);
		if(a!=0)
		{
			request.setAttribute("message","Team Updated");
			if(session1!= null){
				reportUpdateDTO.setTeamId(teamid);
				reportUpdateDTO.setTeamName(teamName);
				reportUpdateDTO.setModuleId(moduleId);
				reportUpdateDTO.setTeamDescription(teamDesc);
				reportUpdateDTO.setUsername((String)session1.getAttribute("user"));
				reportUpdateDTO.setAction("edited");
				reportUpdateDTO.setTimestamp(timestamp);
				reportUpdateDTO.setDate(sqlDate);
				reportController.updateTeamReport(reportUpdateDTO);
			}
			request.getRequestDispatcher("viewteam.jsp").forward(request, response);
		}
		if (a==0)
		{
			request.setAttribute("message","Team not Updated");
			request.getRequestDispatcher("viewteam.jsp").forward(request, response);
			}
		}
	}


