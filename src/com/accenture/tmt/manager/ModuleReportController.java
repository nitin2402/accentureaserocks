package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.ModuleReportDAO;

import com.accenture.tmt.dao.dto.ModuleDetailsFlatDTO;
import com.accenture.tmt.dao.dto.ModuleReportFlatDTO;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;
import com.accenture.tmt.presentation.dto.ModuleReportDTO;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;

public class ModuleReportController {
	public List<ModuleReportFlatDTO> reportModuleWithoutModuleName(ModuleReportDTO modulereportdto){
	ModuleReportDAO modulereportdao = new ModuleReportDAO();
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	modulereportflatdto = modulereportdao.getDetailsWithoutModuleNameDAO(modulereportdto);
	return modulereportflatdto ;
	}
	
	public List<ModuleReportFlatDTO> reportModuleWithoutStartDate(ModuleReportDTO modulereportdto){
		ModuleReportDAO modulereportdao = new ModuleReportDAO();
		List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
		modulereportflatdto = modulereportdao.getDetailsWithoutStartDateDAO(modulereportdto);
		return modulereportflatdto ;
		}
	
	public List<ModuleReportFlatDTO> reportModuleWithoutEndDate(ModuleReportDTO modulereportdto){
		ModuleReportDAO modulereportdao = new ModuleReportDAO();
		List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
		modulereportflatdto = modulereportdao.getDetailsWithoutEndDateDAO(modulereportdto);
		return modulereportflatdto ;
		}
	
	public List<ModuleReportFlatDTO>reportModuleWithOnlyEndDate(ModuleReportDTO modulereportdto){
		ModuleReportDAO modulereportdao = new ModuleReportDAO();
		List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
		modulereportflatdto = modulereportdao.getDetailsWithOnlyEndDateDAO(modulereportdto);
		return modulereportflatdto ;
		}
	
	public List<ModuleReportFlatDTO>reportModuleWithOnlyModuleName(ModuleReportDTO modulereportdto){
		ModuleReportDAO modulereportdao = new ModuleReportDAO();
		List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
		modulereportflatdto = modulereportdao.getDetailsWithOnlyModuleNameDAO(modulereportdto);
		return modulereportflatdto ;
		}
	
	public List<ModuleReportFlatDTO>reportModuleWithOnlyStartDate(ModuleReportDTO modulereportdto){
		ModuleReportDAO modulereportdao = new ModuleReportDAO();
		List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
		modulereportflatdto = modulereportdao.getDetailsWithOnlyStartDateDAO(modulereportdto);
		return modulereportflatdto ;
		}
	public List<ModuleReportFlatDTO>reportModule(ModuleReportDTO modulereportdto){
		ModuleReportDAO modulereportdao = new ModuleReportDAO();
		List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
		modulereportflatdto = modulereportdao.getDetailsReportDAO(modulereportdto);
		return modulereportflatdto ;
		}
	
public  List<String> fetchModuleList(){
		
		ModuleReportDAO modulereportDao = new ModuleReportDAO();
		return modulereportDao.getModuleList();
		 
	}

public void updateModuleReport(ModuleReportUpdateDTO reportupdatedto){
	ModuleReportDAO modulereportdao = new ModuleReportDAO();
	modulereportdao.insertModuleReport(reportupdatedto);
	
	
	
}
}
