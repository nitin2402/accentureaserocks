package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.manager.ReportController;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;

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
		if(employeeDetails==null){
			request.setAttribute("message","Please Select An Employee");
			request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
		}
		
		if(editEmployee!=null){
			List<EmployeeDetailsFlatDTO> li = new ArrayList<EmployeeDetailsFlatDTO>();
			li=controller.FetchEmployeeList(employeeDetails);
			request.setAttribute("editemp", li);
			request.getRequestDispatcher("editemployee.jsp").forward(request, response);
		}
		
		HttpSession session1 = request.getSession();
		java.sql.Date sqlDate=null;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());

		
		
		
		
		if(deleteEmployee!=null){
			
			
			try {
			 controller.deleteEmployee(employeeDetails);
				 
					 
						request.setAttribute("message","Employee Deleted");
						
						EmployeeReportUpdateDTO reportupdatedto = new EmployeeReportUpdateDTO();
						ReportController update=new ReportController();
						if(session1!= null){
							List<EmployeeDetailsFlatDTO> li = new ArrayList<EmployeeDetailsFlatDTO>();
							li=controller.FetchEmployeeList(employeeDetails);
						
							for(int i =0;i<li.size();i++){
								
								reportupdatedto.setEmpId(li.get(i).getEmpId());
								reportupdatedto.setEmpName(li.get(i).getEmpName());
								reportupdatedto.setDesignation(li.get(i).getDesignation());
								reportupdatedto.setLevel(li.get(i).getLevel());
								reportupdatedto.setExpertise(li.get(i).getExpertise());
								reportupdatedto.setClientId(li.get(i).getClientId());
								reportupdatedto.setEmail(li.get(i).getEmail());
								 reportupdatedto.setTeamId(li.get(i).getTeamId());
								 reportupdatedto.setTeamName(li.get(i).getTeamName());
								reportupdatedto.setProfCamps(li.get(i).getProfCamps());
								reportupdatedto.setProfProject(li.get(i).getProfProject());
								reportupdatedto.setDoj(li.get(i).getDoj());
								reportupdatedto.setLastWD(li.get(i).getLastWD());
								reportupdatedto.setIsBillable(li.get(i).getIsBillable());
								reportupdatedto.setIsActive(li.get(i).getIsActive());
								reportupdatedto.setCost(li.get(i).getCost());
								reportupdatedto.setUserName((String)session1.getAttribute("user"));
								reportupdatedto.setAction("deleted");
								reportupdatedto.setTimeStamp(timestamp);
								reportupdatedto.setDate(sqlDate);
								update.updateEmpreport(reportupdatedto);
								}
							
						}

				 
			} catch (ClassNotFoundException |IllegalStateException il) {
				// TODO Auto-generated catch block
				il.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
	}else{
		request.setAttribute("message","Employee Deletion Failed");
		request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
 }

}
}
