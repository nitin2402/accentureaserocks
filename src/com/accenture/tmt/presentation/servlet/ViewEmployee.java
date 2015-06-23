package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





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
		 List<SearchFormDTO> listOfEmps  = new ArrayList<SearchFormDTO>(); 
		
		 listOfEmps = fetch.fetchEmployeeDetails(null);
		/* List<EmployeeDetailsForm> listOfEmpsForms = new ArrayList<EmployeeDetailsForm>();
		 EmployeeDetailsForm detailsForm = null;
		 for (SearchDetailsForm SearchDetailsForm : listOfEmps) {
			 detailsForm = new EmployeeDetailsForm();
			 detailsForm.setDesignation(SearchDetailsForm.getDesignation());
			 detailsForm.setEmpId(SearchDetailsForm.getEmpId());
			 detailsForm.setEmpName(SearchDetailsForm.getEmpName());
			 detailsForm.setLevel(SearchDetailsForm.getLevel());
			 detailsForm.setExpertise(SearchDetailsForm.getExpertise());
			 detailsForm.setLevel(SearchDetailsForm.getLevel());
			 listOfEmpsForms.add(detailsForm);
		}
		*/
		 		 
		 request.setAttribute("empList",listOfEmps);
		// request.getRequestDispatcher("view.jsp").forward(request, response);
		 
	}

}
