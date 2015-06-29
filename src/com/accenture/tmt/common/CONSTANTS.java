package com.accenture.tmt.common;

public interface CONSTANTS {
      
	public String DATA_FIELD_ADMIN = "Admin";
	public String USER_NAME="USERNAME";
	public String PASS_WORD="PASSWORD";
	public String EMPLOYEE_NAME = "EmployeeName";
	public String EMPLOYEE_ID = "EmployeeId";
	

	public String EMPLOYEE_LEVEL = "EmployeeLevel";
    public String EMPLOYEE_DESIGNATION = "EmployeeDesignation";
    public String EMPLOYEE_CLIENTID = "EmployeeClientId";
    public String EMPLOYEE_EMAIL = "EmployeeEmail";
    public String EMPLOYEE_EXPERTISE = "EmployeeExpertise";
    public String TEAM_ID = "TeamId";
    public String PROFICIENCY_CAMPS = "ProficiencyCamps";
    public String PROFICIENCY_PROJECT = "ProficiencyProject";
    public String DATE_OF_JOINING = "DateofJoining";
    public String LAST_WORKING_DAY = "LastWorkingDay";
    public String BILLABLE = "Billable";
    public String ACTIVE_USER = "ActiveUser";

	

	public String Team_Decs= "TeamDescription";
	public String TEAM_NAME= "TeamName";
	public String Module_Id= "ModuleId";
	
	
	
	public String SEARCH_EMPLOYEE = 
			"	SELECT Employee.EmployeeId, Employee.EmployeeName, "
					+ "Employee.EmployeeLevel, Employee.EmployeeDesignation,Employee.EmployeeExpertise, "
					+ "Employee.EmployeeClientId, Employee.EmployeeEmail,Employee.TeamId,"
					+ "Employee.ProficiencyCamps, Employee.ProficiencyProject, Employee.ProficiencyProject,"
					+ "Employee.DateofJoining, Employee.LastWorkingDay, Employee.Billable, "
					+ "Employee.ActiveUser"
					+ " FROM Employee"  + " WHERE Employee.EmployeeName LIKE ? ";
	
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
	public String NEW_EMPLOYEE_ID = "employeeid";
	public String NEW_USER = "newuser";
	public String NEW_USER_PASS_WORD = "password";
	public String PASSWORD = "password";
	public String USERNAME = "userName";
	public String TEAM_INSERT = "insert into Team (TeamName,TeamId,ModuleId,TeamDescription) values(?,?,?,?)";

	public String TEAM_UPDATE_QUERY = "UPDATE Team SET TeamName=?,TeamId=?,ModuleId=?,TeamDescription=?";
	
	public String GET_UNAPPROVED_REQUESTS_QUERY = "SELECT ReqId, TeamId, No_Of_ASE, No_Of_SE, No_Of_SSE, Comments, StatusName FROM RequestTable as R, StatusTable as S WHERE S.Status_ID = 3 AND S.Status_ID = R.Status_ID";
	public String LOGIN_CHECK_QUERY = "select * from Login where userName=? AND password=? AND ActiveUser='y'";
    public String SIGN_UP_CHECK_QUERY = "INSERT INTO Login (username,password,EmployeeId,typeofUser,ActiveUser) VALUES (?,?,?,'UNAUTHORISED','n')";
    public String SELECT_EMPLOYEE_ID_QUERY = "select * from Employee where EmployeeId=?";
    public String CHECK_ALREADY_EXIST_USER_QUERY = "select * from Login where EmployeeId=?";
    public String CHECK_ALREADY_EXIST_USERNAME_QUERY = "select * from Login where userName=?";
    public String GET_APPROVED_REQUESTS_QUERY = "SELECT ReqId, TeamId, No_Of_ASE, No_Of_SE, No_Of_SSE, Comments, StatusName FROM RequestTable as R, StatusTable as S WHERE S.Status_ID = 3 AND S.Status_ID = R.Status_ID";
	  
    
   
    

	public String EMPLOYEE_INSERT = "insert into Employee (EmployeeId,EmployeeName,EmployeeDesignation,EmployeeLevel,EmployeeExpertise,EmployeeClientId,EmployeeEmail,TeamId,ProficiencyCamps,ProficiencyProject,DateofJoining,LastWorkingDay,Billable,ActiveUser) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public String SHEET_NO = "sheetno";
	public String FILE_NAME = "file1";
	public String UPDATE_QUERY = "UPDATE Employee SET EmployeeName=?,EmployeeLevel=?,EmployeeDesignation=?,EmployeeExpertise=?,EmployeeClientId=?,EmployeeEmail=?,TeamId=?,ProficiencyCamps=?,ProficiencyProject=?,DateofJoining=?,LastWorkingDay=?,Billable=?,ActiveUser=? WHERE EmployeeId=?";

	public String INSERT_REQUEST_QUERY = "insert into RequestTable(ReqId, TeamId, No_Of_ASE, No_Of_SE, No_Of_SSE, Comments, Status_ID) values(?,?,?,?,?,?,?)";
    public String GET_REQUESTID_QUERY = "select ReqId from RequestTable where TeamId = ?";
    public String GET_TEAMID_QUERY = "select TeamId from Team as T, Employee as E, Login as L where L.EmployeeId = E.EmployeeId AND E.TeamId = T.TeamId AND Username = ?";
         public String GET_LASTREQID_QUERY = "SELECT COUNT(*) AS NumberOfRows FROM RequestTable";

	
}


