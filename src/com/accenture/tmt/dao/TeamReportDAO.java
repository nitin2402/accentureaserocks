package com.accenture.tmt.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.TeamReportFlatDTO;
import com.accenture.tmt.presentation.dto.TeamReportDTO;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;

	
	public class TeamReportDAO {
	
		
		public void insertTeamReport(TeamReportUpdateDTO reportUpdateDTO){
				
					try {
						Connection con = DBConnection.getConnection();
						if(con != null){
							
						    PreparedStatement st1 = con.prepareStatement(CONSTANTS.INSERT_TEAM_REPORT_QUERY);
							    st1.setString(1,reportUpdateDTO.getTeamName());
							    st1.setString(2,reportUpdateDTO.getTeamId());
							    st1.setString(3,reportUpdateDTO.getModuleId());
							    st1.setString(4,reportUpdateDTO.getTeamDescription());
							    st1.setString(5,reportUpdateDTO.getUsername());
							    st1.setString(6,reportUpdateDTO.getAction());
							    st1.setString(7,reportUpdateDTO.getTimestamp());
							    st1.setDate(8,reportUpdateDTO.getDate());
							    
								  st1.executeUpdate();
						}
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}


		public List<TeamReportFlatDTO> getReportWithoutTeamName(TeamReportDTO teamReportDTO){
		
			List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
			TeamReportFlatDTO teamList = null;
	         	try {
	         		ResultSet rs = null;
	         		Connection con = DBConnection.getConnection();
					if(con != null){
					    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITHOUT_TEAM_NAME_QUERY);
					    st1.setDate(1,(Date)(teamReportDTO.getStartDate()));
					    
					    st1.setDate(2,(Date)(teamReportDTO.getEndDate()));
					    rs = st1.executeQuery();
					    while (rs.next() == true) {
					    	teamList = new TeamReportFlatDTO();
					    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
					    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
					    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
					    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
					    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
					    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
					    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
					    	teamReportFlatDTO.add(teamList);
					    }
					    con.close();
						}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return teamReportFlatDTO;
	}

		
	public List<TeamReportFlatDTO> getReportWithoutStartDate(TeamReportDTO teamReportDTO){
		
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		TeamReportFlatDTO teamList = null;
	         try {
				ResultSet rs = null;
				 Connection con = DBConnection.getConnection();
					if(con != null){
					    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAMREPORT_DETAIL_WITHOUT_START_DATE_QUERY);
					    st1.setString(1, teamReportDTO.getTeamName());
					    st1.setDate(2, (Date) teamReportDTO.getEndDate());
					    rs = st1.executeQuery();
					    while (rs.next() == true) {
					    	teamList = new TeamReportFlatDTO();  
					    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
					    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
					    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
					    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
					    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
					    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
					    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
					    	teamReportFlatDTO.add(teamList);
					    }
					    con.close();
						}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return teamReportFlatDTO;

	}
	public List<TeamReportFlatDTO> getReportWithoutEndDate(TeamReportDTO teamReportDTO){
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		TeamReportFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAMREPORT_DETAIL_WITHOUT_END_DATE_QUERY);
				    st1.setString(1, teamReportDTO.getTeamName());
				    st1.setDate(2, (Date) teamReportDTO.getStartDate());
				    rs = st1.executeQuery();
				    while(rs.next() == true) {
				    	teamList = new TeamReportFlatDTO();   
				    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
				    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
				    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
				    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
				    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
				    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
				    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
				    	teamReportFlatDTO.add(teamList);
				    }
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return 	teamReportFlatDTO;

	}

	public List<TeamReportFlatDTO> getReportWithOnlyEndDate(TeamReportDTO teamReportDTO){
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		TeamReportFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAMREPORT_DETAIL_WITH_ONLY_END_DATE_QUERY);
				    st1.setDate(1, (Date)teamReportDTO.getEndDate());
				    rs = st1.executeQuery();
				    while (rs.next() == true) {
				    	teamList = new TeamReportFlatDTO();  
				    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
				    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
				    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
				    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
				    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
				    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
				    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
				    	teamReportFlatDTO.add(teamList);
				    }
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamReportFlatDTO;
		
	}
	public List<TeamReportFlatDTO> getReportWithOnlyTeamName(TeamReportDTO teamReportDTO){
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		TeamReportFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAMREPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY);
				    st1.setString(1, teamReportDTO.getTeamName());
				    rs = st1.executeQuery();
				    while (rs.next() == true) {
				    	teamList = new TeamReportFlatDTO();
				    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
				    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
				    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
				    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
				    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
				    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
				    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
				    	teamReportFlatDTO.add(teamList);
				    }
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamReportFlatDTO;
	}
	
	
	public List<TeamReportFlatDTO> getReportWithOnlyStartDate(TeamReportDTO teamReportDTO){
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		TeamReportFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAMREPORT_DETAIL_WITH_ONLY_START_DATE_QUERY);
				    st1.setDate(1, (Date) teamReportDTO.getStartDate());
				    rs = st1.executeQuery();
				    while (rs.next() == true) {
				    	teamList = new TeamReportFlatDTO();  
				    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
				    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
				    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
				    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
				    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
				    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
				    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
				    	teamReportFlatDTO.add(teamList);
				    }
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamReportFlatDTO;
	}
	
	
	public List<TeamReportFlatDTO> getTeamReport(TeamReportDTO teamReportDTO){
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		TeamReportFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAMREPORT_DETAIL_QUERY);
				    st1.setString(1, teamReportDTO.getTeamName());
				    st1.setDate(2, (Date)teamReportDTO.getStartDate());
				    st1.setDate(3, (Date)teamReportDTO.getEndDate());
				    rs = st1.executeQuery();
				    while(rs.next() == true) {
				    	teamList = new TeamReportFlatDTO();  
				    	teamList.setTeamName(rs.getString(CONSTANTS.GET_TEAM_NAME));
				    	teamList.setTeamId(rs.getString(CONSTANTS.GET_TEAM_ID));
				    	teamList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
				    	teamList.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
				    	teamList.setUsername(rs.getString(CONSTANTS.GET_USER_NAME));
				    	teamList.setAction(rs.getString(CONSTANTS.GET_ACTION));
				    	teamList.setTimestamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
				    	teamReportFlatDTO.add(teamList);
				    }
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamReportFlatDTO;
	}
}