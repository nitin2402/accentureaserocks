package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.SearchRequestFlatDTO;

public class SearchRequestDAO {
	
	public List<SearchRequestFlatDTO> getApprovedRequests(){
		
		List<SearchRequestFlatDTO> list = new ArrayList<SearchRequestFlatDTO>();
		ResultSet rs = null ;
		Connection con;
		try {
			con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st;
					st = con
							.prepareStatement(CONSTANTS.GET_APPROVED_REQUESTS_QUERY);
				
				rs = st.executeQuery();
				while(rs.next()){
					SearchRequestFlatDTO dto = new SearchRequestFlatDTO();
					dto.setReqId(rs.getString("ReqId"));
					dto.setnASE(rs.getInt("No_Of_ASE"));
					dto.setnSE(rs.getInt("No_Of_SE"));
					dto.setnSSE(rs.getInt("No_Of_SSE"));
					dto.setComment(rs.getString("Comments"));
					dto.setStatusName(rs.getString("StatusName"));
					dto.setTeamName(rs.getString("TeamName"));
					dto.setHasSpecificRequest(rs.getBoolean("SpecificReq"));
					
					list.add(dto);
					}
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
			
	}
	
	public List<SearchRequestFlatDTO> getUnapprovedRequests(){
		
		List<SearchRequestFlatDTO> list = new ArrayList<SearchRequestFlatDTO>();
		ResultSet rs = null ;
		Connection con;
		try {
			con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st;
					st = con
							.prepareStatement(CONSTANTS.GET_UNAPPROVED_REQUESTS_QUERY);
				
				rs = st.executeQuery();
				while(rs.next()){
					SearchRequestFlatDTO dto = new SearchRequestFlatDTO();
					dto.setReqId(rs.getString("ReqId"));
					dto.setnASE(rs.getInt("No_Of_ASE"));
					dto.setnSE(rs.getInt("No_Of_SE"));
					dto.setnSSE(rs.getInt("No_Of_SSE"));
					dto.setComment(rs.getString("Comments"));
					dto.setStatusName(rs.getString("StatusName"));
					dto.setTeamName(rs.getString("TeamName"));
					dto.setHasSpecificRequest(rs.getBoolean("SpecificReq"));
		
					list.add(dto);
					}
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
			
	}

}
