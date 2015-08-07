package com.accenture.tmt.presentation.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.tmt.dao.dto.TeamDetailsDTO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.manager.TeamController;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;



/**
 * Servlet implementation class EditTeam
 */
public class EditTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeam() {
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
		String submit1=request.getParameter("submit1");
		String submit2=request.getParameter("submit2");
		String team = request.getParameter("teamedit");
		TeamController teamoperation = new TeamController();
		HttpSession session1 = request.getSession();
		java.sql.Date sqlDate=null;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		 String timestamp= df.format(date);
		 sqlDate= new java.sql.Date(date.getTime());
		if(team==null){
			request.setAttribute("message","Please select the radio button");
			request.getRequestDispatcher("viewteam.jsp").forward(request, response);	
		}
		if(submit1!=null){
		List<TeamDetailsFlatDTO> li = new ArrayList<TeamDetailsFlatDTO>();
		
		li = teamoperation.FetchTeamDetails(team);
		request.setAttribute("team", li);
		request.getRequestDispatcher("editteam.jsp").forward(request, response);
	}
	
	if(submit2!=null){
		TeamReportUpdateDTO reportupdatedto = new TeamReportUpdateDTO();
		TeamReportController update=new TeamReportController();
	
		try {
			List<TeamDetailsFlatDTO> li = new ArrayList<TeamDetailsFlatDTO>();
			li = teamoperation.FetchTeamDetails(team);
			int status= teamoperation.deleteTeam(team);
			if(status==1){
				request.setAttribute("message","Team Deleted and Employees Are Set To Free !!!");
				if(session1!= null){
					for(int i =0;i<li.size();i++){
					reportupdatedto.setModuleId(li.get(i).getModuleId());
					reportupdatedto.setTeamId(team);
					reportupdatedto.setTeamName(li.get(i).getTeamName());
					reportupdatedto.setTeamDescription(li.get(i).getTeamDescription());
					reportupdatedto.setUsername((String)session1.getAttribute("user"));
					reportupdatedto.setAction("deleted");
					reportupdatedto.setTimestamp(timestamp);
					reportupdatedto.setDate(sqlDate);
					update.updateTeamReport(reportupdatedto);
					}}
			}else{
				request.setAttribute("message","DELETE FAILED!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	;
		request.getRequestDispatcher("viewteam.jsp").forward(request, response);
		
		
	}
	}

}
