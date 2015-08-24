package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;

/**
 * Servlet implementation class FetchTeamEmployees
 */
public class FetchTeamEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchTeamEmployees() {
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

		String team = request.getParameter("teamId");

		int noOfASE = 0;
		int noOfSE = 0;
		int noOfSSE = 0;
		int noOfTL = 0;

		EmployeeController countEmp = new EmployeeController();

		noOfASE = countEmp.fetchEmployeeCount(team, "ASE");
		noOfSE = countEmp.fetchEmployeeCount(team, "SE");
		noOfSSE = countEmp.fetchEmployeeCount(team, "SSE");
		noOfTL = countEmp.fetchEmployeeCount(team, "TL");

		PrintWriter print = response.getWriter();
		print.print("{\"ASE\":" + noOfASE + ",\"SE\":" + noOfSE + ",\"SSE\":"
				+ noOfSSE + ",\"TL\":" + noOfTL + "}");

	}

}
