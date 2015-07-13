package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.common.ValidateObjects;
import com.accenture.tmt.dao.dto.ModuleReportFlatDTO;
import com.accenture.tmt.dao.dto.ReportsDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.ModuleReportDTO;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;
import com.sun.jmx.snmp.Timestamp;

public class EmlpoyeeReportDAO {
public List<String> getTeamList(){
		
		List<String> teamList = new ArrayList<String>();
		ResultSet rs = null ;
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
					  .prepareStatement(CONSTANTS.GET_MODULE_LIST_QUERY);
				rs = st.executeQuery();
				while(rs.next()){
					teamList.add(rs.getString("ModuleName"));
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamList;
		
	}
public List<ReportsDetailsFlatDTO> getDetailsReportDAO(ReportDetailsDTO teamreportdto){
	List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
	ReportsDetailsFlatDTO teamList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_QUERY);
			    st1.setString(1, teamreportdto.getStatus());
			    st1.setDate(2, (Date)teamreportdto.getStartDate());
			    st1.setDate(3, (Date)teamreportdto.getEndDate());
			    rs = st1.executeQuery();
			    System.out.println("hello");
			    while(rs.next()) {
			    	System.out.println(rs.getString("ReqId"));
			    	teamList = new ReportsDetailsFlatDTO();  
			    	teamList.setReqId(rs.getString("ReqId"));
			    	teamList.setTeamName(rs.getString("teamName"));
					teamList.setnASE(rs.getInt("No_Of_ASE"));
					teamList.setnSE(rs.getInt("No_Of_SE"));
					teamList.setnSSE(rs.getInt("No_Of_SSE"));
					teamList.setComment(rs.getString("Comments"));
					teamList.setStatusName(rs.getString("StatusName"));
					teamList.setEmpId(rs.getString("EmployeeId"));
					teamList.setEmpName(rs.getString("EmployeeName"));
					teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
					teamreportflatdto.add(teamList);
			    }

			    System.out.println("bye");
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return teamreportflatdto;
}
	public List<ReportsDetailsFlatDTO> getDetailsWithoutTeamNameDAO(ReportDetailsDTO teamreportdto){
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		ReportsDetailsFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.REPORT);
				    System.out.println(teamreportdto.getStartDate());
				    st1.setDate(1, (Date) (teamreportdto.getStartDate()));
				    st1.setDate(2, (Date) (teamreportdto.getEndDate()));
				    rs = st1.executeQuery();
				
				    if (rs.next() == true) {
				    	teamList = new ReportsDetailsFlatDTO();  
				    	teamList.setReqId(rs.getString("ReqId"));
				    	teamList.setTeamName(rs.getString("teamName"));
						teamList.setnASE(rs.getInt("No_Of_ASE"));
						teamList.setnSE(rs.getInt("No_Of_SE"));
						teamList.setnSSE(rs.getInt("No_Of_SSE"));
						teamList.setComment(rs.getString("Comments"));
						teamList.setStatusName(rs.getString("StatusName"));
						teamList.setEmpId(rs.getString("EmployeeId"));
						teamList.setEmpName(rs.getString("EmployeeName"));
						teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
						teamreportflatdto.add(teamList);
				    	}
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamreportflatdto;
	}
	public List<ReportsDetailsFlatDTO> getDetailsWithoutStartDateDAO(ReportDetailsDTO teamreportdto){
		
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		ReportsDetailsFlatDTO teamList = null;
	         try {
				ResultSet rs = null;
				 Connection con = DBConnection.getConnection();
					if(con != null){
					    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_WITHOUT_START_DATE_QUERY);
					    st1.setString(1, teamreportdto.getStatus());
					    st1.setDate(2, (Date) teamreportdto.getEndDate());
					    rs = st1.executeQuery();
					    while (rs.next() == true) {
					    	teamList = new ReportsDetailsFlatDTO();  
					    	teamList.setReqId(rs.getString("ReqId"));
					    	teamList.setTeamName(rs.getString("teamName"));
							teamList.setnASE(rs.getInt("No_Of_ASE"));
							teamList.setnSE(rs.getInt("No_Of_SE"));
							teamList.setnSSE(rs.getInt("No_Of_SSE"));
							teamList.setComment(rs.getString("Comments"));
							teamList.setStatusName(rs.getString("StatusName"));
							teamList.setEmpId(rs.getString("EmployeeId"));
							teamList.setEmpName(rs.getString("EmployeeName"));
							teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
							teamreportflatdto.add(teamList);
					    	}
					    con.close();
						}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return teamreportflatdto;

	}
	public List<ReportsDetailsFlatDTO> getDetailsWithoutEndDateDAO(ReportDetailsDTO teamreportdto){
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		ReportsDetailsFlatDTO teamList = null;
	    try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_WITHOUT_END_DATE_QUERY);
				    st1.setString(1, teamreportdto.getStatus());
				    st1.setDate(2, (Date) teamreportdto.getStartDate());
				    rs = st1.executeQuery();
				    while(rs.next() == true) {
				    	teamList = new ReportsDetailsFlatDTO();  
				    	teamList.setReqId(rs.getString("ReqId"));
				    	teamList.setTeamName(rs.getString("teamName"));
						teamList.setnASE(rs.getInt("No_Of_ASE"));
						teamList.setnSE(rs.getInt("No_Of_SE"));
						teamList.setnSSE(rs.getInt("No_Of_SSE"));
						teamList.setComment(rs.getString("Comments"));
						teamList.setStatusName(rs.getString("StatusName"));
						teamList.setEmpId(rs.getString("EmployeeId"));
						teamList.setEmpName(rs.getString("EmployeeName"));
						teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
						teamreportflatdto.add(teamList);
				    }
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return teamreportflatdto;

	}
	    public List<ReportsDetailsFlatDTO> getDetailsWithOnlyStartDateDAO(ReportDetailsDTO teamreportdto){
	    	List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
	    	ReportsDetailsFlatDTO teamList = null;
	        try {
	    		ResultSet rs = null;
	    		 Connection con = DBConnection.getConnection();
	    			if(con != null){
	    			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_WITH_ONLY_START_DATE_QUERY);
	    			    st1.setDate(1, (Date) teamreportdto.getStartDate());
	    			    rs = st1.executeQuery();
	    			    while (rs.next() == true) {
	    			    teamList = new ReportsDetailsFlatDTO(); 
				    	teamList.setReqId(rs.getString("ReqId"));
				    	teamList.setTeamName(rs.getString("teamName"));
						teamList.setnASE(rs.getInt("No_Of_ASE"));
						teamList.setnSE(rs.getInt("No_Of_SE"));
						teamList.setnSSE(rs.getInt("No_Of_SSE"));
						teamList.setComment(rs.getString("Comments"));
						teamList.setStatusName(rs.getString("StatusName"));
						teamList.setEmpId(rs.getString("EmployeeId"));
						teamList.setEmpName(rs.getString("EmployeeName"));
						teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
						teamreportflatdto.add(teamList);
	    			    }
	    			    con.close();
	    				}
	    	} catch (ClassNotFoundException | SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        return teamreportflatdto;
	    }
	    public List<ReportsDetailsFlatDTO> getDetailsWithOnlyTeamNameDAO(ReportDetailsDTO teamreportdto){
	    	List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
	    	ReportsDetailsFlatDTO teamList = null;
	        try {
	    		ResultSet rs = null;
	    		 Connection con = DBConnection.getConnection();
	    			if(con != null){
	    			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY);
	    			    st1.setString(1, teamreportdto.getStatus());
	    			    rs = st1.executeQuery();
	    			    while (rs.next() == true) {
	    			    	teamList = new ReportsDetailsFlatDTO(); 
					    	teamList.setReqId(rs.getString("ReqId"));
					    	teamList.setTeamName(rs.getString("teamName"));
							teamList.setnASE(rs.getInt("No_Of_ASE"));
							teamList.setnSE(rs.getInt("No_Of_SE"));
							teamList.setnSSE(rs.getInt("No_Of_SSE"));
							teamList.setComment(rs.getString("Comments"));
							teamList.setStatusName(rs.getString("StatusName"));
							teamList.setEmpId(rs.getString("EmployeeId"));
							teamList.setEmpName(rs.getString("EmployeeName"));
							teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
							teamreportflatdto.add(teamList);
	    			    }
	    			    con.close();
	    				}
	    	} catch (ClassNotFoundException | SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        return teamreportflatdto;
	    }
	    public List<ReportsDetailsFlatDTO> getDetailsWithOnlyEndDateDAO(ReportDetailsDTO teamreportdto){
	    	List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
	    	ReportsDetailsFlatDTO teamList = null;
	        try {
	    		ResultSet rs = null;
	    		 Connection con = DBConnection.getConnection();
	    			if(con != null){
	    			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_WITH_ONLY_END_DATE_QUERY);
	    			    st1.setDate(1, (Date)teamreportdto.getEndDate());
	    			    rs = st1.executeQuery();
	    			    while (rs.next() == true) {
	    			    	teamList = new ReportsDetailsFlatDTO(); 
					    	teamList.setReqId(rs.getString("ReqId"));
					    	teamList.setTeamName(rs.getString("teamName"));
							teamList.setnASE(rs.getInt("No_Of_ASE"));
							teamList.setnSE(rs.getInt("No_Of_SE"));
							teamList.setnSSE(rs.getInt("No_Of_SSE"));
							teamList.setComment(rs.getString("Comments"));
							teamList.setStatusName(rs.getString("StatusName"));
							teamList.setEmpId(rs.getString("EmployeeId"));
							teamList.setEmpName(rs.getString("EmployeeName"));
							teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
							teamreportflatdto.add(teamList);
	    			    }
	    			    con.close();
	    				}
	    	} catch (ClassNotFoundException | SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        return teamreportflatdto;
	    	
	    }
	    public List<ReportsDetailsFlatDTO> getDetailsWithOnlyModuleNameDAO(ModuleReportDTO modulereportdto){
	    	List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
	    	ReportsDetailsFlatDTO teamList = null;
	        try {
	    		ResultSet rs = null;
	    		 Connection con = DBConnection.getConnection();
	    			if(con != null){
	    			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_TEAM_REPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY);
	    			    st1.setString(1, modulereportdto.getModuleName());
	    			    rs = st1.executeQuery();
	    			    while (rs.next() == true) {
	    			    	teamList = new ReportsDetailsFlatDTO(); 
					    	teamList.setReqId(rs.getString("ReqId"));
					    	teamList.setTeamName(rs.getString("teamName"));
							teamList.setnASE(rs.getInt("No_Of_ASE"));
							teamList.setnSE(rs.getInt("No_Of_SE"));
							teamList.setnSSE(rs.getInt("No_Of_SSE"));
							teamList.setComment(rs.getString("Comments"));
							teamList.setStatusName(rs.getString("StatusName"));
							teamList.setEmpId(rs.getString("EmployeeId"));
							teamList.setEmpName(rs.getString("EmployeeName"));
							teamList.setTimestamp(rs.getTimestamp("TimeStamp").toString());
							teamreportflatdto.add(teamList);
	    			    }
	    			    con.close();
	    				}
	    	} catch (ClassNotFoundException | SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	        return teamreportflatdto;
	    }
	    }
	 



