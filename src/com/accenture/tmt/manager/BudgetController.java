package com.accenture.tmt.manager;

import java.util.List;

import com.accenture.tmt.dao.BudgetDAO;
import com.accenture.tmt.dao.dto.BudgetDetailsDTO;

public class BudgetController {
	BudgetDAO budgetDAO =new BudgetDAO();
	
	public int addBudget(String a[]) {
		int status=budgetDAO.addBudget(a);
		return status;
		}

	public List<BudgetDetailsDTO> fetchBudget() {
		// TODO Auto-generated method stub
		List<BudgetDetailsDTO> budgetList =budgetDAO.fetchBudget();
	return budgetList;
	}
}



