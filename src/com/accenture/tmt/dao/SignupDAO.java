package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.LoginFlatDTO;


public class SignupDAO {
	public int RegisterInDatabase(LoginFlatDTO signupflatDTO){
		
		ResultSet b = null;
		ResultSet c = null;
		ResultSet d = null;
		try {
			Connection con = DBConnection.getConnection();
			if(con != null){
                PreparedStatement st1 = con.prepareStatement(CONSTANTS.SELECT_EMPLOYEE_ID_QUERY);
                PreparedStatement st2 = con.prepareStatement(CONSTANTS.CHECK_ALREADY_EXIST_USER_QUERY);
				PreparedStatement st3 = con.prepareStatement(CONSTANTS.CHECK_ALREADY_EXIST_USERNAME_QUERY);
				PreparedStatement st = con.prepareStatement(CONSTANTS.SIGN_UP_CHECK_QUERY);
				    st1. setString(1,signupflatDTO.getEmployeeId());
					st2.setString(1, signupflatDTO.getEmployeeId());
					st3.setString(1, signupflatDTO.getUserName());
					st.setString(1, signupflatDTO.getUserName());
					st.setString(2, signupflatDTO.getPassWord());
					st.setString(3, signupflatDTO.getEmployeeId());
					 b = st1.executeQuery();
					 c = st2.executeQuery();
					 d = st3.executeQuery();
					 if(b.next()== true)
					 {	if(c.next()== true)
					  {
						 return 1;
						
					 }
					 else
						 {
						 if(d.next()== true){
							
							 return 2;
						 }
						 else{
							 
						 int a= st.executeUpdate();
					if (a>0)
					{ 
						
						return 0;
						}
						 }
					con.close();
						 }
					 }
					 else{
						
						 return 3;
					 }
			}	
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
	
		} 
		catch (SQLException e) {
		
			System.out.println(e.toString());
		}
		
		return -1;
	}

}



