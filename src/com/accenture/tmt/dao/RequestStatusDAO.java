package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.RequestStatusFlatDTO;

public class RequestStatusDAO {

	public List<RequestStatusFlatDTO> viewStatus() {
		
		List<RequestStatusFlatDTO> requestStatus = new ArrayList<RequestStatusFlatDTO>();
		
		try {
			RequestStatusFlatDTO status = null;
			
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			
			String querry = "SELECT R.ReqId, R.TeamId, R.No_Of_ASE, R.No_Of_SE, R.No_Of_SSE, R.Comments, S.StatusName FROM RequestTable R INNER JOIN StatusTable S ON R.Status_ID= S.Status_ID";
			
			ResultSet rs = st.executeQuery(querry);
			
			while(rs.next())
			{
				status = new RequestStatusFlatDTO();
				status.setReqId(rs.getString("ReqId"));
				status.setTeamId(rs.getString("TeamId"));
				status.setNoOfASE(rs.getString("No_Of_ASE"));
				status.setNoOfSE(rs.getString("No_Of_SE"));
				status.setNoOfSSE(rs.getString("No_Of_SSE"));
				status.setComments(rs.getString("Comments"));
				status.setStatusName(rs.getString("StatusName"));
				
				requestStatus.add(status);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return requestStatus;
		
	}

}
