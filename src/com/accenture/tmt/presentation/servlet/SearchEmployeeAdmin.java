package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.presentation.dto.SearchFormDTO;



/**
 * Servlet implementation class SearchEmployee
 */
public class SearchEmployeeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployeeAdmin() {
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

		String name = request.getParameter("searchName");
	HttpSession session = request.getSession(false);
		List<SearchFormDTO> li = new ArrayList<SearchFormDTO>();
		EmployeeController search = new EmployeeController();
		li = search.searchEmployee(name);
	
		if(name!="" && li.size() != 0)
		{
		
		String exp = null;

		exp = "<form action =\"Searchedit\" method=\"post\"><div id=\"scrollable\"> <table  class= \"table1\" border=\"1\" ><tr style=\"font-weight:bold\"><td></td>"
				+ "<td>Employee ID</td><td>Employee Name </td><td>Designation</td><td>Level</td><td>Expertise</td><td>Client Id</td><td>Email</td><td>Team ID</td><td>Proficiency Cams</td><td>Proficiency Project</td><td>Date of Joining</td><td>Last Working Day</td><td>Billable</td><td>Active User</td></tr>";
		
	
		
		for (int i = 0; i < li.size(); i++) {
			exp += "<tr class=\"table_align\"><td><input type=\"radio\" name=\"employee\" value= \""
					
					+ li.get(i).getEmpId() + "\"></td>" ;
			exp += "<td>" + li.get(i).getEmpId()
					+ "</td>";
			exp += "<td>" + li.get(i).getEmpName()
					+ "</td>";
			
					
			exp += "<td>" + li.get(i).getDesignation()
					+ "</td>";
			exp += "<td>" + li.get(i).getLevel() 
					+ "</td>";
			exp += "<td>" + li.get(i).getExpertise() 
					+ "</td>";
			exp += "<td>" + li.get(i).getClientId() 
					+ "</td>";
			exp += "<td>" + li.get(i).getEmail() 
					+ "</td>";
			exp += "<td>" + li.get(i).getTeamId() 
					+ "</td>";
			exp += "<td>" + li.get(i).getProfCamps() 
					+ "</td>";
			exp += "<td>" + li.get(i).getProfProject() 
					+ "</td>";
			exp += "<td>" + li.get(i).getDateOfJoining() 
					+ "</td>";
			exp += "<td>" + li.get(i).getLastWorkingDay() 
					+ "</td>";
			exp += "<td>" + li.get(i).getBillable() 
					+ "</td>";
			exp += "<td>" + li.get(i).getActiveUser() 
					+ "</td>";
			

			exp += "</tr>";
	}
	
		exp += "</table></div><input type=\"submit\" name=\"submit1\" value=\"Edit\"> <input type=\"submit\" name=\"submit2\" value=\"Delete\">";
	
		
		PrintWriter out = response.getWriter();

	out.print(exp);
	}
	else
	{
		PrintWriter out = response.getWriter();

		out.print("");
	}
	// request.setAttribute("searchList", li);

	/*
	 * request.getRequestDispatcher("viewsearched.jsp").forward(request,
	 * response);
	 */
}
}
