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

		String team = request.getParameter("teamName");
		String module = request.getParameter("moduleName");
		
		
		
		ModuleController m = new ModuleController();
		String mid = m.fetchModuleid(module);
		
		
		
		TeamController t =new TeamController();
		String tid = t.fetchTeamid(team, mid);
	

		
		int noOfASE = 0;
		int noOfSE = 0;
		int noOfSSE = 0;
		int noOfTL=0;

		EmployeeController countEmp = new EmployeeController();

		noOfASE = countEmp.fetchEmployeeCount(tid, "ASE");
		noOfSE = countEmp.fetchEmployeeCount(tid, "SE");
		noOfSSE = countEmp.fetchEmployeeCount(tid, "SSE");
	    noOfTL=countEmp.fetchEmployeeCount(tid, "TL");
		

		PrintWriter print = response.getWriter();
		print.print("<table id=\"hi\" class=\"table2\" border=\"1\"><tr><td>ASE:</td><td name=\"ase\" id=\"ase\">" + noOfASE
				+ "</td></tr><tr><td>SE:</td><td name=\"se\" id=\"se\">" + noOfSE
				+ "</td></tr><tr><td>SSE:</td><td name=\"sse\" id=\"sse\">" + noOfSSE + "</td></tr>"
						+ "<tr><td>TL:</td><td name=\"tl\" id=\"tl\">" + noOfTL + "</td></tr>"
								+ "</table><form action=\"DisplayEmpList\">"
						+ "	<input type=\"hidden\"  name=\"teamnam\" value=\""+tid+"\">"
						+ "<input type=\"submit\" value=\"Show Employees\"></form><br<br>");

		

	}

}
