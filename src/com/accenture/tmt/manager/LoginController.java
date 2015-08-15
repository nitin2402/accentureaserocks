package com.accenture.tmt.manager;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.dao.LoginDAO;
import com.accenture.tmt.dao.dto.LoginFlatDTO;
import com.accenture.tmt.presentation.dto.LoginDTO;


public class LoginController {
	
      public LoginDTO checkLogin(LoginDTO login){
    	  
    	  LoginFlatDTO loginFlatDto = new LoginFlatDTO();
    	  loginFlatDto.setPassWord(login.getPassword());
    	  loginFlatDto.setUserName(login.getUsername());
    	  
    	  LoginDAO loginDAO = new LoginDAO();
    	  LoginFlatDTO returnedloginFlatDto  = loginDAO.validateCredentials(loginFlatDto);
    	  
    	  LoginDTO loginDTO = new LoginDTO();
    	  if( returnedloginFlatDto.getTypeOfUser() != CONSTANTS.NOT_A_USER ){
    	  loginDTO.setPassword(returnedloginFlatDto.getPassWord());
    	  loginDTO.setUsername(returnedloginFlatDto.getUserName());
    	  loginDTO.setUserType(returnedloginFlatDto.getTypeOfUser());
    	  
    	  return loginDTO;
    	  }
    	  else {
    		  loginDTO.setUserType(returnedloginFlatDto.getTypeOfUser());
    	  }
    		  return loginDTO;
      }	
      
     
}
