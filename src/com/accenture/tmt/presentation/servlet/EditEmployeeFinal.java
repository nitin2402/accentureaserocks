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
 * Servlet implementation class EditEmployeeFinal
 */
public class EditEmployeeFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeFinal() {
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
		
		String employeeDetails=request.getParameter("employeeDetails");
		String editEmployee=request.getParameter("editEmployee");
		String deleteEmployee=request.getParameter("deleteEmployee");
		EmployeeController controller = new EmployeeController();
		
		if(editEmployee!=null){
			List<EmployeeDetailsFlatDTO> li = new ArrayList<EmployeeDetailsFlatDTO>();
			li=controller.FetchEmployeeList(employeeDetails);
			request.setAttribute("editemp", li);
			request.getRequestDispatcher("editemployee.jsp").forward(request, response);
		}
		/*if(deleteEmployee!=null){
			
			
			try {
				 controller.(employeeDetails);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message","Record Deleted");
			request.getRequestDispatcher("viewteam.jsp").forward(request, response);
	}
*/
}
}
