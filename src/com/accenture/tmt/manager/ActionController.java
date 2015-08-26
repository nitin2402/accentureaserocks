package com.accenture.tmt.manager;

import com.accenture.tmt.dao.ActionDAO;
import com.accenture.tmt.dao.dto.ActionFlatDTO;
import com.accenture.tmt.presentation.dto.ActionDTO;

public class ActionController {
	
	ActionDAO actiondao = new ActionDAO();
	ActionFlatDTO actionflatdto = new ActionFlatDTO();
	int flag = 0;
	
	public int acceptRequest(String[] empASE, String[] empSE, String[] empSSE, 
			String specificReq, ActionDTO actiondto){
		
		String[] temp = new String[2];
		String[] empNamesASE = null ;
		String[] empNamesSE = null ;
		String[] empNamesSSE = null ;
		String sepcificReqEmployeeId =null ;
		
		if(specificReq != null){
			sepcificReqEmployeeId = specificReq.split("_")[0];
		}
		
		if(empASE != null){
			int aseLength = empASE.length ;
			empNamesASE = new String[aseLength] ;
			for(int i=0; i < aseLength; i++){
				temp = empASE[i].split("_") ;
				empNamesASE[i] = temp[0] ;
			}
		}
		
		if(empSE != null){
		int seLength = empSE.length ;
		empNamesSE = new String[seLength] ;
		for(int i=0; i < seLength; i++){
			temp = empSE[i].split("_") ;
			empNamesSE[i] = temp[0] ;
		}
		}
		
		if(empSSE != null){
			int sseLength = empSSE.length ;
			empNamesSSE = new String[sseLength] ;
			for(int i=0; i < sseLength; i++){
				temp = empSSE[i].split("_") ;
				empNamesSSE[i] = temp[0] ;
			}
		}
		
		actionflatdto.setReqId(actiondto.getReqId());
		actionflatdto.setReason(actiondto.getReason());
		flag = actiondao.accept(empNamesASE, empNamesSE, empNamesSSE, sepcificReqEmployeeId, actionflatdto);
		return flag ;
	}

	public int rejectRequest(ActionDTO actiondto) {
		
		actionflatdto.setReqId(actiondto.getReqId());
		actionflatdto.setReason(actiondto.getReason());
		flag = actiondao.reject(actionflatdto);
		return flag;
	}

	public int onholdRequest(ActionDTO actiondto) {
		
		actionflatdto.setReqId(actiondto.getReqId());
		actionflatdto.setReason(actiondto.getReason());
		flag = actiondao.onHold(actionflatdto);
		return flag;
	}

}
