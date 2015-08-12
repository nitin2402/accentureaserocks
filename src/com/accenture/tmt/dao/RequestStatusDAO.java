package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.RequestStatusFlatDTO;

public class RequestStatusDAO {

	public List<RequestStatusFlatDTO> viewStatus(String userName) {
		
		List<RequestStatusFlatDTO> requestStatus = new ArrayList<RequestStatusFlatDTO>();
		
		try {
			RequestStatusFlatDTO status = null;
			ResultSet rs = null ;
			
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					  .prepareStatement(CONSTANTS.REQUEST_STATUS_QUERY);
			
			st.setString(1, userName);
			rs = st.executeQuery();
			
			while(rs.next())
			{
				status = new RequestStatusFlatDTO();
				status.setReqId(rs.getString("ReqId"));
				status.setTeamName(rs.getString("TeamName"));
				status.setNoOfASE(rs.getString("No_Of_ASE"));
				status.setNoOfSE(rs.getString("No_Of_SE"));
				status.setNoOfSSE(rs.getString("No_Of_SSE"));
				status.setReason(rs.getString("reason"));
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
