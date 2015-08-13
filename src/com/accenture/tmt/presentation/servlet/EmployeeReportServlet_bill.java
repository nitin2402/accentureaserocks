package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.dao.dto.EmployeeReportDetailsFlatDTO;
import com.accenture.tmt.manager.ReportController;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class EmployeeReportServlet_bill
 */
public class EmployeeReportServlet_bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReportServlet_bill() {
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
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String action = request.getParameter("action");
		String designation = request.getParameter("desg");
		String bill = request.getParameter("bill");
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate1 = null;

		Date endDate1 = null;
		java.sql.Date sqlStart = null;
		java.sql.Date sqlEnd = null;
		java.sql.Date sqlDate=null;
		
		if(startdate==null || startdate ==""){
			String year = "2003";
			String month = "12";
			String day = "01"; 
			    String date = month + "/" + day + "/" +year ;

			    try {
					startDate1 = df.parse(date);
				    sqlStart = new java.sql.Date(startDate1.getTime());
				    
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}else{
			
			try {
				startDate1 = df.parse(startdate);
				sqlStart = new java.sql.Date(startDate1.getTime());
			
			} catch (ParseException | java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(enddate==null || enddate ==""){
		
			Date date = new Date();
			 try {
				String timestamp= df.format(date);
				 endDate1=df.parse(timestamp);
	
				 sqlDate= new java.sql.Date(date.getTime()+ 1 * 24 * 60 * 60 * 1000);
				 
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else{
			try {
				endDate1 = df.parse(enddate);
				sqlDate = new java.sql.Date(endDate1.getTime());
			} catch (ParseException | java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		ReportDetailsDTO empreports = new ReportDetailsDTO();
	
		ReportController fetch=new ReportController();
		List<EmployeeReportDetailsFlatDTO> empreportlist = new ArrayList<EmployeeReportDetailsFlatDTO>();
		empreports.setAction(action);
		empreports.setStartDate(sqlStart);
		empreports.setEndDate(sqlDate);
		empreports.setDesignation(designation);
		empreports.setBill(bill);
		empreportlist=fetch.employeeReports_ALLpresent(empreports);
	
		
		request.setAttribute("EmpList", empreportlist);
		if(empreportlist.isEmpty()){
			response.sendRedirect("employeereports.jsp?msg=Details are not found.");
		}
		else{
			request.getRequestDispatcher("employeereports.jsp").forward(request, response);
		}
		
	
	}

}
