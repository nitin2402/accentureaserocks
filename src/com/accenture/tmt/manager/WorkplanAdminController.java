package com.accenture.tmt.manager;

import java.util.Map;

import com.accenture.tmt.dao.WorkplanAdminDAO;
import com.accenture.tmt.dao.dto.WorkplanAdminFlatDTO;
import com.accenture.tmt.presentation.dto.ActionDTO;
import com.accenture.tmt.presentation.dto.WorkplanAdminDTO;

public class WorkplanAdminController {
	
	public WorkplanAdminDTO fetchCalculationDetails(ActionDTO actiondto){
		
		int aseRequested = 0;
		int seRequested = 0;
		int sseRequested = 0;
		Map<String, Integer> freeASEList ;
		Map<String, Integer> freeSEList ;
		Map<String, Integer> freeSSEList ;
		float currentAvg = 0;
		
		WorkplanAdminDAO workplanAdminDAO = new WorkplanAdminDAO();
		WorkplanAdminFlatDTO workplanAdminFlatDTO = workplanAdminDAO.fetchData(actiondto);
		WorkplanAdminDTO workplanAdminDTO = new WorkplanAdminDTO();
		
		freeASEList = workplanAdminFlatDTO.getFreeASEList();
		freeSEList = workplanAdminFlatDTO.getFreeSEList();
		freeSSEList = workplanAdminFlatDTO.getFreeSSEList();
		currentAvg = workplanAdminFlatDTO.getCurrentAvg();
		aseRequested = workplanAdminFlatDTO.getAseRequested();
		seRequested = workplanAdminFlatDTO.getSeRequested();
		sseRequested = workplanAdminFlatDTO.getSseRequested();
		
		workplanAdminDTO.setAseRequested(aseRequested);
		workplanAdminDTO.setSeRequested(seRequested);
		workplanAdminDTO.setSseRequested(sseRequested);
		workplanAdminDTO.setFreeASEList(freeASEList);
		workplanAdminDTO.setFreeSEList(freeSEList);
		workplanAdminDTO.setFreeSSEList(freeSSEList);
		workplanAdminDTO.setCurrentAvg(currentAvg);
		
		return workplanAdminDTO;
		}
		
	}


