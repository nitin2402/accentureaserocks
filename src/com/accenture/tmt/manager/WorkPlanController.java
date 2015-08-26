package com.accenture.tmt.manager;

import java.util.List;

import com.accenture.tmt.dao.WorkplanDAO;
import com.accenture.tmt.dao.dto.WorkplanFlatDTO;
import com.accenture.tmt.presentation.dto.WorkplanDTO;

public class WorkPlanController {
	
	public String raiseRequest(WorkplanDTO workplandto){
		
		int flag = 0 ;
		String employeeId = null ;
		
		WorkplanDAO workplanDao = new WorkplanDAO();
		employeeId = workplanDao.fetchEmployeeId(workplandto.getUserName());
		WorkplanFlatDTO workplanflatdto = new WorkplanFlatDTO();
		
		String empDetails[] ;
		
		int lastCount = workplanDao.countRows();
		
		String newReqId = "REQ-"+ (lastCount + 1);
		
		workplanflatdto.setReqId(newReqId);
		workplanflatdto.setTeamId(workplandto.getTeamId());
		workplanflatdto.setnASE(workplandto.getnASE());
		workplanflatdto.setnSE(workplandto.getnSE());
		workplanflatdto.setnSSE(workplandto.getnSSE());
		workplanflatdto.setComment(workplandto.getComment());
		workplanflatdto.setEmployeeId(employeeId);
		if(workplandto.isSpecificRequest().equals("False")){
			workplanflatdto.setSpecificComment("None");
			workplanflatdto.setSpecificRequest("False");
			workplanflatdto.setSpecificRequestEmployeeId("None");
		} else{
			empDetails = workplandto.getSpecificRequestEmployee().split("_");
			workplanflatdto.setSpecificComment(workplandto.getSpecificComment());
			workplanflatdto.setSpecificRequest(workplandto.isSpecificRequest());
			workplanflatdto.setSpecificRequestEmployeeId(empDetails[0]);
		}
		
		
		 flag = workplanDao.insertRequest(workplanflatdto);
		
		 if(flag == 1){
		return newReqId;
		 }
		 else{
			 return "NotInserted" ;
		 }
		
	}
	
public List<String> fetchTeamList(){
		
		WorkplanDAO workplanDao = new WorkplanDAO();
		return workplanDao.getTeamList();
		 
	}

}
