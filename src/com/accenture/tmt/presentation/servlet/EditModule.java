package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.ModuleDetailsDTO;
import com.accenture.tmt.manager.ModuleController;



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
		String module = request.getParameter("moduleedit");
		if(submit1 != null){
		List<ModuleDetailsDTO> li = new ArrayList<ModuleDetailsDTO>();
	
		
	/*	String newModule = request.getParameter("newmodule");
		String project = request.getParameter("project1");
*/
		
		li=editModule.fetchModuleDetails(module);
		
		
/*	if(newModule==null || newModule=="")
		{
		newModule=module;
		}*/
		
		/*String id = editModule.fetchModuleid(module);*/
	
		
		
		/*String projectId = editModule.FetchProjectId(project);*/
		
		/*int a =editModule.EditModule(newModule,id,projectId);
		if(a>0)
		{*/
		request.setAttribute("module", li);
		request.getRequestDispatcher("editmodule.jsp").forward(request, response);
		}
		
		if(submit2 != null){
			try {
				editModule.deleteModule(module);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("message","Module Deleted");
			request.getRequestDispatcher("viewmodule.jsp").forward(request, response);
		}
	/*	}
		else
		{
			
				response.sendRedirect("editmodule.jsp?msg1=Failed to save changes !!");
						
		}
		
	}
*/
}
}