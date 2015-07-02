package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.ActionFlatDTO;

public class ActionDAO {

	public int accept(ActionFlatDTO actionflatdto) {
		
		int flag = 0;
		
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.ACCEPT_REQUEST_QUERY);
				st.setString(1, actionflatdto.getReason());
				st.setString(2, actionflatdto.getReqId());
				 flag = st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}

	public int reject(ActionFlatDTO actionflatdto) {
		
int flag = 0;
		
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
						.prepareStatement(CONSTANTS.REJECT_REQUEST_QUERY);
				st.setString(1, actionflatdto.getReason());
				st.setString(2, actionflatdto.getReqId());
				 flag = st.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public int onHold(ActionFlatDTO actionflatdto) {
		
		int flag = 0;
				
				try {
					Connection con = DBConnection.getConnection();
					if (con != null) {
						PreparedStatement st = con
								.prepareStatement(CONSTANTS.ONHOLD_REQUEST_QUERY);
						st.setString(1, actionflatdto.getReason());
						st.setString(2, actionflatdto.getReqId());
						 flag = st.executeUpdate();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return flag;
			}
	
}
