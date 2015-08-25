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
import com.accenture.tmt.dao.dto.pieCount;
import com.accenture.tmt.presentation.dto.PieChartDTO;
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

			exception.printStackTrace();
		} finally {

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
					.prepareStatement(CONSTANTS.FETCH_COUNT_DESIG);
			st.setString(1, team);
			st.setString(2, desig);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(CONSTANTS.EMPLOYEE_NAME));
			}
			empCount = list.size();
			con.close();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return empCount;

	}

	public List<EmployeeDetailsFlatDTO> viewEmployee() {
		List<EmployeeDetailsFlatDTO> empList = new ArrayList<EmployeeDetailsFlatDTO>();
		EmployeeDetailsFlatDTO details = null;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement(CONSTANTS.VIEW_EMPLOYEE_QUERY);
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

				details.setIsBillable(rs.getString("Billable"));

				empList.add(details);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return empList;
	}

	public List<EmployeeDetailsFlatDTO> fetchEmployeeList(String empId) {
		List<EmployeeDetailsFlatDTO> employeeList = new ArrayList<EmployeeDetailsFlatDTO>();

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT Employee.*,Team.TeamName FROM Employee inner join Team on Team.TeamId=Employee.TeamId WHERE Employee.EmployeeId=?");
			st.setString(1, empId);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				EmployeeDetailsFlatDTO emp = new EmployeeDetailsFlatDTO();
				emp.setEmpName(rs.getString(CONSTANTS.EMPLOYEE_NAME));
				emp.setEmpId(rs.getString(CONSTANTS.EMPLOYEE_ID));
				emp.setDesignation(rs.getString(CONSTANTS.EMPLOYEE_DESIGNATION));
				emp.setLevel(rs.getString(CONSTANTS.EMPLOYEE_LEVEL));
				emp.setExpertise(rs.getString(CONSTANTS.EMPLOYEE_EXPERTISE));
				emp.setClientId(rs.getString(CONSTANTS.EMPLOYEE_CLIENTID));
				emp.setEmail(rs.getString(CONSTANTS.EMPLOYEE_EMAIL));
				emp.setTeamId(rs.getString(CONSTANTS.TEAM_ID));
				emp.setTeamName(rs.getString(CONSTANTS.TEAM_NAME));
				emp.setProfCamps(rs.getString(CONSTANTS.PROFICIENCY_CAMPS));
				emp.setProfProject(rs.getString(CONSTANTS.PROFICIENCY_PROJECT));
				emp.setDoj(rs.getString(CONSTANTS.DATE_OF_JOINING));
				emp.setIsBillable(rs.getString(CONSTANTS.BILLABLE));
				employeeList.add(emp);
			}

			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

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

			st.setString(2, employeeDetailsDTO.getLevel());

			st.setString(3, employeeDetailsDTO.getDesignation());
			st.setString(4, employeeDetailsDTO.getExpertise());
			st.setString(5, employeeDetailsDTO.getClientId());
			st.setString(6, employeeDetailsDTO.getEmail());
			st.setString(7, employeeDetailsDTO.getProfCamps());
			st.setString(8, employeeDetailsDTO.getProfProject());
			st.setString(9, employeeDetailsDTO.getDoj());
			st.setString(10, employeeDetailsDTO.getIsBillable());
			st.setString(11, employeeDetailsDTO.getEmpId());

			status = st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {

			exception.printStackTrace();
		} finally {

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

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return searchList;

	}

	public int deleteEmployee(String empId) throws ClassNotFoundException,
			SQLException {
		Connection con = DBConnection.getConnection();
		int status = 0;
		try {
			String sqlemp = "UPDATE Employee SET ActiveUser = 'No' WHERE EmployeeId = ?";

			PreparedStatement stemp = con.prepareStatement(sqlemp);
			stemp.setString(1, empId);

			stemp.executeUpdate();

		} finally {
			con.commit();
			con.close();

		}
		return status;

	}

	public List<EmployeeDetailsFlatDTO> getToAssign(String employee) {

		List<EmployeeDetailsFlatDTO> employeeList = new ArrayList<EmployeeDetailsFlatDTO>();

		try {
			Connection con = DBConnection.getConnection();

			EmployeeDetailsFlatDTO search = null;

			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Employee WHERE EmployeeId = ?");

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

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return employeeList;

	}

	public int addEmployeeFinal(String s_empId, String s_team) {
		int status = 0;

		try {
			Connection con = DBConnection.getConnection();

			String sqlInsert = "UPDATE Employee SET TeamId=? WHERE EmployeeId=?; ";

			PreparedStatement st = con.prepareStatement(sqlInsert);

			st.setString(1, s_team);
			st.setString(2, s_empId);
			status = st.executeUpdate();
			con.commit();
			con.close();
		} catch (SQLException | ClassNotFoundException exception) {

			exception.printStackTrace();
		} finally {

		}
		return status;

	}

	public static List<pieCount> fetchPieDetails(PieChartDTO pieDTO) {
		List<pieCount> piechartlist = new ArrayList<pieCount>();
		pieCount pieCount = new pieCount();
		String name = "";
		int count = 0;
		int billable = 0;
		int ASE = 0;
		int SE = 0;
		int SSE = 0;
		int TL = 0;
		int AM = 0;
		int M = 0;
		int angularJS = 0;
		int AT = 0;
		int C_UNIX = 0;
		int FST = 0;
		int HTML = 0;
		int java = 0;
		int JSP = 0;
		int QA = 0;
		int TBD = 0;
		int p0 = 0;
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int p4 = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement(CONSTANTS.GET_PIECHART_DETAILS);
			st.setString(1, pieDTO.getProject());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				name = rs.getString("ProjectName");
				++count;
				if(rs.getString("Billable") != null)
				if (rs.getString("Billable").equals("yes")) {
					++billable;
				}
				if(rs.getString("EmployeeDesignation") != null)
				if (rs.getString("EmployeeDesignation").equals("ASE")) {
					++ASE;
				}
				if(rs.getString("EmployeeDesignation") != null)
				if (rs.getString("EmployeeDesignation").equals("SE")) {
					++SE;
				}
				if(rs.getString("EmployeeDesignation") != null)
				if (rs.getString("EmployeeDesignation").equals("SSE")) {
					++SSE;
				}
				if(rs.getString("EmployeeDesignation") != null)
				if (rs.getString("EmployeeDesignation").equals("TL")) {
					++TL;
				}
				if(rs.getString("EmployeeDesignation") != null)
				if (rs.getString("EmployeeDesignation").equals("AM")) {
					++AM;
				}
				if(rs.getString("EmployeeDesignation") != null)
				if (rs.getString("EmployeeDesignation").equals("M")) {
					++M;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("Angular JS")) {
					++angularJS;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("AT")) {
					++AT;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("C++/Unix")) {
					++C_UNIX;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("FST")) {
					++FST;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("HTML")) {
					++HTML;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("Java")
						|| rs.getString("EmployeeExpertise").equals("JAVA")
						|| rs.getString("EmployeeExpertise").equals("java")) {
					++java;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("JSP")) {
					++JSP;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("QA")) {
					++QA;
				}
				if(rs.getString("EmployeeExpertise") != null)
				if (rs.getString("EmployeeExpertise").equals("TBD")) {
					++TBD;
				}
				if(rs.getString("ProficiencyCams") != null)
				if (rs.getString("ProficiencyCams").equals("P0")) {
					++p0;
				}
				if(rs.getString("ProficiencyCams") != null)
				if (rs.getString("ProficiencyCams").equals("P1")) {
					++p1;
				}
				if(rs.getString("ProficiencyCams") != null)
				if (rs.getString("ProficiencyCams").equals("P2")) {
					++p2;
				}
				if(rs.getString("ProficiencyCams") != null)
				if (rs.getString("ProficiencyCams").equals("P3")) {
					++p3;
				}
				if(rs.getString("ProficiencyCams") != null)
				if (rs.getString("ProficiencyCams").equals("P4")) {
					++p4;
				}

			}

			pieCount.setCount(count);
			pieCount.setBillable(billable);
			pieCount.setASE(ASE);
			pieCount.setSE(SE);
			pieCount.setSSE(SSE);
			pieCount.setTL(TL);
			pieCount.setAM(AM);
			pieCount.setM(M);
			pieCount.setP0(p0);
			pieCount.setP1(p1);
			pieCount.setP2(p2);
			pieCount.setP3(p3);
			pieCount.setP4(p4);

			pieCount.setAngularJS(angularJS);
			pieCount.setAT(AT);
			pieCount.setC_UNIX(C_UNIX);
			pieCount.setFST(FST);
			pieCount.setHTML(HTML);
			pieCount.setJava(java);
			pieCount.setJSP(JSP);
			pieCount.setQA(QA);
			pieCount.setTBD(TBD);

			pieCount.setName(name);

			piechartlist.add(pieCount);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return piechartlist;

	}


	public List<EmployeeDetailsFlatDTO> fetchEmployeeListForTeam(String teamID) {
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

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return employeeList;

	}
	
	
	public List<EmployeeDetailsFlatDTO> fetchEmployeeListForModule(String moduleID){
		List<EmployeeDetailsFlatDTO> employeeList = new ArrayList<EmployeeDetailsFlatDTO>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement st = con
					.prepareStatement(CONSTANTS.GET_EMP_LIST_ON_MODULE_CLICK);
			st.setString(1, moduleID);
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
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
		
	}

}
