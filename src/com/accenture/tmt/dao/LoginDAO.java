package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.common.ValidateObjects;
import com.accenture.tmt.dao.dto.LoginFlatDTO;


public class LoginDAO {

	public LoginFlatDTO validateCredentials(LoginFlatDTO loginFlatDto) {
		LoginFlatDTO flatDTO = new LoginFlatDTO();
		ResultSet rs = null;
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.LOGIN_CHECK_QUERY);
				
				if (!ValidateObjects.isStringEmpty(loginFlatDto.getPassWord()) && !ValidateObjects.isStringEmpty(loginFlatDto.getUserName())) {
					st.setString(1, loginFlatDto.getUserName());
					st.setString(2, loginFlatDto.getPassWord());
					rs = st.executeQuery();
					if (rs.next() == true) {
						flatDTO.setPassWord(rs.getString(CONSTANTS.PASSWORD));
						flatDTO.setTypeOfUser(rs.getString(CONSTANTS.TYPE_OF_USER));
						flatDTO.setUserName(rs.getString(CONSTANTS.USERNAME));
					}
					else {
						flatDTO.setTypeOfUser(CONSTANTS.NOT_A_USER);
					return flatDTO;
					}
				}
				else{
					flatDTO.setTypeOfUser(CONSTANTS.NOT_A_USER);
				}
				
				 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flatDTO;

	}
	 
	public boolean UserRegistration(String name, String username, String password) {
	
		try {
			Connection con = DBConnection.getConnection();

			String sqlCheck = "INSERT INTO Admin (AdminName,username,Password) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(sqlCheck);

			st.setString(1, name);
			st.setString(2, username);
			st.setString(3, password);

			int a= st.executeUpdate();
			
		if(a>0)
		{
			return true;
			}
		con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
