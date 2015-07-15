package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.AuthorizeEmployeeDAO;
import com.accenture.tmt.dao.dto.LoginFlatDTO;

import com.accenture.tmt.presentation.dto.LoginDTO;



public class AuthorizeEmployeeController {
	  public List<LoginDTO> authorizeemployee(){
		  List<LoginDTO> unauthorized_employees = new ArrayList<LoginDTO>();
		  List<LoginFlatDTO> get_unauthorized_employees = new ArrayList<LoginFlatDTO>();
		  AuthorizeEmployeeDAO authorizedao = new AuthorizeEmployeeDAO();
		  get_unauthorized_employees =  authorizedao.authorizeDao();

			for(int i=0; i < get_unauthorized_employees.size(); i++){
				
				LoginDTO authorize = new LoginDTO();
				authorize.setLoginid(get_unauthorized_employees.get(i).getLoginId());
				authorize.setUsername(get_unauthorized_employees.get(i).getUserName());
				authorize.setUserType(get_unauthorized_employees.get(i).getTypeOfUser());
				authorize.setEmployeeId(get_unauthorized_employees.get(i).getEmployeeId());
				authorize.setActiveUser(get_unauthorized_employees.get(i).getActiveUser());
				authorize.setEmployeedesignation(get_unauthorized_employees.get(i).getEmployeedesignation());
				unauthorized_employees.add(i, authorize);
			}
					
			return unauthorized_employees;
		  
	  }
	 
	public int vieweremployee(LoginDTO dto){
		
		 AuthorizeEmployeeDAO authorizedao = new AuthorizeEmployeeDAO();
		int a = authorizedao.updateviewerDAO(dto);
		return a;
	}
	
	public int useremployee(LoginDTO dto){
		
		 AuthorizeEmployeeDAO authorizedao = new AuthorizeEmployeeDAO();
		int a = authorizedao.updateuserDAO(dto);
		return a;	
	}
	public int adminemployee(LoginDTO dto){
		
		 AuthorizeEmployeeDAO authorizedao = new AuthorizeEmployeeDAO();
		int a = authorizedao.updateadminDAO(dto);
		return a;	
	}
	

}
