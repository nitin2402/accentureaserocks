package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.ActionFlatDTO;

public class ActionDAO {
	
	public int reject(ActionFlatDTO actionflatdto) {
		
int flag = 0;
		
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.REJECT_REQUEST_QUERY);
				st.setString(1, actionflatdto.getReason());
				st.setString(2, actionflatdto.getReqId());
				 flag = st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public int onHold(ActionFlatDTO actionflatdto) {
		
		int flag = 0;
				
				try {
					Connection con = DBConnection.getConnection();
					if (con != null) {
						PreparedStatement st = con
								.prepareStatement(CONSTANTS.ONHOLD_REQUEST_QUERY);
						st.setString(1, actionflatdto.getReason());
						st.setString(2, actionflatdto.getReqId());
						 flag = st.executeUpdate();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return flag;
			}

	public int accept(String[] empNamesASE, String[] empNamesSE,
			String[] empNamesSSE, String sepcificReqEmployeeId, ActionFlatDTO actionflatdto) {
		
		int flag1 = 0;
		int flag2 = 0;
		ResultSet rs = null ;
		String teamId = null ;
		
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con.
						prepareStatement(CONSTANTS.REQUEST_TEAMID_QUERY);
				 st.setString(1, actionflatdto.getReqId());
				 rs = st.executeQuery() ;
				 while(rs.next()){
					 teamId = rs.getString("TeamId");
				 }
				 
				 if(sepcificReqEmployeeId != null){
					 st = con.prepareStatement(CONSTANTS.ASSIGN_RESOURCE_QUERY);
					 st.setString(1, teamId);
					 st.setString(2, sepcificReqEmployeeId);
					 flag2 = st.executeUpdate();
					 flag2 = flag2 & flag2 ;
				 }
				 
				 if(empNamesASE != null){
				 for(int i=0; i < empNamesASE.length ; i++){
					 
					 st = con.prepareStatement(CONSTANTS.ASSIGN_RESOURCE_QUERY);
					 st.setString(1, teamId);
					 st.setString(2, empNamesASE[i]);
					 flag2 = st.executeUpdate();
					 flag2 = flag2 & flag2 ;
				 }
				 }
				 
				 if(empNamesSE != null){
				 for(int i=0; i < empNamesSE.length ; i++){
					 
					 st = con.prepareStatement(CONSTANTS.ASSIGN_RESOURCE_QUERY);
					 st.setString(1, teamId);
					 st.setString(2, empNamesSE[i]);
					 flag2 = st.executeUpdate();
					 flag2 = flag2 & flag2 ;
				 }
				 }
				 
				 if(empNamesSSE != null){
				 for(int i=0; i < empNamesSSE.length ; i++){
					 
					 st = con.prepareStatement(CONSTANTS.ASSIGN_RESOURCE_QUERY);
					 st.setString(1, teamId);
					 st.setString(2, empNamesSSE[i]);
					 flag2 = st.executeUpdate();
					 flag2 = flag2 & flag2 ;
				 }
				 }
				 
				 if(flag2 != 0){
				 st = con
							.prepareStatement(CONSTANTS.ACCEPT_REQUEST_QUERY);
					st.setString(1, actionflatdto.getReason());
					st.setString(2, actionflatdto.getReqId());
					 flag1 = st.executeUpdate();
				 }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (flag1 & flag2);
	}
	
}
