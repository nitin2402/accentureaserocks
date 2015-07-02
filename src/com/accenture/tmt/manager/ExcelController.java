package com.accenture.tmt.manager;


import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.ExcelDAO;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.dao.dto.TeamDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;
import com.accenture.tmt.presentation.dto.TeamFormDTO;

public class ExcelController {
	public int addFromExcel(List<EmployeeDetailsDTO> listOfEmps) throws IOException, ClassNotFoundException {
	
		EmployeeDetailsFlatDTO excel=null;

		List<EmployeeDetailsFlatDTO> li=new ArrayList<EmployeeDetailsFlatDTO>();
	
		
		for(int i=0;i<listOfEmps.size();i++)
		{
		
			excel=new EmployeeDetailsFlatDTO();
			excel.setEmpId(listOfEmps.get(i).getEmpId());
			excel.setEmpName(listOfEmps.get(i).getEmpName());
			excel.setDesignation(listOfEmps.get(i).getDesignation());
			excel.setLevel(listOfEmps.get(i).getLevel());
			excel.setExpertise(listOfEmps.get(i).getExpertise());
			excel.setClientId(listOfEmps.get(i).getClientId());
			excel.setEmail(listOfEmps.get(i).getEmail());
			excel.setTeamId(listOfEmps.get(i).getTeamId());
			excel.setProfCamps(listOfEmps.get(i).getProfCamps());
			excel.setProfProject(listOfEmps.get(i).getProfProject());
			excel.setDoj(listOfEmps.get(i).getDoj());
			excel.setLastWD(listOfEmps.get(i).getLastWD());
			excel.setIsBillable(listOfEmps.get(i).getIsBillable());
			excel.setIsActive(listOfEmps.get(i).getIsActive());
			li.add(excel);
		
			}
	
		ExcelDAO dao=new ExcelDAO();
		int b=dao.addFromExcel(li);
		if(b!=0){
			
			out.println("Record Inserted");
		}
		if(b ==0){
			out.println("Record insertion failed");
		
	}
		return b;
		
	
		
	}

	
	public int addFromExcel1(List<TeamFormDTO> listOfTeams) throws IOException, ClassNotFoundException {
		
		TeamDetailsFlatDTO excel=null;

		List<TeamDetailsFlatDTO> li=new ArrayList<TeamDetailsFlatDTO>();
		
		for(int i=0;i<listOfTeams.size();i++)
		{
		
			excel=new TeamDetailsFlatDTO();
			excel.setTeamName(listOfTeams.get(i).getTeamName());
			excel.setTeamId(listOfTeams.get(i).getTeamId());
			excel.setModuleId(listOfTeams.get(i).getModuleId());
			excel.setTeamDescription(listOfTeams.get(i).getTeamDescription());
			excel.setStatus(listOfTeams.get(i).getStatus());
			li.add(excel);
		}
		ExcelDAO dao=new ExcelDAO();
		int b=dao.addFromExcel1(li);
		if(b!=0){
			
			out.println("Record Inserted Successfully");
		}
		if(b ==0){
			out.println("Record insertion failed");
		
	}
		return b;
		

	}	

	
	
}
