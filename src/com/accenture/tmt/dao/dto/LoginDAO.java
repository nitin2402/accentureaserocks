package com.accenture.tmt.dao.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.common.ValidateObjects;
import com.accenture.tmt.presentation.dto.LoginFlatDTO;


public class LoginDAO {

	public LoginFlatDTO validateCredentials(LoginFlatDTO loginFlatDto) {
		LoginFlatDTO flatDTO = new LoginFlatDTO();
		ResultSet rs = null;
		try {
			Connection con = DBConnection.connect();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.LOGIN_CHECK_QUERY);
				if (ValidateObjects.isStringEmpty(loginFlatDto.getUserName())) {
					st.setString(1, loginFlatDto.getUserName());
				}
				if (ValidateObjects.isStringEmpty(loginFlatDto.getPassWord())) {
					st.setString(2, loginFlatDto.getPassWord());
				}
				rs = st.executeQuery();
				if (rs.next() == true) {
					flatDTO.setPassWord(rs.getString(""));
					flatDTO.setTypeOfUser(rs.getString(""));
					flatDTO.setUserName(rs.getString(""));
				} else {

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flatDTO;

	}

}
