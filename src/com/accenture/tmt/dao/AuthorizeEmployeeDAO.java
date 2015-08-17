package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;

import com.accenture.tmt.presentation.dto.LoginDTO;
import com.accenture.tmt.dao.dto.LoginFlatDTO;


public class AuthorizeEmployeeDAO {
	 public List<LoginFlatDTO> authorizeDao(){
		List<LoginFlatDTO> list = new ArrayList<LoginFlatDTO>();
		ResultSet rs = null;
		Connection con;
		try {
			con = DBConnection.getConnection();
			if (con != null){
				PreparedStatement st;
				st = con
						.prepareStatement(CONSTANTS.GET_UNAUTHORIZED_EMPLOYEE_QUERY);
				rs = st.executeQuery();
				while(rs.next()){
					LoginFlatDTO dto = new LoginFlatDTO();
				    dto.setLoginId(rs.getString(CONSTANTS.LOGIN_ID));
					dto.setUserName(rs.getString(CONSTANTS.GET_USER_NAME));
					dto.setTypeOfUser(rs.getString(CONSTANTS.USERTYPE));
					dto.setEmployeeId(rs.getString(CONSTANTS.EMPLOYEE_ID));
					dto.setActiveUser(rs.getString(CONSTANTS.ACTIVE_USER));
					dto.setEmployeedesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
					list.add(dto);
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	 
	 
	
         
	 
	 public int updateviewerDAO(LoginDTO dto){
		int rs = 0;
		 Connection con;
		 try {
			con = DBConnection.getConnection();
			 if (con != null){
					PreparedStatement st;
					st = con
							.prepareStatement(CONSTANTS.UPDATE_TYPE_OF_VIEWER_QUERY);
					st.setString(1, dto.getLoginid());
					rs= st.executeUpdate();
					if(rs==1){
						return rs;
					}
			 
 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return rs;
}
	 public int updateuserDAO(LoginDTO dto){
			int rs = 0;
			 Connection con;
			 try {
				con = DBConnection.getConnection();
				 if (con != null){
						PreparedStatement st;
						st = con
								.prepareStatement(CONSTANTS.UPDATE_TYPE_OF_USER_QUERY);
						st.setString(1, dto.getLoginid());
						rs= st.executeUpdate();
						if(rs==1){
							return rs;
						}
				 
	 }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
	} 
	 
	 
	 public int updateadminDAO(LoginDTO dto){
			int rs = 0;
			 Connection con;
			 try {
				con = DBConnection.getConnection();
				 if (con != null){
						PreparedStatement st;
						st = con
								.prepareStatement(CONSTANTS.UPDATE_TYPE_OF_ADMIN_QUERY);
						st.setString(1, dto.getLoginid());
						rs= st.executeUpdate();
						if(rs==1){
							return rs;
						}
				 
	 }
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;
	} 
	 
}
