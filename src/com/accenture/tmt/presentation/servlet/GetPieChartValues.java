package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.pieCount;
import com.accenture.tmt.manager.EmployeeController;
import com.accenture.tmt.presentation.dto.PieChartDTO;

/**
 * Servlet implementation class GetPieChartValues
 */

public class GetPieChartValues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPieChartValues() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		String project = request.getParameter("");
		PieChartDTO pieDTO = new PieChartDTO();
		pieDTO.setProject(project);
		EmployeeController getEmpDetails = new EmployeeController();
		List<pieCount> piechartlist= new ArrayList<pieCount>();
		String pielist=null;
		piechartlist=getEmpDetails.fetchPieDetails(pieDTO);
		
		request.setAttribute("pielist", piechartlist);
		//request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		
	}

}
