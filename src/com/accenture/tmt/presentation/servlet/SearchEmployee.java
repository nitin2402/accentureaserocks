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
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployee() {
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

		exp = "<form action =\"AssignTeam\" method=\"post\"><div id=\"scrollable\"> <table  class= \"table1\" border=\"1\" >";

		for (int i = 0; i < li.size(); i++) {
			exp += "<tr><td><input type=\"radio\" name=\"employee\" value= \""
					+ li.get(i).getEmpId() + "\"></td><td>" + li.get(i).getEmpName()
					+ "</td>";
			exp += "<td>" + li.get(i).getEmpId() + "</td>" + "<td>"
					+ li.get(i).getLevel() + "</td>" + "<td>"
					+ li.get(i).getDesignation() + "</td>";
			exp += "<td>" + li.get(i).getAtt() + "</td>" + "<td>"
					+ li.get(i).getExpertise() + "</td>";
			exp += "<td>" + li.get(i).getEmail() + "</td>" + "<td>"
					+ li.get(i).getTeam()+ "</td>"+ "<td>"
							+ li.get(i).getModule()+ "</td>"+ "<td>"
									+ li.get(i).getProject()+ "</td>";
			exp += "</tr>";
		}
		if((Boolean)session.getAttribute("admin")==true){
		exp += "</table></div><br><input type=\"submit\" value = \"Assign Team\" name = \"assign\"><input type=\"submit\" value = \"Edit Details\" name = \"edit\">";
		exp += "</form>";}
		if((Boolean)session.getAttribute("admin")==false){
			exp += "</table></div><br><input type=\"submit\" value = \"Assign Team\" name = \"assign\">";
			exp += "</form>";}

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