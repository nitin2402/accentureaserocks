package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.TeamDetailsDTO;
import com.accenture.tmt.manager.TeamController;



/**
 * Servlet implementation class EditTeam
 */
public class EditTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeam() {
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
		
		String team = request.getParameter("teamedit");
	/*	String module = request.getParameter("s_module");
		String n_team = request.getParameter("newteam");
		String n_module = request.getParameter("newmodule");*/
		List<TeamDetailsDTO> li = new ArrayList<TeamDetailsDTO>();
	
		

		TeamController editteam = new TeamController();
		
		li = editteam.FetchTeamDetails(team);
		
	/*if(n_module==module )
		{
		n_module=module;
		}
	
	if(n_team ==null || n_team =="")
	{
		n_team=team;
	}*/
		/*ModuleManager m = new ModuleManager();
		String mid = m.fetchModuleid(module);*/
	
		/*String tid = editteam.fetchTeamid(team,mid);
	
		
		
	
		
		int a =editteam.EditTeam(n_team, mid,tid);
		if(a>0)
		{
response.sendRedirect("editteam.jsp?msg1=Module Edited");
		}
		else
		{
			
				response.sendRedirect("editteam.jsp?msg1=Failed to save changes !!");
						
		}*/
		request.setAttribute("team", li);
		request.getRequestDispatcher("editteam.jsp").forward(request, response);
	}

}
