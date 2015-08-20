package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.manager.ModuleReportController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;


/**
 * Servlet implementation class AddModule
 */
public class AddModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddModule() {
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
		
		ModuleFormDTO moduleformdto = new ModuleFormDTO();
		ModuleController modulecontroller = new ModuleController();
		ModuleReportUpdateDTO reportupdatedto = new ModuleReportUpdateDTO();
		ModuleReportController modulereportcontroller = new ModuleReportController();

		java.sql.Date sqlDate = null;

		HttpSession session1 = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String timestamp = df.format(date);
		sqlDate = new java.sql.Date(date.getTime());
		String moduleName = request.getParameter("modulename");
		String projectName = request.getParameter("project1");
		String moduleDescription = request.getParameter("moduledesc");
		String status = request.getParameter("status");

		moduleformdto.setModuleName(moduleName);

		moduleformdto.setModuleDescription(moduleDescription);
		moduleformdto.setProject(projectName);
		moduleformdto.setStatus(status);
		JSONObject obj = modulecontroller.addModule1(moduleformdto);
		if (obj.get("status").toString().equals("1")) {
			request.setAttribute("message", "Module Inserted Successfully");
			if (session1 != null) {
				reportupdatedto.setModuleId(obj.get("moduleId").toString());
				reportupdatedto.setModuleName(moduleName);
				reportupdatedto.setProjectId(obj.get("projectId").toString());
				reportupdatedto.setModuleDescription(moduleDescription);
				reportupdatedto.setUserName((String) session1.getAttribute("user"));
				reportupdatedto.setAction("added");
				reportupdatedto.setTimeStamp(timestamp);
				reportupdatedto.setDates(sqlDate);
				modulereportcontroller.updateModuleReport(reportupdatedto);
			}

		} else if (obj.get("status").toString() == "0") {
			request.setAttribute("message", "No Module Inserted	");
		}

		request.getRequestDispatcher("addmodule.jsp").forward(request, response);

	}
}

