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
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.presentation.dto.SearchFormDTO;

public class EmployeeDAO {

	public int addEmployee(EmployeeDetailsFlatDTO empDetailFlatDTO) {
		int a = 0;
		try {
			Connection con = DBConnection.getConnection();

			PreparedStatement st = con
					.prepareStatement(CONSTANTS.EMPLOYEE_INSERT);
			st.setString(1, empDetailFlatDTO.getEmpId());
			st.setString(2, empDetailFlatDTO.getEmpName());
			st.setString(3, empDetailFlatDTO.getDesignation());
			st.setString(4, empDetailFlatDTO.getLevel());
			st.setString(5, empDetailFlatDTO.getExpertise());
			st.setString(6, empDetailFlatDTO.getClientId());
			st.setString(7, empDetailFlatDTO.getEmail());
			st.setString(8, empDetailFlatDTO.getTeamId());
			st.setString(9, empDetailFlatDTO.getProfCamps());
			st.setString(10, empDetailFlatDTO.getProfProject());
			st.setString(11, empDetailFlatDTO.getDoj());
			st.setString(12, empDetailFlatDTO.getLastWD());
			st.setString(13, empDetailFlatDTO.getIsBillable());
			st.setString(14, empDetailFlatDTO.getIsActive());
			st.setString(15, empDetailFlatDTO.getCost());
			a = st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		} finally {

			// TODO: release connection
		}
		return a;
	}

	public List<SearchFormDTO> fetchEmployeeDetails(
			EmployeeDetailsFlatDTO employeeDetailsDTO) {
		List<SearchFormDTO> employeeList = new ArrayList<SearchFormDTO>();
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(CONSTANTS.VIEW_EMPLOYEE_QUERY);
			SearchFormDTO searchDetailsDTO = null;
			while (rs.next()) {
				searchDetailsDTO = new SearchFormDTO();
				searchDetailsDTO.setEmpName(rs
						.getString(CONSTANTS.EMPLOYEE_NAME));
				searchDetailsDTO.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				searchDetailsDTO.setLevel(rs
						.getString(CONSTANTS.EMPLOYEE_LEVEL));
				searchDetailsDTO.setDesignation(rs
						.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				searchDetailsDTO.setExpertise(rs
						.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				searchDetailsDTO.setClientId(rs
						.getString(CONSTANTS.EMPLOYEE_CLIENTID));
				searchDetailsDTO.setEmail(rs
						.getString(CONSTANTS.EMPLOYEE_EMAIL));
				// searchDetailsDTO.setTeamId(teamId);rs.getString(CONSTANTS.TEAM_NAME));
				// searchDetailsDTO.setModule(rs.getString(CONSTANTS.MODULE_NAME));
				// searchDetailsDTO.setProject(rs.getString(CONSTANTS.PROJECT));
				employeeList.add(searchDetailsDTO);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;

	}

	public int fetchEmployeeCount(String team, String desig) {
		int empCount = 0;
		List<String> list = new ArrayList<String>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT EmployeeName FROM Employee WHERE TeamId=? AND EmployeeDesignation = ? ");
			st.setString(1, team);
			st.setString(2, desig);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("EmployeeName"));
			}
			empCount = list.size();
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

	public List<EmployeeDetailsFlatDTO> viewEmployee() {
		List<EmployeeDetailsFlatDTO> empList = new ArrayList<EmployeeDetailsFlatDTO>();
		EmployeeDetailsFlatDTO details = null;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement(CONSTANTS.VIEW_EMPLOYEE_QUERY);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
			
				details = new EmployeeDetailsFlatDTO();
				details.setEmpId(rs.getString("EmployeeId"));
				details.setEmpName(rs.getString("EmployeeName"));
				details.setDesignation(rs.getString("EmployeeDesignation"));
				details.setLevel(rs.getString("EmployeeLevel"));
				details.setExpertise(rs.getString("EmployeeExpertise"));
				details.setClientId(rs.getString("EmployeeClientId"));
				details.setEmail(rs.getString("EmployeeEmail"));
				details.setTeamName(rs.getString("TeamName"));
				details.setProfCamps(rs.getString("ProficiencyCams"));
				details.setProfProject(rs.getString("ProficiencyProject"));
				details.setDoj(rs.getString("DateofJoining"));
				/* details.setLastWD(rs.getString("LastWorkingDay")); */
				details.setIsBillable(rs.getString("Billable"));
				/* details.setIsActive(rs.getNString("ActiveUser")); */

				empList.add(details);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	public List<EmployeeDetailsFlatDTO> fetchEmployeeList(String teamID) {
		List<EmployeeDetailsFlatDTO> employeeList = new ArrayList<EmployeeDetailsFlatDTO>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Employee WHERE TeamId=? ");
			st.setString(1, teamID);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				EmployeeDetailsFlatDTO emp = new EmployeeDetailsFlatDTO();
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

	public int editEmployee(EmployeeDetailsFlatDTO employeeDetailsDTO) {
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
			st.setString(5, employeeDetailsDTO.getClientId());
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
				search.setDesignation(rs
						.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				search.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				search.setClientId(rs.getString(CONSTANTS.EMPLOYEE_CLIENTID));
				search.setEmail(rs.getString(CONSTANTS.EMPLOYEE_EMAIL));
				search.setTeamId(rs.getString(CONSTANTS.TEAM_ID));
				search.setProfCamps(rs.getString(CONSTANTS.PROFICIENCY_CAMPS));
				search.setProfProject(rs
						.getString(CONSTANTS.PROFICIENCY_PROJECT));
				search.setDateOfJoining(rs.getString(CONSTANTS.DATE_OF_JOINING));
				search.setLastWorkingDay(rs
						.getString(CONSTANTS.LAST_WORKING_DAY));
				search.setBillable(rs.getString(CONSTANTS.BILLABLE));
				search.setActiveUser(rs.getString(CONSTANTS.ACTIVE_USER));
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

	public List<EmployeeDetailsFlatDTO> getToAssign(String employee) {

		List<EmployeeDetailsFlatDTO> employeeList = new ArrayList<EmployeeDetailsFlatDTO>();

		try {
			Connection con = DBConnection.getConnection();

			EmployeeDetailsFlatDTO search = null;

			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Employee WHERE EmployeeId = ?");

			// System.out.println("%"+name+"%");
			System.out.println(employee);
			st.setString(1, employee);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				search = new EmployeeDetailsFlatDTO();
				search.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				search.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				search.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));
				search.setDesignation(rs
						.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				search.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				search.setClientId(rs.getString(CONSTANTS.EMPLOYEE_CLIENTID));
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

	public int addEmployeeFinal(String s_empId, String s_team) {
		int status = 0;

		// ModuleManager moduleId = new ModuleManager();

		// TeamManager teamId = new TeamManager();

		try {
			Connection con = DBConnection.getConnection();

			String sqlInsert = "UPDATE Employee SET TeamId=? WHERE EmployeeId=?; ";

			PreparedStatement st = con.prepareStatement(sqlInsert);
			/*
			 * st.setString(1, s_empName);
			 * 
			 * // System.out.println(empDetailDo.getEmpId()); st.setString(3,
			 * s_level); // System.out.println(empDetailDo.getLevel());
			 * st.setString(4, s_designation); st.setString(5, s_experience);
			 * st.setString(6, s_expertise);
			 */

			st.setString(1, s_team);
			st.setString(2, s_empId);
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

}
