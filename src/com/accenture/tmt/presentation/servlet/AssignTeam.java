package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.manager.EmployeeController;



/**
 * Servlet implementation class AssignTeam
 */
public class AssignTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssignTeam() {
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

		String newEmp = request.getParameter("employee");
String submit1 = request.getParameter("assign");
String submit2 = request.getParameter("edit");
		
		if(submit1 !=null)
		{
		EmployeeController search = new EmployeeController();
		List<EmployeeDetailsFlatDTO> li = search.getToAssign(newEmp);

		request.setAttribute("searchList", li);
	
		request.getRequestDispatcher("assignteam.jsp").forward(request, response);
		}
		if(submit2 != null)
		{
			EmployeeController search = new EmployeeController();
			List<EmployeeDetailsFlatDTO> li = search.getToAssign(newEmp);

			request.setAttribute("searchList", li);
			request.getRequestDispatcher("editemployee.jsp").forward(request, response);
		}

	}

}
