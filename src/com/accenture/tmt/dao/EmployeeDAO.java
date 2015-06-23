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
import com.accenture.tmt.dao.dto.EmployeeDetailsDTO;
import com.accenture.tmt.presentation.dto.SearchFormDTO;


public class EmployeeDAO {
	
	public int addEmployee(EmployeeDetailsDTO employeeDetailsDTO){
			int status=0;
		try {
			Connection con = DBConnection.getConnection();
			if (con == null) {
				System.out.println("Connection Not Established");
			} else {
				System.out.println("Connected");
			}
			PreparedStatement st = con.prepareStatement(CONSTANTS.EMPLOYEE_INSERT);
			st.setString(1, employeeDetailsDTO.getEmpId());
			st.setString(2, employeeDetailsDTO.getEmpName());
			// System.out.println(empDetailDo.getEmpId());
			st.setString(3, employeeDetailsDTO.getDesignation());
			// System.out.println(empDetailDo.getLevel());
			st.setString(4, employeeDetailsDTO.getLevel());
			st.setString(5, employeeDetailsDTO.getExpertise());
			st.setString(6, employeeDetailsDTO.getAtt());
			st.setString(7, employeeDetailsDTO.getEmail());
			status = st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
		
			// TODO: release connection
		}
		return status;
		
	}
	
	public List<SearchFormDTO> fetchEmployeeDetails(EmployeeDetailsDTO employeeDetailsDTO){
		List<SearchFormDTO> employeeList = new ArrayList<SearchFormDTO>();
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(CONSTANTS.VIEW_EMPLOYEE_QUERY);
			SearchFormDTO searchDetailsDTO = null;
			while (rs.next()) {
				searchDetailsDTO = new SearchFormDTO();
				searchDetailsDTO.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				searchDetailsDTO.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				searchDetailsDTO.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));
				searchDetailsDTO.setDesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				searchDetailsDTO.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				searchDetailsDTO.setAtt(rs.getString(CONSTANTS.EMPLOYEE_ATTID));
				searchDetailsDTO.setEmail(rs.getString(CONSTANTS.EMPLOYEE_EMAIL));
				searchDetailsDTO.setTeam(rs.getString(CONSTANTS.TEAM_NAME));
				searchDetailsDTO.setModule(rs.getString(CONSTANTS.MODULE_NAME));
				searchDetailsDTO.setProject(rs.getString(CONSTANTS.PROJECT));
				employeeList.add(searchDetailsDTO);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
		
	}
	
	public int fetchEmployeeCount(String team,String desig){
		int empCount=0;
		List<String> list = new ArrayList<String>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT EmployeeName FROM Employee WHERE TeamId=? AND EmployeeDesignation = ? ");
			st.setString(1, team);
			st.setString(2, desig);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				list.add(rs.getString("EmployeeName"));
			}
			empCount=list.size();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empCount;
		
	}
	public List<EmployeeDetailsDTO> fetchEmployeeList(String teamID){
		List<EmployeeDetailsDTO> employeeList = new ArrayList<EmployeeDetailsDTO>();
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM Employee WHERE TeamId=? ");
			st.setString(1, teamID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				EmployeeDetailsDTO emp = new EmployeeDetailsDTO();
				emp.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				emp.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				emp.setDesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				emp.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));
				emp.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				employeeList.add(emp);
			}
			con.close();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return employeeList;
		
	}
	
	public int editEmployee(EmployeeDetailsDTO employeeDetailsDTO){
		int status = 0;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(CONSTANTS.UPDATE_QUERY);
			st.setString(1, employeeDetailsDTO.getEmpName());

			// System.out.println(empDetailDo.getEmpId());
			st.setString(2, employeeDetailsDTO.getLevel());
			// System.out.println(empDetailDo.getLevel());
			st.setString(3, employeeDetailsDTO.getDesignation());
			st.setString(4, employeeDetailsDTO.getExpertise());
			st.setString(5, employeeDetailsDTO.getAtt());
			st.setString(6, employeeDetailsDTO.getEmail());
			st.setString(7, employeeDetailsDTO.getEmpId());
			status = st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			// TODO: release connection
		}
		return status;
	}
	
	public List<SearchFormDTO> searchEmployee(String name) {

		List<SearchFormDTO> searchList = new ArrayList<SearchFormDTO>();
		try {
			Connection con = DBConnection.getConnection();

			SearchFormDTO search = null;

			PreparedStatement st = con
					.prepareStatement(CONSTANTS.SEARCH_EMPLOYEE);

			// System.out.println("%"+name+"%");

			st.setString(1, "%" + name + "%");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				search = new SearchFormDTO();
				search.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				search.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				search.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));
				search.setDesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				search.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				search.setAtt(rs.getString(CONSTANTS.EMPLOYEE_ATTID));
				search.setEmail(rs.getString(CONSTANTS.EMPLOYEE_EMAIL));
				search.setTeam(rs.getString(CONSTANTS.TEAM_NAME));
				search.setModule(rs.getString(CONSTANTS.MODULE_NAME));
				search.setProject(rs.getString(CONSTANTS.PROJECT));
				searchList.add(search);
				
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return searchList;

	}
	
	public List<EmployeeDetailsDTO> getToAssign(String employee) {

		List<EmployeeDetailsDTO> employeeList = new ArrayList<EmployeeDetailsDTO>();

		try {
			Connection con = DBConnection.getConnection();

			EmployeeDetailsDTO search = null;

			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Employee WHERE EmployeeId = ?");

			// System.out.println("%"+name+"%");
			System.out.println(employee);
			st.setString(1, employee);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				search = new EmployeeDetailsDTO();
				search.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				search.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				search.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));
				search.setDesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				search.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				search.setAtt(rs.getString(CONSTANTS.EMPLOYEE_ATTID));
				search.setEmail(rs.getString(CONSTANTS.EMPLOYEE_EMAIL));
				search.setTeamId(rs.getString(CONSTANTS.TEAM_ID));
				

				employeeList.add(search);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeList;

	}
	
	public int addEmployeeFinal(String s_empId,String s_team ){
		int	status=0;
		
//		ModuleManager moduleId = new ModuleManager();
		
//		TeamManager teamId = new TeamManager();
		
		
		try {
			Connection con = DBConnection.getConnection();

			String sqlInsert = "UPDATE Employee SET TeamId=? WHERE EmployeeId=?; ";

			PreparedStatement st = con.prepareStatement(sqlInsert);
		/*	st.setString(1, s_empName);
			
		//	System.out.println(empDetailDo.getEmpId());
			st.setString(3, s_level);
		//	System.out.println(empDetailDo.getLevel());
			st.setString(4, s_designation);
			st.setString(5, s_experience);
			st.setString(6, s_expertise);*/
			
			st.setString(1, s_team);
			st.setString(2, s_empId);
			status=	st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {
			// TODO: release connection
		}
		return status;
		
		
	}
		
	}


