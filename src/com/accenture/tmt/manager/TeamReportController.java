package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;
import com.accenture.tmt.dao.TeamReportDAO;
import com.accenture.tmt.dao.dto.TeamReportFlatDTO;
import com.accenture.tmt.presentation.dto.TeamReportDTO;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;


public class TeamReportController {
	
	public List<TeamReportFlatDTO> teamReportWithoutAnything(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getDetailsWithoutAnything(teamReportDTO);
		return teamReportFlatDTO ;
		}
		
	
	public List<TeamReportFlatDTO> teamReportWithoutTeamName(TeamReportDTO teamReportDTO){
	TeamReportDAO teamReportDAO = new TeamReportDAO();
	List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
	teamReportFlatDTO = teamReportDAO.getReportWithoutTeamName(teamReportDTO);
	return teamReportFlatDTO ;
	}
	public List<TeamReportFlatDTO> teamReportWithoutTeamName_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutTeamName_With_Action(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReportWithoutStartDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutStartDate(teamReportDTO);
		return teamReportFlatDTO;
		}
	public List<TeamReportFlatDTO> teamReportWithoutStartDate_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutStartDate_With_Action(teamReportDTO);
		return teamReportFlatDTO;
		}
	
	public List<TeamReportFlatDTO> teamReportWithoutEndDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutEndDate(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReportWithoutEndDate_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutEndDate_With_Action(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReportWithOnlyEndDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyEndDate(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReportWithOnlyEndDate_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyEndDate_With_Action(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReportWithOnlyTeamName(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyTeamName(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReportWithOnlyTeamName_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyTeamName_With_Action(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReportWithOnlyaction(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyAction(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReportWithOnlyStartDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyStartDate(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReportWithOnlyStartDate_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyStartDate(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReport(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getTeamReport(teamReportDTO);
		return teamReportFlatDTO ;
		}
	public List<TeamReportFlatDTO> teamReport_with_action(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getTeamReport_With_Action(teamReportDTO);
		return teamReportFlatDTO ;
		}




	public void updateTeamReport(TeamReportUpdateDTO reportupdatedto) {
		// TODO Auto-generated method stub
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		teamReportDAO.insertTeamReport(reportupdatedto);
	}


}
