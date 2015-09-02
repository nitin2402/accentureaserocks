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
		java.sql.Date sqlDate=null;
		String teamname = request.getParameter("teamname");
		String module = request.getParameter("module");
		String teamdesc = request.getParameter("teamdesc");
		String teamid = request.getParameter("teamid");
		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());
		ModuleController id  =new ModuleController();
		String moduleid = id.fetchModuleid(module); 
		
		TeamController edit = new TeamController();
		TeamReportUpdateDTO reportupdatedto = new TeamReportUpdateDTO();
		TeamReportController update=new TeamReportController();
		int a = edit.EditTeam(teamname, moduleid, teamdesc, teamid);
		if(a!=0)
		{
			if(session1!= null){
				
				reportupdatedto.setModuleId(moduleid);
				reportupdatedto.setTeamId(teamid);
				reportupdatedto.setTeamName(teamname);
				reportupdatedto.setTeamDescription(teamdesc);
				reportupdatedto.setUsername((String)session1.getAttribute("user"));
				reportupdatedto.setAction("edited");
				reportupdatedto.setTimestamp(timestamp);
				reportupdatedto.setDate(sqlDate);
				update.updateTeamReport(reportupdatedto);
				}
			
			
			request.setAttribute("message","Team Updated");
		request.getRequestDispatcher("admintool.jsp").forward(request, response);
			}
		if (a==0)
		{
			request.setAttribute("message","Team not Updated");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);
			}
		}
	}


