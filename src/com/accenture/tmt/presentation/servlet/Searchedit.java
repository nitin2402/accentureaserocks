package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Searchedit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Searchedit() {
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
		String submit1 = request.getParameter("submit1");
		String submit2 = request.getParameter("submit2");
		EmployeeController search = new EmployeeController();
		
		if(submit2!=null){
			
			
			try {
				 search.deleteEmployee(newEmp);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message","Record Deleted");
			request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
			
			
		}
		if(submit1 != null)
		{
			List<EmployeeDetailsFlatDTO> li = new ArrayList<EmployeeDetailsFlatDTO>();
			li=search.FetchEmployeeList(newEmp);
			request.setAttribute("editemp", li);
			request.getRequestDispatcher("editemployee.jsp").forward(request, response);

			
		}

	}

}
