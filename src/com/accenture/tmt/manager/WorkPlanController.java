package com.accenture.tmt.manager;

import com.accenture.tmt.dao.WorkplanDAO;
import com.accenture.tmt.dao.dto.WorkplanFlatDTO;
import com.accenture.tmt.presentation.dto.WorkplanDTO;

public class WorkPlanController {
	
	public String raiseRequest(WorkplanDTO workplandto){
		
		int flag = 0 ;
		
		WorkplanDAO workplanDao = new WorkplanDAO();
		
		WorkplanFlatDTO workplanflatdto = new WorkplanFlatDTO();
		
		int lastCount = workplanDao.countRows();
		
		String newReqId = "REQ-"+ (lastCount + 1);
		
		workplanflatdto.setReqId(newReqId);
		workplanflatdto.setTeamId(workplanDao.fetchTeamId(workplandto.getUserName()));
		workplanflatdto.setnASE(workplandto.getnASE());
		workplanflatdto.setnSE(workplandto.getnSE());
		workplanflatdto.setnSSE(workplandto.getnSSE());
		workplanflatdto.setComment(workplandto.getComment());
		
		
		 flag = workplanDao.insertRequest(workplanflatdto);
		
		 if(flag == 1){
		return newReqId;
		 }
		 else{
			 return "NotInserted" ;
		 }
		
	}

}
