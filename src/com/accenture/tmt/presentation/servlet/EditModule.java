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

import com.accenture.tmt.dao.dto.ModuleDetailsDTO;
import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.ModuleReportController;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;



/**
 * Servlet implementation class EditModule
 */
public class EditModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditModule() {
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
		String submit1=request.getParameter("submit1");
		String submit2=request.getParameter("submit2");
		ModuleController editModule = new ModuleController();
		ModuleReportUpdateDTO reportupdatedto = new ModuleReportUpdateDTO();
		ModuleReportController modulereportcontroller = new ModuleReportController();
		HttpSession session1 = request.getSession();
		java.sql.Date sqlDate=null;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());
		String module = request.getParameter("moduleedit");
		if(module==null){
			request.setAttribute("message","Please select the radio button");
			request.getRequestDispatcher("viewmodule.jsp").forward(request, response);	
		}
		if(submit1 != null){
		List<ModuleDetailsDTO> li = new ArrayList<ModuleDetailsDTO>();
	
		
	
		
		li=editModule.fetchModuleDetails(module);
		
		

		request.setAttribute("module", li);
		request.getRequestDispatcher("editmodule.jsp").forward(request, response);
		}
		
		if(submit2 != null){
			try {
				List<ModuleDetailsDTO> li = new ArrayList<ModuleDetailsDTO>();
				li=editModule.fetchModuleDetails(module);
				int status=editModule.deleteModule(module);
				if(status==1){
					request.setAttribute("message","Module Deleted and Employees Are Set To Free !!!");
					if(session1!= null){
						for(int i =0;i<li.size();i++){
						reportupdatedto.setModuleId(module);
						reportupdatedto.setModuleName(li.get(i).getModuleName());
						reportupdatedto.setProjectId(li.get(i).getProjectId());
						reportupdatedto.setModuleDescription(li.get(i).getModuleDescription());
						reportupdatedto.setUserName((String)session1.getAttribute("user"));
						reportupdatedto.setAction("deleted");
						reportupdatedto.setTimeStamp(timestamp);
						reportupdatedto.setDates(sqlDate);
					modulereportcontroller.updateModuleReport(reportupdatedto);
					}
					}
					
					}
				else{
					request.setAttribute("message","Technical Error!!! Try Again Later...");
				}
					request.getRequestDispatcher("viewmodule.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
}
}