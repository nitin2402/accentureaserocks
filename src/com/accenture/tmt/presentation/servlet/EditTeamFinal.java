package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;


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
		String teamname = request.getParameter("teamname");
		String module = request.getParameter("module");
		String teamdesc = request.getParameter("teamdesc");
		String teamid = request.getParameter("teamid");
		
		ModuleController id  =new ModuleController();
		String moduleid = id.fetchModuleid(module); 
		
		TeamController edit = new TeamController();
		int a = edit.EditTeam(teamname, moduleid, teamdesc, teamid);
		if(a!=0)
		{request.setAttribute("message","Team Updated");
		request.getRequestDispatcher("viewteam.jsp").forward(request, response);
			}
		if (a==0)
		{
			request.setAttribute("message","Team not Updated");
			request.getRequestDispatcher("viewteam.jsp").forward(request, response);
			}
		}
	}


