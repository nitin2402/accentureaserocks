package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;


public class ProjectDAO {

	public  List<String> fetchProject() {
		List<String> projectList = new ArrayList<String>();
			try {
				Connection con = DBConnection.getConnection();
				

				String sqlFetch = "SELECT ProjectName FROM ProjectDetail";
				
				PreparedStatement st = con.prepareStatement(sqlFetch);
				ResultSet rs = st.executeQuery();
			//	ResultSetMetaData metaData = rs.getMetaData();
			//	int count = metaData.getColumnCount();
				while(rs.next())
				{
						
					projectList.add(rs.getString("ProjectName"));
				}
				con.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return projectList;

}

private List<String> projectNames = new ArrayList<String>();
	
	public  List<String> getProjectNames(){
		
		ResultSet rs = null;
		try {
			Connection con = DBConnection.getConnection();
			
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.Get_Project_QUERY);
				rs = st.executeQuery();
				while(rs.next()){
					projectNames.add(rs.getString("ProjectName"));
				}

		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projectNames;

		
	}
}
