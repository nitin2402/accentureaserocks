package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.EmlpoyeeReportDAO;
import com.accenture.tmt.dao.ModuleReportDAO;
import com.accenture.tmt.dao.dto.EmployeeReportDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;
import com.accenture.tmt.presentation.dto.ReportDetailsDTO;

public class ReportController {
	
	
	public List<EmployeeReportDetailsFlatDTO> employeeReport(ReportDetailsDTO empreports){
		EmlpoyeeReportDAO empreprtdto = new EmlpoyeeReportDAO();
		List<EmployeeReportDetailsFlatDTO> empreprtflatdto = new ArrayList<EmployeeReportDetailsFlatDTO>();
		empreprtflatdto = empreprtdto.getEmployeeDetailsReportDAO(empreports);
		return empreprtflatdto ;
		}

	public void updateEmpreport(EmployeeReportUpdateDTO reportupdatedto) {
		// TODO Auto-generated method stub
		EmlpoyeeReportDAO modulerepempreportsortdao = new EmlpoyeeReportDAO();
		modulerepempreportsortdao.insertEmpreoptrs(reportupdatedto);
	}

	public void updateEmpReport_Aurthorized(EmployeeReportUpdateDTO reportUpdateDTO) {
		// TODO Auto-generated method stub
		EmlpoyeeReportDAO modulerepempreportsortdao = new EmlpoyeeReportDAO();
		modulerepempreportsortdao.insertIntoEmpReport_Authorized(reportUpdateDTO);
	}

	public List<EmployeeReportDetailsFlatDTO> employeeReports_ALLpresent(ReportDetailsDTO empreports) {
		// TODO Auto-generated method stub
		EmlpoyeeReportDAO empreprtdto = new EmlpoyeeReportDAO();
		List<EmployeeReportDetailsFlatDTO> empreprtflatdto = new ArrayList<EmployeeReportDetailsFlatDTO>();
		empreprtflatdto = empreprtdto.getEmployeeDetailsReportDAO_allpresent(empreports);
		return empreprtflatdto ;
	}
	
	



}
