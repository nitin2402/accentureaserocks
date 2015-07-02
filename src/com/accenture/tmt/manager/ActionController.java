package com.accenture.tmt.manager;

import com.accenture.tmt.dao.ActionDAO;
import com.accenture.tmt.dao.dto.ActionFlatDTO;
import com.accenture.tmt.presentation.dto.ActionDTO;

public class ActionController {
	
	ActionDAO actiondao = new ActionDAO();
	ActionFlatDTO actionflatdto = new ActionFlatDTO();
	int flag = 0;
	public int acceptRequest(ActionDTO actiondto) {
		
		actionflatdto.setReqId(actiondto.getReqId());
		actionflatdto.setReason(actiondto.getReason());
		flag = actiondao.accept(actionflatdto);
		return flag;
		
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
