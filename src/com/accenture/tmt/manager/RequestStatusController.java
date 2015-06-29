package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.RequestStatusDAO;
import com.accenture.tmt.dao.dto.RequestStatusFlatDTO;

public class RequestStatusController {

	RequestStatusDAO reqst = new RequestStatusDAO();
	
	public List<RequestStatusFlatDTO> viewStatus(){
		List<RequestStatusFlatDTO> statusList = new ArrayList<RequestStatusFlatDTO>();
		statusList = reqst.viewStatus();
		return statusList;
		
	}
}
