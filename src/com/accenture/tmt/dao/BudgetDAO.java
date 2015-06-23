package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.BudgetDetailsDTO;

public class BudgetDAO {
	
	public int addBudget(String a[]){
		String b[] = {"Associate Software Engineer", "Software Engineer",
				"Senior Software Engineer", "Team Lead", "Associate Manager",
				"Manager", "Senior Manager" };
		int status=0;
		try {
			for (int i = 0; i < a.length; i++) {

				Connection con = DBConnection.getConnection();
				PreparedStatement st = con.prepareStatement(CONSTANTS.UPDATE_BUDGET);

				st.setString(1, a[i]);
				st.setString(2, b[i]);
				status = st.executeUpdate();
				}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public List<BudgetDetailsDTO> fetchBudget() {
		// TODO Auto-generated method stub
		List<BudgetDetailsDTO> budgetList = new ArrayList<BudgetDetailsDTO>();
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();

	ResultSet rs = st.executeQuery(CONSTANTS.FETCH_MODULE);
		
	while(rs.next())
	{
		BudgetDetailsDTO budget = new BudgetDetailsDTO();
		budget.setDesignation(rs.getString("Designation"));
		budget.setBudgetValue(rs.getString("BudgetValue"));
		budgetList.add(budget);
	}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return budgetList;
	}
}


