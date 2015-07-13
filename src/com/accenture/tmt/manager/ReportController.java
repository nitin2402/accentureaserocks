package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.ModuleReportDAO;
import com.accenture.tmt.dao.EmlpoyeeReportDAO;
import com.accenture.tmt.dao.dto.ReportsDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;

public class ReportController {
	
		public List<ReportsDetailsFlatDTO> reportTeamWithoutTeamName(ReportDetailsDTO teamreportdto){
		EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		teamreportflatdto = teamreportdao.getDetailsWithoutTeamNameDAO(teamreportdto);
		return teamreportflatdto ;
		}
		public List<ReportsDetailsFlatDTO> reportTeamWithoutStartDate(ReportDetailsDTO teamreportdto){
		EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
		List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
		teamreportflatdto = teamreportdao.getDetailsWithoutStartDateDAO(teamreportdto);
		return teamreportflatdto ;
		}
		public List<ReportsDetailsFlatDTO> reportTeamWithoutEndDate(ReportDetailsDTO teamreportdto){
			EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithoutEndDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO> reportTeamWithOnlyEndDate(ReportDetailsDTO teamreportdto){
			EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyEndDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO>reportTeamWithOnlyTeamName(ReportDetailsDTO teamreportdto){
			EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyTeamNameDAO(teamreportdto);
			return teamreportflatdto ;
			}
				
		public List<ReportsDetailsFlatDTO>reportTeamWithOnlyStartDate(ReportDetailsDTO teamreportdto){
			EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyStartDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO>reportModuleWithOnlyTeamName(ReportDetailsDTO teamreportdto){
			EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsWithOnlyStartDateDAO(teamreportdto);
			return teamreportflatdto ;
			}
		public List<ReportsDetailsFlatDTO>reportTeam(ReportDetailsDTO teamreportdto){
			EmlpoyeeReportDAO teamreportdao = new EmlpoyeeReportDAO();
			List<ReportsDetailsFlatDTO> teamreportflatdto = new ArrayList<ReportsDetailsFlatDTO>();
			teamreportflatdto = teamreportdao.getDetailsReportDAO(teamreportdto);
			return teamreportflatdto ;
			}
		
		
		public  List<String> fetchTeamList(){
			
			EmlpoyeeReportDAO teamreportDao = new EmlpoyeeReportDAO();
			return teamreportDao.getTeamList();
			 
		}

	


}
