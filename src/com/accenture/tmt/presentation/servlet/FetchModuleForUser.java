package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ModuleController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;

/**
 * Servlet implementation class FetchModuleForUser
 */

public class FetchModuleForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchModuleForUser() {
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
		request.setAttribute("ModuleList", li);
		//System.out.println(li);
		//System.out.println(li.getItem(0));	
	
		
		/*exp += "</table></div><input type=\"submit\" name=\"submit1\" value=\"Edit\"><input type=\"submit\" name=\"submit2\" value=\"Delete\">";
		request.setAttribute("module", exp);*/
	}

}
