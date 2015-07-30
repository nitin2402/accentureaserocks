package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.ModuleReportController;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;



/**
 * Servlet implementation class EditModuleFinal
 */
public class EditModuleFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditModuleFinal() {
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
		
		java.sql.Date sqlDate=null;
		String modulename = request.getParameter("modulename");
		String project = request.getParameter("project");
		String moduledesc = request.getParameter("moduledesc");
		String moduleid = request.getParameter("moduleid");
		
		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());
		ModuleController edit = new ModuleController();
		ModuleReportController modulereportcontroller = new ModuleReportController();
		ModuleReportUpdateDTO reportupdatedto = new ModuleReportUpdateDTO();
		
		int a = edit.editModule(modulename, project, moduledesc, moduleid);
		if(a!=0)
		{
			request.setAttribute("message","Module Updated");
			if(session1 != null){
				reportupdatedto.setModuleId(moduleid);
				reportupdatedto.setModuleName(modulename);
				reportupdatedto.setProjectId(project);
				reportupdatedto.setModuleDescription(moduledesc);
				reportupdatedto.setUserName((String)session1.getAttribute("user"));
				reportupdatedto.setAction("edited");
				reportupdatedto.setTimeStamp(timestamp);
				reportupdatedto.setDates(sqlDate);
				modulereportcontroller.updateModuleReport(reportupdatedto);
				request.getRequestDispatcher("viewmodule.jsp").forward(request, response);
			}
		}
		if (a==0)
		{
			request.setAttribute("message","Module not Updated");
			request.getRequestDispatcher("viewmodule.jsp").forward(request, response);
		}
	
	}
}