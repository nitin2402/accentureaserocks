package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;



/**
 * Servlet implementation class FetchTeamChart
 */
public class FetchTeamChart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchTeamChart() {
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
		String htmlTree = "<ul>";
		List<String> tempLi = new ArrayList<String>();
		String module = request.getParameter("moduleName");
		ModuleController temp = new ModuleController();
		String moduleId = temp.fetchModuleid(module);
		TeamController fetchTeam = new TeamController();
		tempLi = fetchTeam.fetchTeams(moduleId);
		
		for (int j = 0; j < tempLi.size(); j++) {
			htmlTree += "<li class=\"teamclick\" id = \""+module+1+"\"><a  href=\"#\">" + tempLi.get(j)
					+ "</a></li>";
		}
		htmlTree += "</ul>";
		PrintWriter print = response.getWriter();
		print.print(htmlTree);
	}

}
