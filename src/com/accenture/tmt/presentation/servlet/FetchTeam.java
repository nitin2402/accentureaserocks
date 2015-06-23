package com.accenture.tmt.presentation.servlet;


import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.accenture.tmt.manager.TeamController;


/**
 * Servlet implementation class FetchModule
 */
public class FetchTeam extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchTeam() {
    	
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
		
	//	System.out.println("Hi Im FetchTeam Servlet");
	
		
	String module =	request.getParameter("moduleName");
	
	List<String> li = new ArrayList<String>();
	
	TeamController fetch = new TeamController();
	li = fetch.fetchTeam(module);
	//System.out.println(li);
	//System.out.println(li.get(1));
	PrintWriter out = response.getWriter();     

	out.print(li);

	}

}
