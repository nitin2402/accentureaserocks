package com.accenture.tmt.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accenture.tmt.dao.WorkplanAdminDAO;
import com.accenture.tmt.dao.dto.WorkplanAdminFlatDTO;
import com.accenture.tmt.presentation.dto.ActionDTO;
import com.accenture.tmt.presentation.dto.WorkplanAdminDTO;

public class WorkplanAdminController {
	
	public WorkplanAdminDTO fetchCalculationDetails(ActionDTO actiondto){
		
		int aseRequestedValue = 0;
		int seRequestedValue = 0;
		int sseRequestedValue = 0;
		int totalRequestedValue = 0;
		String aseCurrency = null;
		String seCurrency = null;
		String sseCurrency = null;
		String tlCurrency = null;
		int currentASEValue = 0;
		int currentSEValue = 0;
		int currentSSEValue = 0;
		int currentTLValue = 0;
		int totalCurrentValue = 0;
		Map<String, List<String>> details = new HashMap<String, List<String>>();
		
		WorkplanAdminDAO workplanAdminDAO = new WorkplanAdminDAO();
		WorkplanAdminFlatDTO workplanAdminFlatDTO = workplanAdminDAO.fetchData(actiondto);
		WorkplanAdminDTO workplanAdminDTO = new WorkplanAdminDTO();
		
		details = workplanAdminFlatDTO.getDetails();
		
		workplanAdminDTO.setAseRequested(workplanAdminFlatDTO.getAseRequested());
		workplanAdminDTO.setSeRequested(workplanAdminFlatDTO.getSeRequested());
		workplanAdminDTO.setSseRequested(workplanAdminFlatDTO.getSseRequested());
		workplanAdminDTO.setCurrentASE(workplanAdminFlatDTO.getCurrentASE());
		workplanAdminDTO.setCurrentSE(workplanAdminFlatDTO.getCurrentSE());
		workplanAdminDTO.setCurrentSSE(workplanAdminFlatDTO.getCurrentSSE());
		workplanAdminDTO.setCurrentTL(workplanAdminFlatDTO.getCurrentTL());
		workplanAdminDTO.setDetails(details);
		
		List<String> value;
		value = details.get("ASE");
		aseRequestedValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getAseRequested()) ;
		currentASEValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getCurrentASE()) ;
		aseCurrency = value.get(0);
		
		value = details.get("SE");
		seRequestedValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getSeRequested()) ;
		currentSEValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getCurrentSE()) ;
		seCurrency = value.get(0);
		
		value = details.get("SSE");
		sseRequestedValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getSeRequested()) ;
		currentSSEValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getCurrentSSE()) ;
		sseCurrency = value.get(0);
		
		value = details.get("TL");
		currentTLValue = (Integer.parseInt(value.get(1))) * (workplanAdminFlatDTO.getCurrentTL()) ;
		tlCurrency = value.get(0);
		
		totalRequestedValue = aseRequestedValue + seRequestedValue + sseRequestedValue ;
		totalCurrentValue = currentASEValue + currentSEValue + currentSSEValue + currentTLValue;
		
		workplanAdminDTO.setAseRequestedValue(aseRequestedValue);
		workplanAdminDTO.setSeRequestedValue(seRequestedValue);
		workplanAdminDTO.setSseRequestedValue(sseRequestedValue);
		workplanAdminDTO.setTotalRequestedValue(totalRequestedValue);
		workplanAdminDTO.setAseCurrency(aseCurrency);
		workplanAdminDTO.setSeCurrency(seCurrency);
		workplanAdminDTO.setSseCurrency(sseCurrency);
		workplanAdminDTO.setTlCurrency(tlCurrency);
		workplanAdminDTO.setCurrentASEValue(currentASEValue);
		workplanAdminDTO.setCurrentSEValue(currentSEValue);
		workplanAdminDTO.setCurrentSSEValue(currentSSEValue);
		workplanAdminDTO.setCurrentTLValue(currentTLValue);
		workplanAdminDTO.setTotalCurrentValue(totalCurrentValue);
		
		return workplanAdminDTO;
		}
		
		
		
		
		
	}


