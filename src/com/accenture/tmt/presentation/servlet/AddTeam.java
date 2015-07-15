package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;



/**
 * Servlet implementation class AddEmployee
 */
public class AddTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
/*		EmployeeManager employeeManager = new EmployeeManager();
		EmployeeDetailsDO detailsDO = new EmployeeDetailsDO();
		List<EmployeeDetailsDO> empDetails = employeeManager.fetchEmployeeDetails(detailsDO);
		response.sendRedirect("View.jsp?msg=Record Fetched!");
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tName = request.getParameter("tname");
		
     	String module = request.getParameter("module");
		
		

		ModuleController fetchId = new ModuleController();
		String id = fetchId.fetchModuleid(module);
	
//		tdetailsDO.settCode(tCode);
		
		
		TeamController teamManager = new TeamController();
		TeamDetailsFlatDTO detailsDO = new TeamDetailsFlatDTO();
		detailsDO.setTeamName(tName);
		detailsDO.setTeamId(id);
	int	a=teamManager.addTeamManual(detailsDO);
	if (a>0){
		request.setAttribute("message","Team Inserted");
		request.getRequestDispatcher("addteamvia.jsp").forward(request, response);
	}
	else{
		//getServletConfig().getServletContext().getRequestDispatcher(viewName).forward(request,response);
		request.setAttribute("message","Team Addition Failed");
		request.getRequestDispatcher("addteamvia.jsp").forward(request, response);
	}	}
}
