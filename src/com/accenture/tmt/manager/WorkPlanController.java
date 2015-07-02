package com.accenture.tmt.manager;

import java.util.List;

import com.accenture.tmt.dao.WorkplanDAO;
import com.accenture.tmt.dao.dto.WorkplanFlatDTO;
import com.accenture.tmt.presentation.dto.WorkplanDTO;

public class WorkPlanController {
	
	public String raiseRequest(WorkplanDTO workplandto){
		
		int flag = 0 ;
		String teamId = null ;
		String employeeId = null ;
		
		WorkplanDAO workplanDao = new WorkplanDAO();
		teamId = workplanDao.fetchTeamId(workplandto.getTeamName());
		employeeId = workplanDao.fetchEmployeeId(workplandto.getUserName());
		WorkplanFlatDTO workplanflatdto = new WorkplanFlatDTO();
		
		int lastCount = workplanDao.countRows();
		
		String newReqId = "REQ-"+ (lastCount + 1);
		
		workplanflatdto.setReqId(newReqId);
		workplanflatdto.setTeamId(teamId);
		workplanflatdto.setnASE(workplandto.getnASE());
		workplanflatdto.setnSE(workplandto.getnSE());
		workplanflatdto.setnSSE(workplandto.getnSSE());
		workplanflatdto.setComment(workplandto.getComment());
		workplanflatdto.setEmployeeId(employeeId);
		
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
