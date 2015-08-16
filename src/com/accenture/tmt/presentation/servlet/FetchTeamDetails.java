package com.accenture.tmt.presentation.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.presentation.dto.TeamFormDTO;

/**
 * Servlet implementation class FetchTeamDetails
 */
public class FetchTeamDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchTeamDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<TeamFormDTO> li = new ArrayList<TeamFormDTO>();
		TeamController fetch = new TeamController();
		li = fetch.fetchTeamDetails();
		
		String exp = "<form action=\"EditTeam\"><div id=\"scrollable\"> <table class= \"table1\" border=\"1\" >"
				+ "<tr style=\"font-weight:bold\"><td></td><td>Team Name</td><td>Module Name </td><td>Project Name</td><td>Team Description</td></tr>";

		for (int i = 0; i < li.size(); i++) {
			exp += "<tr><td><input type=\"radio\" name=\"teamedit\" value=\""+li.get(i).getTeamId()+"\"></td><td>" + li.get(i).getTeamName() + "</td>";
			exp += "<td>"+ li.get(i).getModuleName() + "</td>" + "<td>"
					+ li.get(i).getProjectName() + "</td>"+ "<td>"
							+ li.get(i).getTeamDescription() + "</td>";

			exp += "</tr>";
		}
		exp += "</table></div><input type=\"submit\" name=\"submit1\" value=\"Edit\"> <input type=\"submit\" name=\"submit2\" value=\"Delete\">";
		
		request.setAttribute("team", exp);
		
	}
}
