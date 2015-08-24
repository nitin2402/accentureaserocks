package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.ProjectController;
import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;
import com.accenture.tmt.presentation.dto.ProjectDTO;
import com.accenture.tmt.presentation.dto.TeamFormDTO;
import com.google.gson.Gson;

/**
 * Servlet implementation class DropDownDetails
 */
public class DropDownDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DropDownDetails() {
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

		String projectId = "";
		String isTreeStructure = "";
		if (request.getParameter("projectId") != null) {
			projectId = request.getParameter("projectId");
			isTreeStructure = request.getParameter("tree");
		}

		List<ProjectDTO> proj_list = new ArrayList<ProjectDTO>();

		ProjectController fetch = new ProjectController();
		proj_list = fetch.fetchProjectDetails();

		List<ModuleFormDTO> module_list = new ArrayList<ModuleFormDTO>();
		ModuleController fetch_mod = new ModuleController();
		module_list = fetch_mod.moduleFetch();

		List<TeamFormDTO> team_list = new ArrayList<TeamFormDTO>();
		TeamController fetch_team = new TeamController();
		team_list = fetch_team.teamFetch();

		if (isTreeStructure.equals("true")) {

			PrintWriter out = response.getWriter();

			out.print("{\"module\"" + ":" + new Gson().toJson(module_list)
					+ ",\"team\":" + new Gson().toJson(team_list)
					+ ",\"project\":" + new Gson().toJson(proj_list) + "}");

		} else {
			/*
			 * List<ProjectDTO> proj_list = new ArrayList<ProjectDTO>();
			 * 
			 * ProjectController fetch = new ProjectController(); proj_list =
			 * fetch.fetchProjectDetails();
			 */
			request.setAttribute("project", proj_list);
			/*
			 * List<ModuleFormDTO> module_list = new ArrayList<ModuleFormDTO>();
			 * ModuleController fetch_mod = new ModuleController(); module_list
			 * = fetch_mod.moduleFetch();
			 */
			request.setAttribute("module", module_list);

			/*
			 * List<TeamFormDTO> team_list = new ArrayList<TeamFormDTO>();
			 * TeamController fetch_team = new TeamController(); team_list =
			 * fetch_team.teamFetch();
			 */
			request.setAttribute("team", team_list);

		}

	}

}
