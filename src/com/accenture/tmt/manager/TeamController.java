package com.accenture.tmt.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.accenture.tmt.common.DBConnection;

public class TeamController {
	public int DeleteTeam(String teamID) throws SQLException, ClassNotFoundException{
		Connection con = DBConnection.getConnection();
		int a=0;
		try{
			
			String sqlInsert = "UPDATE Team SET Status = 'N' WHERE TeamId = ?";
			PreparedStatement st = con.prepareStatement(sqlInsert);
			a=st.executeUpdate(teamID, 1);
		}
		finally{
			con.commit();
			con.close();
			
		}
		return a;
		
	}

}
