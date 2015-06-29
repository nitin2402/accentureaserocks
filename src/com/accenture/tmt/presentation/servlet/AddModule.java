package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.ModuleDetailsDTO;
import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;


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
		int status = 0;
		
		String moduleName = request.getParameter("modulename");
		String projectName = request.getParameter("project1");
		String moduleDescription = request.getParameter("moduledesc");
		String moduleId = request.getParameter("moduleid");
		
		moduleformdto.setModuleName(moduleName);
		moduleformdto.setModuleId(moduleId);
		moduleformdto.setModuleDescription(moduleDescription);
		moduleformdto.setProject(projectName);
		
		status = modulecontroller.addModule1(moduleformdto);
		
		if(status == 1){
			request.setAttribute("message", "Module Inserted Successfully");
		} else if(status == 0){
			request.setAttribute("message", "No Module Inserted	");
		}
		
		request.getRequestDispatcher("admintool.jsp").forward(request, response);
		
	}

}
