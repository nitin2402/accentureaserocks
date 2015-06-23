package com.accenture.tmt.presentation.servlet;


import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ProjectController;




/**
 * Servlet implementation class FetchModule
 */
public class FetchProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchProject() {
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
	List<String> li = new ArrayList<String>();
	ProjectController fetch = new ProjectController();
	li = fetch.fetchProject();
	//System.out.println(li);
	//System.out.println(li.getItem(0));
	
	request.setAttribute("project", li);
	//request.getRequestDispatcher("addemployee.jsp").forward(request, response);
	}

}
