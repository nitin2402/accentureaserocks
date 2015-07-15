package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.WorkplanAdminFlatDTO;
import com.accenture.tmt.presentation.dto.ActionDTO;

public class WorkplanAdminDAO {
	
	
	public WorkplanAdminFlatDTO fetchData(ActionDTO actiondto){
		
		WorkplanAdminFlatDTO workplanAdminFlatDTO = new WorkplanAdminFlatDTO();
		Map<String, Float> freeASEList = new HashMap<String, Float>();
		Map<String, Float> freeSEList = new HashMap<String, Float>();
		Map<String, Float> freeSSEList = new HashMap<String, Float>();
		
		ResultSet rs = null ;
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st;
				st = con.prepareStatement(CONSTANTS.FREE_ASE_LIST_QUERY);
				rs = st.executeQuery();

				 while(rs.next()){
					 freeASEList.put(rs.getString("EmployeeName"), rs.getFloat("LCR"));
			 }
				
				 workplanAdminFlatDTO.setFreeASEList(freeASEList);
				 rs = null;
				 
				 st = con.prepareStatement(CONSTANTS.FREE_SE_LIST_QUERY);
					rs = st.executeQuery();
					
					 while(rs.next()){
						 freeSEList.put(rs.getString("EmployeeName"), rs.getFloat("LCR"));
				 }
					 
					 workplanAdminFlatDTO.setFreeSEList(freeSEList);
					 rs = null ;
					 st = con.prepareStatement(CONSTANTS.FREE_SSE_LIST_QUERY);
						rs = st.executeQuery();
						
						 while(rs.next()){
							 freeSSEList.put(rs.getString("EmployeeName"), rs.getFloat("LCR"));
					 }
						 
						 workplanAdminFlatDTO.setFreeSSEList(freeSSEList);
						 
						 rs = null ;
				 st = con.prepareStatement(CONSTANTS.BUDGET_REQUEST_DETAILS_QUERY);

				 st.setString(1, actiondto.getReqId());
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setAseRequested(rs.getInt("No_Of_ASE")); 
					 workplanAdminFlatDTO.setSeRequested(rs.getInt("No_Of_SE")); 
					 workplanAdminFlatDTO.setSseRequested(rs.getInt("No_Of_SSE")); 
			 }
				 
				 rs = null ;
				 st = con.prepareStatement(CONSTANTS.AVERAGE_LCR_QUERY);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setCurrentAvg(rs.getFloat("AVERAGE"));
				 }
				 
				 rs = null ;
				 st = con.prepareStatement(CONSTANTS.TOTAL_LCR_QUERY);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setTotal(rs.getFloat("TOTAL"));
				 }
				 
				 rs = null ;
				 st = con.prepareStatement(CONSTANTS.COUNT_BILLABLE_EMPLOYEE_QUERY);
				 rs = st.executeQuery();
				 while(rs.next()){
					 workplanAdminFlatDTO.setNumberOfEmployee(rs.getInt("NumberOfEmployee"));
				 }
				 
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workplanAdminFlatDTO;
		
	}

}
