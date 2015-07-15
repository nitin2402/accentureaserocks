package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.EmployeeDAO;
import com.accenture.tmt.dao.WorkplanDAO;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;
import com.accenture.tmt.presentation.dto.SearchFormDTO;

import static java.lang.System.out;
public class EmployeeController {
	EmployeeDAO employeeDAO= new EmployeeDAO();
	
	public int addEmployee(EmployeeDetailsDTO emp)
	{	
		String teamId = null ;
		WorkplanDAO workplanDao = new WorkplanDAO();
		teamId = workplanDao.fetchTeamId(emp.getTeamName());
	
	EmployeeDetailsFlatDTO detailsFDO = new EmployeeDetailsFlatDTO();
	detailsFDO.setEmpId(emp.getEmpId());
	detailsFDO.setEmpName(emp.getEmpName());
	detailsFDO.setLevel(emp.getLevel());
	detailsFDO.setDesignation(emp.getDesignation());
	detailsFDO.setExpertise(emp.getExpertise());
	detailsFDO.setClientId(emp.getClientId());
	detailsFDO.setEmail(emp.getEmail());
	detailsFDO.setTeamId(teamId);
	detailsFDO.setProfCamps(emp.getProfCamps());
	detailsFDO.setProfProject(emp.getProfProject());
	detailsFDO.setDoj(emp.getDoj());
	detailsFDO.setLastWD(emp.getLastWD());
	detailsFDO.setIsBillable(emp.getIsBillable());
	detailsFDO.setIsActive(emp.getIsActive());
	
	detailsFDO.setCost(emp.getCost());
	
	EmployeeDAO dao=new EmployeeDAO();
	int staus=dao.addEmployee(detailsFDO);

	if(staus!=0){
		out.println("Record Inserted");
	}
	if(staus ==0){
		out.println("Record insertion failed");
	
}
	return staus;
	
	}
	
	public List<EmployeeDetailsFlatDTO> viewEmployee(){
		employeeDAO= new EmployeeDAO();
		List<EmployeeDetailsFlatDTO> empList= new ArrayList<EmployeeDetailsFlatDTO>();
		empList = employeeDAO.viewEmployee();
		return empList;
		
	}
public List<String> fetchTeamList(){
		
		WorkplanDAO workplanDao = new WorkplanDAO();
		return workplanDao.getTeamList();
		 
	}
	
	/** zfdfsdfsd
	 * @param employeeDetailsDTO
	 * @return List<SearchFormDTO> - employeeList
	 * @author n.a.saini
	 */
	public List<SearchFormDTO> fetchEmployeeDetails(
			EmployeeDetailsFlatDTO employeeDetailsDTO) {
			List<SearchFormDTO> employeeList = employeeDAO.fetchEmployeeDetails(employeeDetailsDTO);
			return employeeList;
			}
	
	public int fetchEmployeeCount(String team,String desig){
		int empCount=employeeDAO.fetchEmployeeCount(team, desig);
		return empCount;
			}
	
	public List<EmployeeDetailsFlatDTO> FetchEmployeeList(String teamID){
		List<EmployeeDetailsFlatDTO> employeeList=employeeDAO.fetchEmployeeList(teamID);
		return employeeList;
		
	}

	public int EditEmployee(EmployeeDetailsFlatDTO employeeDetailsDTO) {
			int status=employeeDAO.editEmployee(employeeDetailsDTO);
			return status;
		}
	
	public int addEmployeeFinal(String s_empId,String s_team){
		int status=employeeDAO.addEmployeeFinal(s_empId, s_team);
		return status;
		
	}
	
	public List<SearchFormDTO> searchEmployee(String name) {

		
		List<SearchFormDTO> searchlist = new ArrayList<SearchFormDTO>();
		
		searchlist=employeeDAO.searchEmployee(name);
		return searchlist;
		
		}
	
	public List<EmployeeDetailsFlatDTO> getToAssign(String employee) {

		List<EmployeeDetailsFlatDTO> employeeList=employeeDAO.getToAssign(employee);
				return employeeList;
       }
}
