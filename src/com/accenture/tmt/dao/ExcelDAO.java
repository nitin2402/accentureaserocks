package com.accenture.tmt.dao;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;








import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;



public class ExcelDAO {
	
	public int addFromExcel(List<EmployeeDetailsFlatDTO> excel){
	Connection con;
	int a = 0;
	
	try {
		con = DBConnection.getConnection();
		for(int i=0;i<excel.size();i++){
		PreparedStatement st = con.prepareStatement(CONSTANTS.EMPLOYEE_INSERT);
				if (excel.get(i).getEmpId() != null) {
					st.setString(1, excel.get(i).getEmpId());
				} else {
					throw new SQLException("primary key cannot be null");
				}

				if (excel.get(i).getEmpName() != null) {
					st.setString(2, excel.get(i).getEmpName());
				} else {
					st.setString(2, "");
				}
				if (excel.get(i).getDesignation() != null) {
					st.setString(3, excel.get(i).getDesignation());
				} else {
					st.setString(3, "");
				}
				if (excel.get(i).getLevel() != null) {
					st.setString(4, excel.get(i).getLevel());
				} else {
					st.setString(4, "");
				}
				if (excel.get(i).getExpertise() != null) {
					st.setString(5, excel.get(i).getExpertise());
				} else {
					st.setString(5, "");
				}
				if (excel.get(i).getClass() != null) {
					st.setString(6, excel.get(i).getClientId());
				} else {
					st.setString(6, "");
				}
				if (excel.get(i).getEmail() != null) {
					st.setString(7, excel.get(i).getEmail());

				} else {
					st.setString(7, "");
				}
				if (excel.get(i).getTeamId() != null) {
					st.setString(8, excel.get(i).getTeamId());

				} else {
					st.setString(8, "");
				}
				if (excel.get(i).getProfCamps() != null) {
					st.setString(9, excel.get(i).getProfCamps());

				} else {
					st.setString(9, "");
				}
				if (excel.get(i).getProfProject() != null) {
					st.setString(10, excel.get(i).getProfProject());

				} else {
					st.setString(10, "");
				}
				if (excel.get(i).getDoj() != null) {
					st.setString(11, excel.get(i).getDoj());

				} else {
					st.setString(11,"");
				}
				if (excel.get(i).getLastWD() != null) {
					st.setString(12, excel.get(i).getLastWD());

				} else {
					st.setString(12, "");
				}
				
		
		if (excel.get(i).getIsBillable() != null) {
			st.setString(13, excel.get(i).getIsBillable());

		} else {
			st.setString(13, "");
		}
		
		if (excel.get(i).getIsActive() != null) {
			st.setString(14, excel.get(i).getIsActive());

		} else {
			st.setString(14, "");
		}
				
				
		a = st.executeUpdate();
		}
		if(a!=0){
			System.out.println("Record Inserted221213`3");
		}
		if(a ==0){
			
		System.out.println("Record insertion failed321141`4");
	}
	
		
		con.commit();
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
}
}