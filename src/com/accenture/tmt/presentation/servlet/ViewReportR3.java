package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;


/**
 * Servlet implementation class ViewReportR3
 */
public class ViewReportR3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReportR3() {
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
		List<String> li = new ArrayList<String>();

		String htmlTree = "<ul><li ><a  href=\"#\">R3</a><ul>";

		ModuleController fetchmodule = new ModuleController();

		li = fetchmodule.FetchModuleByProject("R3");

		for (int i = 0; i < li.size(); i++) {
			List<String> tempLi = new ArrayList<String>();
			String moduleId = null;
			ModuleController temp = new ModuleController();
			moduleId = temp.fetchModuleid(li.get(i));
			TeamController fetchTeam = new TeamController();
			tempLi = fetchTeam.fetchTeams(moduleId);

			htmlTree += "<li class=\"moduleclick\" id=\""+li.get(i)+"\">" + li.get(i)
					+ "</li><ul>";
			for (int j = 0; j < tempLi.size(); j++) {
				htmlTree += "<li class=\"teamclick\"><a>" + tempLi.get(j)
						+ "</a></li>";
			}
			htmlTree += "</ul>";

			// System.out.println("break");

			// System.out.println(tempLi.size());
		}
		htmlTree += "</ul></li></ul>";

		/*System.out.println(htmlTree);*/

		/*
		 * request.setAttribute("moduleList", li);
		 * request.setAttribute("project", project);
		 * request.getRequestDispatcher("viewprojectchart.jsp").forward(request,
		 * response);
		 * 
		 * htmlTree += "<ul><li>" + project + "<ul><li>";
		 */
		request.setAttribute("html1", htmlTree);
	}

}
