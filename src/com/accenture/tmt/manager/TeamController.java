package com.accenture.tmt.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.TeamDAO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.TeamFormDTO;

public class TeamController {
	TeamDAO teamDAO= new TeamDAO();
	
	public  int deleteTeam(String teamID) throws ClassNotFoundException, SQLException{
		int status=teamDAO.deleteTeam(teamID);
		return status;
	}
	public int addTeam(TeamDetailsFlatDTO detailsDO)
	{	
	
	TeamDetailsFlatDTO detailsFD = new TeamDetailsFlatDTO();
	detailsFD.setTeamName(detailsDO.getTeamName());
	detailsFD.setTeamid(detailsDO.getTeamid());
	detailsFD.setModuleId(detailsDO.getModuleId());
	detailsFD.setTeamDesc(detailsDO.getTeamDesc());
	TeamDAO dao1 =new TeamDAO();
	int b=dao1.addEmployee(detailsFD);
	
	if(b!=0){
		System.out.println("Record Inserted");
	}
	if(b ==0){
		System.out.println("Record insertion failed");
}
	return b;
	
	}

	/*public int addTeam(String tName, String moduleId) {
		int status=teamDAO.addTeam(tName,moduleId);
		return status;
	}*
	/
	 * 
	 */
	
/*	public List<TeamDetailsDO> fetchTeamDetails(
			TeamDetailsDO tDetailsDO) {
		List<TeamDetailsDO> listOfTeams = new ArrayList<TeamDetailsDO>();
		try {
			Connection con = DBConnect.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Team");
			TeamDetailsDO teamDetailsDO = null;
			while (rs.next()) {

				teamDetailsDO = new TeamDetailsDO();
				teamDetailsDO.settName(rs.getString(1));
				teamDetailsDO.settCode(rs.getString(2));
				
				listOfTeams.add(teamDetailsDO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfTeams;
	}
	*/
	public String fetchTeamid(String team , String mid){
		String status=teamDAO.fetchTeam(team, mid);
		return status;
		}
	
	public  List<String> fetchModule() {
		List<String> ModuleList=teamDAO.fetchModule();
		return ModuleList;
		}
	
	public  List<String> fetchTeams(String moduleId) {
		List<String> TeamList=teamDAO.fetchTeams(moduleId);
		return TeamList;
		}
	
	public int EditTeam(String teamname , String module ,String teamdescription,String teamId) {
		int status=teamDAO.editTeam(teamname, module, teamdescription, teamId);
		return status;
	}
	
	public List<TeamDetailsFlatDTO> FetchTeamDetails(String teamId)
	{
		List<TeamDetailsFlatDTO> TeamDetailsList=teamDAO.fetchTeamDetails(teamId);
		return TeamDetailsList;
	}
	
	public  List<String> fetchTeam(String module) {
		List<String> teamList=teamDAO.fetchTeam(module);
		return teamList;
    }
	
	public List<TeamDetailsFlatDTO> viewTeam(){
		List<TeamDetailsFlatDTO> list = new ArrayList<TeamDetailsFlatDTO>();
		list=teamDAO.viewTeam();
		return list;
	}
	public  List<TeamFormDTO> fetchTeamDetails() {
		List<TeamFormDTO> teamList=teamDAO.fetchTeamDetails();
		return teamList;
	}
}
