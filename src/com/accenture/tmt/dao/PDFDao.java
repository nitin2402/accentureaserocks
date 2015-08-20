package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
public class PDFDao {
	
	public EmployeeDetailsFlatDTO fetchEmployeedetails(String userName) {
		EmployeeDetailsFlatDTO emp = new EmployeeDetailsFlatDTO();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT Employee.EmployeeId,Employee.EmployeeClientId, Employee.EmployeeName, Employee.EmployeeLevel, Employee.EmployeeDesignation, Employee.EmployeeEmail, Employee.LastWorkingDay "
							+"FROM Employee, Login "
							+"where Employee.EmployeeId=Login.EmployeeId "
							+"and Login.UserName=?");
			st.setString(1, userName);
			ResultSet rs = st.executeQuery();
		
			while (rs.next()) {
				
				emp.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				emp.setDesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				emp.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));				
				emp.setEmail(rs.getString(CONSTANTS.EMPLOYEE_EMAIL));
				emp.setLastWD(rs.getString(CONSTANTS.LAST_WORKING_DAY));
				emp.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				emp.setClientId(rs.getString(CONSTANTS.EMPLOYEE_CLIENTID));
				
			}
		
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;

	}
	
	public int rollOffEmployee(String userName) {
		
		Connection con = null;
		int status=0;
		try {
			con = DBConnection.getConnection();
			String sqlemp ="update employee set ActiveUser='No' where employeeId in(select employeeId from login where username =?);";


	PreparedStatement stemp=con.prepareStatement(sqlemp);
	stemp.setString(1, userName);
	
	status = stemp.executeUpdate();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
		
	}
	
}