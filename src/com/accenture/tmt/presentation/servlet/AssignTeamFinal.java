package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.TeamController;



/**
 * Servlet implementation class AssignTeamFinal
 */
public class AssignTeamFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeamFinal() {
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
		String s_module = request.getParameter("s_module");
		String s_team = request.getParameter("s_team");
		String s_empid = request.getParameter("s_empid");
/*		String s_empName = request.getParameter("s_empname");
		String s_empId = request.getParameter("s_empid");
		
		String s_designation = request.getParameter("s_designation");
		String s_expertise = request.getParameter("s_expertise");
		String s_experience = request.getParameter("s_experience");*/
		
		ModuleController moduleId = new ModuleController();
		
		s_module=moduleId.fetchModuleid(s_module);
	//	System.out.println(s_module);
		
		
		
		TeamController teamId = new TeamController();
		
		s_team = teamId.fetchTeamid(s_team,s_module);

		
	//	System.out.println(s_designation+s_empId+s_empName+s_experience+s_expertise+s_level+s_module+s_team);
		
		
		EmployeeController addEmployee = new EmployeeController();
		int assignCheck = addEmployee.addEmployeeFinal(s_empid,s_team);
	HttpSession session = request.getSession(false);
	if((Boolean)session.getAttribute("admin")==true)	{
	if(assignCheck >0)
		{
			request.setAttribute("message", "Employee Assigned to team");
		
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);

		}
		else
		{
			request.setAttribute("message", "Assign Failed !! Try again");
		
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}
	}
	if((Boolean)session.getAttribute("admin")==false)	{
		if(assignCheck >0)
			{
				request.setAttribute("message", "Employee Assigned to team");
			
				request.getRequestDispatcher("userhome.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message", "Assign Failed !! Try again");
				request.getRequestDispatcher("userhome.jsp").forward(request, response);
			}
		}
	//	
	}

}
