package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.WorkplanFlatDTO;

public class WorkplanDAO {
	
	public int insertRequest(WorkplanFlatDTO workplanflatdto){
		
		int status_id = 1;
		int flag = 0;
		String teamId = workplanflatdto.getTeamId() ;
		
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.INSERT_REQUEST_QUERY);
				st.setString(1, workplanflatdto.getReqId());
				 st.setString(2, teamId);
				 st.setInt(3, workplanflatdto.getnASE());
				 st.setInt(4, workplanflatdto.getnSE());
				 st.setInt(5, workplanflatdto.getnSSE());
				 st.setString(6, workplanflatdto.getComment());
				 st.setInt(7, status_id);
				 
				 flag = st.executeUpdate();
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	public String fetchTeamId(String userName) {
		// TODO Auto-generated method stub
		String teamId = null;
        ResultSet rs = null ;
		
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
					  .prepareStatement(CONSTANTS.GET_TEAMID_QUERY);
					  st.setString(1, userName);
					  rs = st.executeQuery();
					  while(rs.next()){
						  teamId = rs.getString("TeamId");
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamId;
	}
	
	public int countRows(){
		
		int number_of_rows = 0 ;
		 ResultSet rs = null ;
			
			try {
				Connection con = DBConnection.getConnection();
				if (con != null) {
					PreparedStatement st = con
						  .prepareStatement(CONSTANTS.GET_LASTREQID_QUERY);
						  rs = st.executeQuery();
						  while(rs.next()){
							  number_of_rows = rs.getInt("NumberOfRows");
						  
					 }
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return number_of_rows;
		
	}

}
