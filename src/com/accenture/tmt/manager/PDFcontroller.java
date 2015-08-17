package com.accenture.tmt.manager;


import com.accenture.tmt.dao.PDFDao;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;

public class PDFcontroller {
	public EmployeeDetailsFlatDTO FetchEmployeeList(String userName){
		PDFDao pdf = new PDFDao();
		EmployeeDetailsFlatDTO emp = pdf.fetchEmployeedetails(userName);
		return emp;
		
	}
}