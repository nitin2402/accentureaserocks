package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.common.ValidateObjects;
import com.accenture.tmt.dao.dto.SignupFlatDTO;

public class SignupDAO {
	public int RegisterInDatabase(SignupFlatDTO signupflatDTO){
		//SignupFlatDTO registerflatDTO = new SignupFlatDTO();
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
				    st1. setString(1,signupflatDTO.getEmployeeid());
					st2.setString(1, signupflatDTO.getEmployeeid());
					st3.setString(1, signupflatDTO.getUsername());
					st.setString(1, signupflatDTO.getUsername());
					st.setString(2, signupflatDTO.getPassword());
					st.setString(3, signupflatDTO.getEmployeeid());
					 b = st1.executeQuery();
					 c = st2.executeQuery();
					 d = st3.executeQuery();
					 if(b.next()== true)
					 {	if(c.next()== true)
					 {
						 //System.out.print("User is already signed up..Please Login");
						 return 1;
						
					 }
					 else
						 {
						 if(d.next()== true){
							// System.out.println("already existing username");
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
						// System.out.println("Employeeid does not exist");
						 return 3;
					 }
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		return -1;
	}

}



