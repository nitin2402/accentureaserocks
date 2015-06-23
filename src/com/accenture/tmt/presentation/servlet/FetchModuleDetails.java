package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;


/**
 * Servlet implementation class FetchModuleDetails
 */
public class FetchModuleDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchModuleDetails() {
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
		List<ModuleFormDTO> li = new ArrayList<ModuleFormDTO>();
		ModuleController fetch = new ModuleController();
		li = fetch.fetchModuleDetails();
		//System.out.println(li);
		//System.out.println(li.getItem(0));	
	String	exp = " <form action=\"EditModule\"><div id=\"scrollable\"><table class= \"table1\" border=\"1\" ><tr style=\"font-weight:bold\"><td></td><td>Module Name</td><td>Project Name</td><td>Module ID</td><td>Module Description</td></tr>";

		for (int i = 0; i < li.size(); i++) {
			exp += "<tr><td><input type=\"radio\" name=\"moduleedit\" value=\""+li.get(i).getModuleName()+"\"></td><td>" + li.get(i).getModuleName()
					+ "</td>";
			exp += "<td>" + li.get(i).getProjectId() + "</td>" + "<td>"
					+ li.get(i).getModuleId() + "</td>" + "<td>"
					+ li.get(i).getModuleDescription() + "</td>";
			
			exp += "</tr>";
		}
		exp += "</table></div><input type=\"submit\" value=\"Edit\">";
		request.setAttribute("module", exp);
	}

}
