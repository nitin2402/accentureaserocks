package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.RequestStatusDAO;
import com.accenture.tmt.dao.dto.RequestStatusFlatDTO;

public class RequestStatusController {

	RequestStatusDAO reqst = new RequestStatusDAO();
	
	public List<RequestStatusFlatDTO> viewStatus(String userName){
		List<RequestStatusFlatDTO> statusList = new ArrayList<RequestStatusFlatDTO>();
		statusList = reqst.viewStatus(userName);
		return statusList;
		
	}
}
