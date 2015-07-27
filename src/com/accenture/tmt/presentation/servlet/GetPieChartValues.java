package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

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
      
		String project = request.getParameter("projectId");
		System.out.println(project);
		PieChartDTO pieDTO = new PieChartDTO();
		pieDTO.setProject(project);
		EmployeeController getEmpDetails = new EmployeeController();
		List<pieCount> piechartlist= new ArrayList<pieCount>();
		String pielist=null;
		piechartlist=getEmpDetails.fetchPieDetails(pieDTO);
		
	
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		json.put("ASE",piechartlist.get(0).getASE());
		json.put("SE",piechartlist.get(0).getSE());
		json.put("SSE",piechartlist.get(0).getSSE());
		json.put("TL",piechartlist.get(0).getTL());
		json.put("AM",piechartlist.get(0).getAM());
		json.put("M",piechartlist.get(0).getM());
		json.put("total",piechartlist.get(0).getCount());
		json.put("billable",piechartlist.get(0).getBillable());
		
		json.put("p0",piechartlist.get(0).getP0());
		json.put("p1",piechartlist.get(0).getP1());
		json.put("p2",piechartlist.get(0).getP2());
		json.put("p3",piechartlist.get(0).getP3());
		json.put("p4",piechartlist.get(0).getP4());
		
		json.put("angularJS",piechartlist.get(0).getAngularJS());
		
		json.put("AT",piechartlist.get(0).getAT());
		json.put("C_UNIX",piechartlist.get(0).getC_UNIX());
		json.put("FST",piechartlist.get(0).getFST());
		json.put("HTML",piechartlist.get(0).getHTML());
		json.put("java",piechartlist.get(0).getJava());
		json.put("JSP",piechartlist.get(0).getJSP());
		json.put("QA",piechartlist.get(0).getQA());
		json.put("name", piechartlist.get(0).getName());
		out.print(json);
		//request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		
	}

}
