package com.accenture.tmt.manager;

import java.util.List;

import com.accenture.tmt.dao.EmployeeDAO;
import com.accenture.tmt.dao.dto.EmployeeDetailsDTO;
import com.accenture.tmt.presentation.dto.SearchFormDTO;

public class EmployeeController {
	EmployeeDAO employeeDAO= new EmployeeDAO();
	
	public int addEmployee(EmployeeDetailsDTO employeeDetailsDTO) {
		int status=employeeDAO.addEmployee(employeeDetailsDTO);
		return status;
			}
	
	/** zfdfsdfsd
	 * @param employeeDetailsDTO
	 * @return List<SearchFormDTO> - employeeList
	 * @author n.a.saini
	 */
	public List<SearchFormDTO> fetchEmployeeDetails(
			EmployeeDetailsDTO employeeDetailsDTO) {
			List<SearchFormDTO> employeeList = employeeDAO.fetchEmployeeDetails(employeeDetailsDTO);
			return employeeList;
			}
	
	public int fetchEmployeeCount(String team,String desig){
		int empCount=employeeDAO.fetchEmployeeCount(team, desig);
		return empCount;
			}
	
	public List<EmployeeDetailsDTO> FetchEmployeeList(String teamID){
		List<EmployeeDetailsDTO> employeeList=employeeDAO.fetchEmployeeList(teamID);
		return employeeList;
		
	}

	public int EditEmployee(EmployeeDetailsDTO employeeDetailsDTO) {
			int status=employeeDAO.editEmployee(employeeDetailsDTO);
			return status;
		}
	
	public int addEmployeeFinal(String s_empId,String s_team){
		int status=employeeDAO.addEmployeeFinal(s_empId, s_team);
		return status;
		
	}
	
	public List<SearchFormDTO> searchEmployee(String name) {

		List<SearchFormDTO> searchList=employeeDAO.searchEmployee(name);
		return searchList;
		}
	
	public List<EmployeeDetailsDTO> getToAssign(String employee) {

		List<EmployeeDetailsDTO> employeeList=employeeDAO.getToAssign(employee);
				return employeeList;
       }
}
