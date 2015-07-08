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
import com.accenture.tmt.presentation.dto.SearchFormDTO;


/**
 * Servlet implementation class ViewEmployee
 */
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeController fetch = new EmployeeController();
		 List<EmployeeDetailsFlatDTO> listOfEmps  = new ArrayList<EmployeeDetailsFlatDTO>(); 
			
		
		 listOfEmps = fetch.viewEmployee();
		
		 		 
		 request.setAttribute("empList",listOfEmps);
		 
		 
	}

}
