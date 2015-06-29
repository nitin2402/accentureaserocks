package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;



/**
 * Servlet implementation class AddEmployeeManual
 */
public class AddTeamManually2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamManually2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		String TeamName = request.getParameter("Tname");
		String Teamid = request.getParameter("Tno");
		String ModuleId = request.getParameter("Mname");
		String TeamDesc = request.getParameter("desc");
		TeamDetailsFlatDTO detailsDO = new TeamDetailsFlatDTO();
		detailsDO.setTeamName(TeamName);
		detailsDO.setTeamid(Teamid);
		detailsDO.setModuleId(ModuleId);
		detailsDO.setTeamDesc(TeamDesc);
		
	
		TeamController TeamManager = new TeamController();
		
		int c=TeamManager.addTeam(detailsDO);
		if(c !=0){
			request.setAttribute("message","Record Inserted");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		if(c ==0){
			request.setAttribute("message","Record insertion failed");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
	}

}
