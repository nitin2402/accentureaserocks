package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;
import com.accenture.tmt.dao.TeamReportDAO;
import com.accenture.tmt.dao.dto.TeamReportFlatDTO;
import com.accenture.tmt.presentation.dto.TeamReportDTO;


public class TeamReportController {
	
	public List<TeamReportFlatDTO> teamReportWithoutTeamName(TeamReportDTO teamReportDTO){
	TeamReportDAO teamReportDAO = new TeamReportDAO();
	List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
	teamReportFlatDTO = teamReportDAO.getReportWithoutTeamName(teamReportDTO);
	return teamReportFlatDTO ;
	}
	
	public List<TeamReportFlatDTO> teamReportWithoutStartDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutStartDate(teamReportDTO);
		return teamReportFlatDTO;
		}
	
	public List<TeamReportFlatDTO> teamReportWithoutEndDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithoutEndDate(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReportWithOnlyEndDate(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyEndDate(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReportWithOnlyTeamName(TeamReportDTO teamReportDTO){
		TeamReportDAO teamReportDAO = new TeamReportDAO();
		List<TeamReportFlatDTO> teamReportFlatDTO = new ArrayList<TeamReportFlatDTO>();
		teamReportFlatDTO = teamReportDAO.getReportWithOnlyTeamName(teamReportDTO);
		return teamReportFlatDTO ;
		}
	
	public List<TeamReportFlatDTO> teamReportWithOnlyStartDate(TeamReportDTO teamReportDTO){
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

/*public void updateTeamReport(TeamReportUpdateDTO reportUpdateDTO){
	TeamReportDAO teamReportDAO = new TeamReportDAO();
	teamReportDAO.insertTeamReport(reportUpdateDTO);
		
	}*/
}
