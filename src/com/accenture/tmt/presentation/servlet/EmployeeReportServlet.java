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

import com.accenture.tmt.dao.dto.ReportsDetailsFlatDTO;
import com.accenture.tmt.manager.ReportController;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Servlet implementation class ReportServlet
 */
public class EmployeeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReportServlet() {
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
		
		
		String S1 = request.getParameter("startdate");
		String S2 = request.getParameter("enddate");
		String S3 = request.getParameter("status");
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		 Date startDate1 = null;
	     
		 Date endDate1 = null;
		 java.sql.Date sqlStart=null;
		 java.sql.Date sqlEnd = null;
		 if(S1 != null ||  S1 != ""){
			 try {
					startDate1 =   df.parse(S1);
					 sqlStart= new java.sql.Date(startDate1.getTime());
				 } catch (ParseException e) {
					 //TODO Auto-generated catch block
					e.printStackTrace();
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		 }
		 
		 if(S2 != null ||  S2 != ""){
		 try {
				endDate1 =  df.parse(S2);
				 sqlEnd= new java.sql.Date(endDate1.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		ReportDetailsDTO teamreportdto = new ReportDetailsDTO();
		teamreportdto.setStatus(S3);
		teamreportdto.setStartDate(sqlStart);
		teamreportdto.setEndDate(sqlEnd);
		
		if((S3 == null || S3 == "") && (startDate1 == null )){
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist = fetch.reportTeamWithOnlyEndDate(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
					response.sendRedirect("employeereports.jsp?msg=Details are not found.");
				}
				else{
					request.getRequestDispatcher("employeereports.jsp").forward(request, response);
				}
		
		}
		else if((startDate1 == null ) && (endDate1 == null )){
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist = fetch.reportTeamWithOnlyTeamName(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
			response.sendRedirect("employeereports.jsp?msg=Details are not found.");
		}
		else{
			request.getRequestDispatcher("employeereports.jsp").forward(request, response);
		}
		}
		else if((S3 == null || S3 == "") && (endDate1 == null )){
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist  = fetch.reportTeamWithOnlyStartDate(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
				response.sendRedirect(".jsp?msg=Details are not found.");
			}
			else{
				request.getRequestDispatcher("employeereports.jsp").forward(request, response);
			}

	}
		else if(S3 == null || S3 == ""){	
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist = fetch.reportTeamWithoutTeamName(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
				response.sendRedirect("employeereports.jsp?msg=Details are not found.");
			}
			else{
				request.getRequestDispatcher("employeereports.jsp").forward(request, response);
			}
			}
		else if(startDate1 == null ){
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist = fetch.reportTeamWithoutStartDate(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
				response.sendRedirect("employeereports.jsp?msg=Details are not found.");
			}
			else{
				request.getRequestDispatcher("employeereports.jsp").forward(request, response);
			}
			
		}
		else if(endDate1 == null){
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist = fetch.reportTeamWithoutEndDate(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
				response.sendRedirect("employeereports.jsp?msg=Details are not found.");
			}
			else{
				request.getRequestDispatcher("employeereports.jsp").forward(request, response);
			}
		}
		else{
			
			ReportController fetch = new ReportController();
			List<ReportsDetailsFlatDTO> teamreportlist = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportlist = fetch.reportTeam(teamreportdto);
			request.setAttribute("ReportList", teamreportlist);
			if(teamreportlist.isEmpty()){
				response.sendRedirect("employeereports.jsp?msg=Details are not found.");
			}
			else{
				request.getRequestDispatcher("employeereports.jsp").forward(request, response);
			}
		}

	}
}




