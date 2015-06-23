package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ModuleController;



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
		String modulename = request.getParameter("modulename");
		String project = request.getParameter("project");
		String moduledesc = request.getParameter("moduledesc");
		String moduleid = request.getParameter("moduleid");
		
		ModuleController edit = new ModuleController();
		int a = edit.editModule(modulename, project, moduledesc, moduleid);
if(a!=0)
{request.setAttribute("message","Module Updated");
request.getRequestDispatcher("viewmodule.jsp").forward(request, response);
	}
if (a==0)
{
	request.setAttribute("message","Module not Updated");
	request.getRequestDispatcher("viewmodule.jsp").forward(request, response);
	}
}
}