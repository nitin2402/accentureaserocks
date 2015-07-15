package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ProjectController;
import com.accenture.tmt.presentation.dto.ProjectDTO;

/**
 * Servlet implementation class EditCurrent
 */
public class EditCurrent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCurrent() {
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
		
		String currentrelease = request.getParameter("CurrentRelease");
		String projectname = request.getParameter("ProjectName");
		String releaseDate = request.getParameter("ReleaseDate");
		
		ProjectController controller = new ProjectController();
		int a = controller.EditCurrent(currentrelease, projectname, releaseDate);
		
		if(a!=0){
			
		request.setAttribute("message","Record Updated");
		request.getRequestDispatcher("ProjectAdmin.jsp").forward(request, response);
		}
		
		if(a==0){
			
			request.setAttribute("message","Record not updated");
			request.getRequestDispatcher("ProjectAdmin.jsp").forward(request, response);
		}
	
		
	}

}
