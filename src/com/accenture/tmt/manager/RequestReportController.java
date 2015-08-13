package com.accenture.tmt.manager;


import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.ModuleReportDAO;
import com.accenture.tmt.dao.ReportRequestDAO;
import com.accenture.tmt.dao.dto.ReportsDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;

public class RequestReportController {
	public List<ReportsDetailsFlatDTO> reportTeamWithoutTeamName(ReportDetailsDTO teamreportdto){
		ReportRequestDAO teamreportdao = new ReportRequestDAO();
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		teamreportflatdto = teamreportdao.getDetailsWithoutTeamNameDAO(teamreportdto);
		return teamreportflatdto ;
		}
		public List<ReportsDetailsFlatDTO> reportTeamWithoutStartDate(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		teamreportflatdto = teamreportdao.getDetailsWithoutStartDateDAO(teamreportdto);
		return teamreportflatdto ;
		}
		public List<ReportsDetailsFlatDTO> reportTeamWithoutEndDate(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithoutEndDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO> reportTeamWithOnlyEndDate(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyEndDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO>reportTeamWithOnlyTeamName(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyTeamNameDAO(teamreportdto);
			return teamreportflatdto ;
			}
				
		public List<ReportsDetailsFlatDTO>reportTeamWithOnlyStartDate(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyStartDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO>reportModuleWithOnlyTeamName(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyStartDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO>reportTeam(ReportDetailsDTO teamreportdto){
			ReportRequestDAO teamreportdao = new ReportRequestDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsReportDAO(teamreportdto);
			return teamreportflatdto ;
			}
		
		
		public  List<String> fetchTeamList(){
			
			ReportRequestDAO teamreportDao = new ReportRequestDAO();
			return teamreportDao.getTeamList();
			 
		}


}
