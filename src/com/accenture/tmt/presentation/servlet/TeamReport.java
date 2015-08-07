package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.common.CONSTANTS;

import com.accenture.tmt.dao.dto.TeamReportFlatDTO;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.TeamReportDTO;

/**
 * Servlet implementation class TeamReport
 */
	public class TeamReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamReport() {
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
		
		String teamName = request.getParameter("Team");
		String startDate = request.getParameter(CONSTANTS.GET_START_DATE_FOR_TEAM_REPORT);
		String endDate = request.getParameter(CONSTANTS.GET_END_DATE_FOR_TEAM_REPORT);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		String action = request.getParameter("action");
		// SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
		 Date startDate1 = null;
	     
		 Date endDate1 = null;
		 java.sql.Date sqlStart=null;
		 java.sql.Date sqlEnd = null;
		 try {
			startDate1 =   df.parse(startDate);
			 sqlStart = new java.sql.Date(startDate1.getTime());
		 } catch (ParseException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} 
			 try {
				endDate1 =  df.parse(endDate);
				 sqlEnd = new java.sql.Date(endDate1.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 TeamReportDTO teamReportDTO = new TeamReportDTO();
			 teamReportDTO.setTeamName(teamName);
			 teamReportDTO.setStartDate(sqlStart);
			 teamReportDTO.setEndDate(sqlEnd);
			 teamReportDTO.setAction(action);
			 
			 if((teamName == null || teamName == "") && (startDate1 == null )&& (endDate1 == null)
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutAnything(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 
			 else if( (startDate1 == null )&& (endDate1 == null)
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyTeamName(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 
			 else if((teamName == null || teamName == "") && (endDate1 == null)
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyStartDate(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((teamName == null || teamName == "") && (startDate1 == null )
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyEndDate(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  } 
			 else if((teamName == null || teamName == "") && (startDate1 == null )&& (endDate1 == null)
						){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyaction(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  } 
			 else if((endDate1 == null)
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutEndDate(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((startDate1 == null )
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutStartDate(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if( (startDate1 == null )&& (endDate1 == null)
						){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyTeamName_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((teamName == null || teamName == "") 
						&& (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutTeamName(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((teamName == null || teamName == "") &&  (endDate1 == null)
						){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyStartDate_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((teamName == null || teamName == "") && (startDate1 == null )){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithOnlyEndDate_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if( (action==null || action =="")){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReport(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if( (startDate1 == null )
						){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutStartDate_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((endDate1 == null)
						){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutEndDate_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else if((teamName == null || teamName == "") ){
					TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReportWithoutTeamName_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
			  }
			 else{
				 TeamReportController fetch = new TeamReportController();
					List<TeamReportFlatDTO> teamReportList = new ArrayList<TeamReportFlatDTO>();
					
					teamReportList = fetch.teamReport_with_action(teamReportDTO);
					request.setAttribute("TeamReportList", teamReportList);
					if(teamReportList.isEmpty()){
						response.sendRedirect("teamreportdisplay.jsp? msg=Details are not found.");
					}
					else{
					request.getRequestDispatcher("teamreportdisplay.jsp").forward(request, response);
					}
				 
			 }
	}
}
	