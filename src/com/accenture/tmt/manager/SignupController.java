package com.accenture.tmt.manager;

import com.accenture.tmt.dao.SignupDAO;
import com.accenture.tmt.dao.dto.LoginFlatDTO;

import com.accenture.tmt.presentation.dto.LoginDTO;


public class SignupController {
	public int UserRegistration(LoginDTO registerCred){
		 LoginFlatDTO signupFlatDto = new LoginFlatDTO();
   	     signupFlatDto.setPassWord(registerCred.getPassword());
   	     signupFlatDto.setUserName(registerCred.getUsername());
   	     signupFlatDto.setEmployeeId(registerCred.getEmployeeId());
   	     
   	     SignupDAO signupDAO = new SignupDAO();
   	    int returnregisteruser =  signupDAO.RegisterInDatabase(signupFlatDto);
   	     return returnregisteruser;
	}

}
