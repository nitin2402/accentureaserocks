package com.accenture.tmt.manager;


import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.ExcelDAO;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;

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

	

	
	
}
