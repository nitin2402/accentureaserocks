package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.WorkplanAdminFlatDTO;
import com.accenture.tmt.presentation.dto.ActionDTO;

public class WorkplanAdminDAO {
	
	
	public WorkplanAdminFlatDTO fetchData(ActionDTO actiondto){
		
		String teamId = null;
		WorkplanAdminFlatDTO workplanAdminFlatDTO = new WorkplanAdminFlatDTO();
        Map<String, List<String>> details = new HashMap<String, List<String>>();
		
		ResultSet rs = null ;
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.BUDGET_DETAILS_QUERY);
				rs = st.executeQuery();
				
				 while(rs.next()){
					 List<String> list = new ArrayList<String>();
					 list.add(rs.getString("Currency")) ;
					 list.add( String.valueOf(rs.getInt("Amount")));
					 
					 details.put(rs.getString("EmployeeDesignation"), list) ; 
			 }
				 
				 workplanAdminFlatDTO.setDetails(details);
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.BUDGET_REQUEST_DETAILS_QUERY);
				 st.setString(1, actiondto.getReqId());
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setAseRequested(rs.getInt("No_Of_ASE")); 
					 workplanAdminFlatDTO.setSeRequested(rs.getInt("No_Of_SE")); 
					 workplanAdminFlatDTO.setSseRequested(rs.getInt("No_Of_SSE")); 
			 }
				 
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.GET_REQUEST_TEAMID_QUERY);
				 st.setString(1, actiondto.getReqId());
				 rs = st.executeQuery();
				 while(rs.next()){
					 teamId = rs.getString("TeamId"); 
			 }
				 
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.COUNT_ASE_QUERY);
				 st.setString(1, teamId);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setCurrentASE(rs.getInt("CURRENT_ASE")); 
			 }
				 
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.COUNT_SE_QUERY);
				 st.setString(1, teamId);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setCurrentSE(rs.getInt("CURRENT_SE")); 
			 }
				 
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.COUNT_SSE_QUERY);
				 st.setString(1, teamId);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setCurrentSSE(rs.getInt("CURRENT_SSE")); 
			 }
				 
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.COUNT_TL_QUERY);
				 st.setString(1, teamId);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setCurrentTL(rs.getInt("CURRENT_TL")); 
			 }
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workplanAdminFlatDTO;
		
	}

}
