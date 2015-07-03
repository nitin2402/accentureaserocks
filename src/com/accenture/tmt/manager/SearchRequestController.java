package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.SearchRequestDAO;
import com.accenture.tmt.dao.dto.SearchRequestFlatDTO;
import com.accenture.tmt.presentation.dto.SearchRequestDTO;

public class SearchRequestController {
	
	public List<SearchRequestDTO> searchApprovedRequests(){
		
		List<SearchRequestFlatDTO> get_approved_requests = new ArrayList<SearchRequestFlatDTO>();
		
		List<SearchRequestDTO> send_approved_requests = new ArrayList<SearchRequestDTO>();
		
		SearchRequestDAO searchrequestdao = new SearchRequestDAO();
		
		get_approved_requests = searchrequestdao.getApprovedRequests();
		
		for(int i=0; i < get_approved_requests.size(); i++){
			
			SearchRequestDTO searchrequestdto = new SearchRequestDTO();
			
			searchrequestdto.setReqId(get_approved_requests.get(i).getReqId());
			searchrequestdto.setTeamName(get_approved_requests.get(i).getTeamName());
			searchrequestdto.setnASE(get_approved_requests.get(i).getnASE());
			searchrequestdto.setnSE(get_approved_requests.get(i).getnSE());
			searchrequestdto.setnSSE(get_approved_requests.get(i).getnSSE());
			searchrequestdto.setComment(get_approved_requests.get(i).getComment());
			searchrequestdto.setStatusName(get_approved_requests.get(i).getStatusName());
			
			send_approved_requests.add(i, searchrequestdto);
		}
		
		return send_approved_requests;
		
		
	}
	
public List<SearchRequestDTO> searchUnpprovedRequests(){
		
		List<SearchRequestFlatDTO> get_unapproved_requests = new ArrayList<SearchRequestFlatDTO>();
		
		List<SearchRequestDTO> send_unapproved_requests = new ArrayList<SearchRequestDTO>();
		
		SearchRequestDAO searchrequestdao = new SearchRequestDAO();
		
		get_unapproved_requests = searchrequestdao.getUnapprovedRequests();
		
		for(int i=0; i < get_unapproved_requests.size(); i++){
			
			SearchRequestDTO searchrequestdto = new SearchRequestDTO();
			
			searchrequestdto.setReqId(get_unapproved_requests.get(i).getReqId());
			searchrequestdto.setTeamName(get_unapproved_requests.get(i).getTeamName());
			searchrequestdto.setnASE(get_unapproved_requests.get(i).getnASE());
			searchrequestdto.setnSE(get_unapproved_requests.get(i).getnSE());
			searchrequestdto.setnSSE(get_unapproved_requests.get(i).getnSSE());
			searchrequestdto.setComment(get_unapproved_requests.get(i).getComment());
			searchrequestdto.setStatusName(get_unapproved_requests.get(i).getStatusName());
			
			send_unapproved_requests.add(i, searchrequestdto);
		}
		return send_unapproved_requests;
		
	}

}
