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
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.TeamFormDTO;

import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;

public class TeamDAO {
	public int addTeam(TeamDetailsFlatDTO TeamDetailsFlatDTO) {
		int a = 0;
		try {
			Connection con = DBConnection.connect();
			PreparedStatement st = con.prepareStatement(CONSTANTS.TEAM_INSERT );
			st.setString(1, TeamDetailsFlatDTO.getTeamName());
			st.setString(2, TeamDetailsFlatDTO.getTeamid());
			st.setString(3, TeamDetailsFlatDTO.getModuleId());
			st.setString(4, TeamDetailsFlatDTO.getTeamDesc());
			a = st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
		
			// TODO: release connection
		}
		return a;
	}
	public int addTeam(String tName,String moduleId){
		int status=0;
		try {
			Connection con = DBConnection.getConnection();
		//	String fetchModuleId = "Select ModuleId from ModuleDetail where ModuleName = ?";
			String sqlInsert = "insert into Team (TeamName,ModuleId,Status) values(?,?,?)";

			PreparedStatement st = con.prepareStatement(sqlInsert);
			st.setString(1, tName);
			st.setString(2, moduleId);
			st.setString(3, "Y");
			
			status=st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			// TODO: release connection
		}

		return status;
		
	}
	
	public String fetchTeam(String team,String mid){
		String status=null;
		try {
			Connection con = DBConnection.getConnection();
			

			String sqlFetch = "SELECT TeamId FROM Team where TeamName=? AND ModuleId = ?";
			
			PreparedStatement st = con.prepareStatement(sqlFetch);
			
			st.setString(1, team);
			st.setString(2, mid);
			
			ResultSet rs = st.executeQuery();
		//	ResultSetMetaData metaData = rs.getMetaData();
		//	int count = metaData.getColumnCount();
		
		//	System.out.println();
		//	System.out.println(rs.getString("ModuleName"));
         while(rs.next()){
	
	     status= rs.getString("TeamId");
         }

         con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return status;
	}
	 
	
	public List<String> fetchModule(){
		List<String> ModuleList = new ArrayList<String>();
		try {
			Connection con = DBConnection.getConnection();
			String sqlFetch = "SELECT ModuleName FROM ModuleDetail";
			PreparedStatement st = con.prepareStatement(sqlFetch);
			ResultSet rs = st.executeQuery();
		//	ResultSetMetaData metaData = rs.getMetaData();
		//	int count = metaData.getColumnCount();
		
		//	System.out.println();
		//	System.out.println(rs.getString("ModuleName"));
           while(rs.next())
           {
        	   ModuleList.add(rs.getString("ModuleName"));
        	   //System.out.println(rs.getString("ModuleName"));
           }
           con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ModuleList;
	}
	
	public int deleteTeam(String teamID) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getConnection();
		int status=0;
		try{
			String sqlemp = "UPDATE Employee SET TeamId = 'FREE' WHERE TeamId = ?";
			String sqlUpdate = "UPDATE Team SET Status = 'N' WHERE TeamId = ?";
			PreparedStatement stemp=con.prepareStatement(sqlemp);
			stemp.setString(1, teamID);
			PreparedStatement st = con.prepareStatement(sqlUpdate);
			st.setString(1, teamID);
			stemp.executeUpdate();
			status=st.executeUpdate();
		}
		finally{
			con.commit();
			con.close();
			
		}
		return status;
		
	}
	
	public List<String> fetchTeams(String moduleId){
		List<String> TeamList = new ArrayList<String>();
		
		//String projectId=null;
		
				try {
					Connection con = DBConnection.getConnection();
					String sqlFetch = "SELECT TeamName FROM Team WHERE ModuleId=? ";
					PreparedStatement st = con.prepareStatement(sqlFetch);
					
					st.setString(1, moduleId);
					
					
					
					ResultSet rs = st.executeQuery();
				//	ResultSetMetaData metaData = rs.getMetaData();
				//	int count = metaData.getColumnCount();
				
				//	System.out.println();
				//	System.out.println(rs.getString("ModuleName"));
				while(rs.next())
				{
				TeamList.add(rs.getString("TeamName"));
				//System.out.println(rs.getString("TeamName"));
				//	System.out.println(rs.getString("ModuleName"));
				}
				con.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return TeamList;
		
	}
	
	public int editTeam(String teamname, String module, String teamdescription, String teamId){
		int status=0;
		try {
			Connection con = DBConnection.getConnection();
		//	String fetchModuleId = "Select ModuleId from ModuleDetail where ModuleName = ?";
			String sqlInsert = "UPDATE Team SET TeamName =? , ModuleId = ?,TeamDescription=? WHERE TeamId = ?";

			PreparedStatement st = con.prepareStatement(sqlInsert);
			st.setString(1, teamname);
			st.setString(2, module);
			st.setString(3, teamdescription);
			st.setString(4, teamId);
			
			status=st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			// TODO: release connection
		}
		return status;
	}
	
	public List<TeamDetailsFlatDTO> fetchTeamDetails(String teamId){
		List<TeamDetailsFlatDTO> TeamDetailsList = new ArrayList<TeamDetailsFlatDTO>();
		TeamDetailsFlatDTO team = null;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(CONSTANTS.TEAM_DETAIL_FETCH);
			st.setString(1, teamId);
		
			ResultSet rs = st.executeQuery();
		//	ResultSetMetaData metaData = rs.getMetaData();
		//	int count = metaData.getColumnCount();
		
		//	System.out.println();
		//	System.out.println(rs.getString("ModuleName"));
			while(rs.next()){
			team = new TeamDetailsFlatDTO();
			team.setTeamName(rs.getString(CONSTANTS.TEAM_NAME));
			team.setTeamDescription(rs.getString(CONSTANTS.TEAM_DESCRIPTION));
			team.setModuleId(rs.getString(CONSTANTS.MODULE_ID));
			team.setTeamId(rs.getString(CONSTANTS.TEAM_ID));
			
			TeamDetailsList.add(team);
		}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TeamDetailsList;
	}
	
	public  List<String> fetchTeam(String module) {
		List<String> teamList = new ArrayList<String>();
		String id ="0";
			try {
				Connection con = DBConnection.getConnection();
				String sqlModuleIdFetch = "Select ModuleId from ModuleDetail where ModuleName=?";
				String sqlFetch = "SELECT TeamName FROM Team where ModuleId=?";
				
				PreparedStatement st = con.prepareStatement(sqlModuleIdFetch);
				
			//	System.out.println(module);
				st.setString(1, module );
				ResultSet rs = st.executeQuery();
			
				while(rs.next())
				{		
					id = rs.getString("ModuleId");
					//System.out.println(id);
				}
				st = con.prepareStatement(sqlFetch);
				
				
				st.setString(1, id );
				 rs = st.executeQuery();
				 teamList.add("TEAM :<select name=\"s_team\" id=\"s_team\">");
				 while(rs.next())
				 {
					 teamList.add( "<option value=\"" +rs.getString("TeamName")+"\">" +rs.getString("TeamName")+ " </option>" );
					// System.out.println(rs.getString("TeamName"));
				 }
				 teamList.add("</select>");
				 con.close();
				
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return teamList;
		
			}
	
public List<TeamDetailsFlatDTO> viewTeam() {
		
		List<TeamDetailsFlatDTO> teamList = new ArrayList<TeamDetailsFlatDTO>();
		try {
			TeamDetailsFlatDTO details = null;
			
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			
			String querry = "select * from Team";
			ResultSet rs = st.executeQuery(querry);
			
			while(rs.next())
			{
				details = new TeamDetailsFlatDTO();
				details.setTeamId(rs.getString("TeamId"));
				details.setTeamName(rs.getString("TeamName"));
				details.setModuleId(rs.getString("ModuleId"));
				details.setTeamDescription(rs.getString("TeamDescription"));
				
				teamList.add(details);
			}
			
			} 
			
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return teamList;

	}
	


		}
