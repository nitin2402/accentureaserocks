package com.accenture.tmt.manager;

import com.accenture.tmt.dao.SignupDAO;
import com.accenture.tmt.dao.dto.SignupFlatDTO;
import com.accenture.tmt.presentation.dto.RegistrationDTO;

public class SignupController {
	public int UserRegistration(LoginDTO registerCred){
		 LoginFlatDTO signupFlatDto = new LoginFlatDTO();
   	     signupFlatDto.setPassword(registerCred.getPassword());
   	     signupFlatDto.setUsername(registerCred.getUsername());
   	     signupFlatDto.setEmployeeid(registerCred.getEmployeeid());
   	     
   	     SignupDAO signupDAO = new SignupDAO();
   	    int returnregisteruser =  signupDAO.RegisterInDatabase(signupFlatDto);
   	     return returnregisteruser;
	}

}
