package com.accenture.tmt.manager;

import com.accenture.tmt.dao.dto.LoginDAO;
import com.accenture.tmt.presentation.dto.LoginDTO;
import com.accenture.tmt.presentation.dto.LoginFlatDTO;

public class LoginController {
	
      public LoginDTO checkLogin(LoginDTO login){
    	  
    	  LoginFlatDTO loginFlatDto = new LoginFlatDTO();
    	  loginFlatDto.setPassWord(login.getPassword());
    	  loginFlatDto.setUserName(login.getUsername());
    	  LoginDAO loginDAO = new LoginDAO();
    	  LoginFlatDTO returnedloginFlatDto  = loginDAO.validateCredentials(loginFlatDto);
    	  LoginDTO loginDTO = new LoginDTO();
    	  loginDTO.setPassword(returnedloginFlatDto.getPassWord());
    	  loginDTO.setUsername(returnedloginFlatDto.getUserName());
    	  loginDTO.setUserType(returnedloginFlatDto.getTypeOfUser());
    	  return loginDTO;
    	  
      }	
}
