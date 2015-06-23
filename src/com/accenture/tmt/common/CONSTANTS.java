package com.accenture.tmt.common;

public interface CONSTANTS {
      public String LOGIN_CHECK_QUERY = "select * from Admin where userName=? AND password=? ";
	public String DATA_FIELD_ADMIN = "Admin";
	public String USER_NAME="USERNAME";
	public String PASS_WORD="PASSWORD";
	public String EMPLOYEE_NAME = "EmployeeName";
	public String EMPLOYEE_ID = "EmployeeId";
	public String EMPLOYEE_LEVEL = "EmployeeLevel";
	public String EMPLOYEE_DESIGNATION = "EmployeeDesignation";
	public String EMPLOYEE_ATTID = "EmployeeAttId";
	public String EMPLOYEE_EMAIL = "EmployeeEmail";
	public String EMPLOYEE_EXPERTISE = "EmployeeExpertise";
	public String TEAM_ID = "TeamId";
	public String EMPLOYEE_INSERT = "insert into Employee (EmployeeId,EmployeeName,EmployeeDesignation,EmployeeLevel,EmployeeExpertise,EmployeeAttId,EmployeeEmail) values(?,?,?,?,?,?,?)";
	public String SHEET_NO = "sheetno";
	public String FILE_NAME = "file1";
	public String UPDATE_QUERY = "UPDATE Employee SET EmployeeName=?,EmployeeLevel=?,EmployeeDesignation=?,EmployeeExpertise=?,EmployeeAttId=?,EmployeeEmail=? WHERE EmployeeId=?";
	public String SEARCH_EMPLOYEE = 
		"	SELECT Employee.EmployeeId, Employee.EmployeeName, Team.TeamName,"
		+ "Employee.EmployeeLevel, Employee.EmployeeDesignation,Employee.EmployeeExpertise, "
		+ "Employee.EmployeeAttId, Employee.EmployeeEmail, ModuleDetail.ModuleName, ProjectDetail.ProjectName"+
			" FROM Employee"+
			" LEFT JOIN Team"+
			" ON Employee.TeamId=Team.TeamId"+
			" LEFT JOIN ModuleDetail ON Team.ModuleId=ModuleDetail.ModuleId"+
			" LEFT JOIN ProjectDetail ON ModuleDetail.ProjectId=ProjectDetail.ProjectId"
			+ " WHERE Employee.EmployeeName LIKE ? ";
	
	public String TEAM_NAME = "TeamName";
	public String PROJECT = "ProjectName";
	public String MODULE_NAME = "ModuleName";
	public String VIEW_EMPLOYEE_QUERY = "	SELECT Employee.*, Team.TeamName,"
	
		+ " ModuleDetail.ModuleName, ProjectDetail.ProjectName"+
			" FROM Employee"+
			" LEFT JOIN Team"+
			" ON Employee.TeamId=Team.TeamId"+
			" LEFT JOIN ModuleDetail ON Team.ModuleId=ModuleDetail.ModuleId"+
			" LEFT JOIN ProjectDetail ON ModuleDetail.ProjectId=ProjectDetail.ProjectId"
			;
	public String MODULE_FETCH = "SELECT ModuleName FROM ModuleDetail";
	public String MODULE_DETAIL_FETCH = "SELECT ModuleDetail.*,ProjectDetail.ProjectName FROM ModuleDetail INNER JOIN ProjectDetail ON "
			+ "ModuleDetail.ProjectId=ProjectDetail.ProjectId"
			+ " where ModuleName=?";
	public String PROJECT_ID = "ProjectId";
	public String MODULE_DESCRIPTION = "ModuleDescription";
	public String MODULE_ID = "ModuleId";
	public String MODULE_UPDATE = "UPDATE ModuleDetail SET ModuleName=?,ProjectId=?,ModuleDescription=? WHERE ModuleId=?";
	public String TEAM_DETAIL_FETCH = "SELECT Team.*,ModuleDetail.ModuleName FROM Team INNER JOIN ModuleDetail ON "
			+ "Team.ModuleId=ModuleDetail.ModuleId"
			+ " where TeamId=?" + " AND Status='Y'";
	public String TEAM_DESCRIPTION = "TeamDescription";
	public String UPDATE_BUDGET = "UPDATE BudgetDetail SET BudgetValue=? WHERE Designation=?";
	public String FETCH_MODULE = "SELECT * FROM BudgetDetail ORDER BY Level";
	
	public String TYPE_OF_USER = "typeOfUser";
	public String ADMIN = "ADMIN";
	public String USER = "USER";
	public String VIEWER = "VIEWER";
	public String NOT_A_USER = "NOT_A_USER";
	public String NAME = "name";
	public String NEW_USER = "newuser";
	public String NEW_USER_PASS_WORD = "password";
	public String PASSWORD = "password";
	public String USERNAME = "userName";

	
	
}
