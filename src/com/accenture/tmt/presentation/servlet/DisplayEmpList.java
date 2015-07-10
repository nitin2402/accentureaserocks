package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.manager.EmployeeController;




/**
 * Servlet implementation class DisplayEmpList
 */
public class DisplayEmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmpList() {
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
		String exp = null;
		List<EmployeeDetailsFlatDTO> li = new ArrayList<EmployeeDetailsFlatDTO>();
		
		String tid = request.getParameter("teamnam");
	
	
		EmployeeController disp = new EmployeeController();
		li=disp.FetchEmployeeList(tid);
		
	
		
		exp = " <table class= \"table1\" border=\"1\" ><thead style=\"font-weight:bold;\">"
				+ "<tr style=\"font-weight:bold\"><td>Name</td><td>ID</td><td>Level</td><td>Designation</td><td>Expertise</td></tr>";

		for (int i = 0; i < li.size(); i++) {
			exp += "<tr><td>" + li.get(i).getEmpName()
					+ "</td>";
			exp += "<td>" + li.get(i).getEmpId() + "</td>" + "<td>"
					+ li.get(i).getLevel() + "</td>" + "<td>"
					+ li.get(i).getDesignation() + "</td>";
			exp +=  "<td>"
					+ li.get(i).getExpertise() + "</td>";
			exp += "</tr>";
		}
		exp += "</tbody></table>";
		request.setAttribute("displaylist", exp);
		request.getRequestDispatcher("viewteamemp.jsp").forward(request, response);
		
	}

}
