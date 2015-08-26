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
	    public String PROFICIENCY_CAMPS = "ProficiencyCams";
	    public String PROFICIENCY_PROJECT = "ProficiencyProject";
	    public String DATE_OF_JOINING = "DateofJoining";
	    public String LAST_WORKING_DAY = "LastWorkingDay";
	    public String BILLABLE = "Billable";
	    public String ACTIVE_USER = "ActiveUser";
	    public String cost = "LCR";
	    
		

		public String Team_Decs= "TeamDescription";
		public String TEAM_NAME= "TeamName";
		public String Module_Id= "ModuleId";
		public String Module_Name= "ModuleName";
		
		public String Project_Name = "ProjectName";
		public String Current_Release = "CurrentRelease";
		public String Release_Date = "ReleaseDate";
		
		public String Current = 
				" SELECT Project.CurrentRelease, Project.ProjectName, Project.ReleaseDate"
				+ " FROM Project";
		public String Release = 
				" SELECT Project.CurrentRelease, Project.ReleaseDate"
				+" FROM Project";
		public String Current_Edit =
				"UPDATE Project SET CurrentRelease=?, ReleaseDate=? WHERE ProjectName=?";
		/*public String Release_Edit =
				"Update Project SET CurrentRelease=?, ReleaseDate=? WHERE CurrentRelease=?";*/
		public String Current_Fetch =
				"SELECT CurrentRelease, ReleaseDate FROM Project where ProjectName=?";
		public String Release_Fetch =
				"SELECT ReleaseDate FROM Project where ProjectName=?";
		
		
		public String SEARCH_EMPLOYEE = 
				"	SELECT Employee.EmployeeId, Employee.EmployeeName, "
						+ "Employee.EmployeeLevel, Employee.EmployeeDesignation,Employee.EmployeeExpertise, "
						+ "Employee.EmployeeClientId, Employee.EmployeeEmail,Employee.TeamId,"
						+ "Employee.ProficiencyCams, Employee.ProficiencyProject, Employee.ProficiencyProject,"
						+ "Employee.DateofJoining, Employee.LastWorkingDay, Employee.Billable, "
						+ "Employee.ActiveUser"
						+ " FROM Employee"  + " WHERE Employee.EmployeeName LIKE ? AND Employee.ActiveUser='yes'";
		
		public String PROJECT = "ProjectName";
		public String MODULE_NAME = "ModuleName";
		
	public String EMPLOYEE_UPDATE_QUERY = "UPDATE Employee SET EmployeeName=?, EmployeeDesignation=?,EmployeeLevel=?,EmployeeExpertise=?,EmployeeClientId=?,EmployeeEmail=?,TeamName=?,ProficiencyCams=?,ProficiencyProject=?,DateofJoiningBillable=? WHERE EmployeeId=?";
		
		public String VIEW_EMPLOYEE_QUERY = "	SELECT Employee.*, Team.TeamName,"
		
			+ " ModuleDetail.ModuleName, ProjectDetail.ProjectName"+
				" FROM Employee"+
				" LEFT JOIN Team"+
				" ON Employee.TeamId=Team.TeamId"+
				" LEFT JOIN ModuleDetail ON Team.ModuleId=ModuleDetail.ModuleId"+
				" LEFT JOIN ProjectDetail ON ModuleDetail.ProjectId=ProjectDetail.ProjectId"
				 +" WHERE  Employee.ActiveUser='yes'"
				;
		public String MODULE_FETCH = "SELECT ModuleName FROM ModuleDetail";
		public String MODULE_DETAIL_FETCH = "SELECT ModuleDetail.*,ProjectDetail.ProjectName,ProjectDetail.ProjectId FROM ModuleDetail INNER JOIN ProjectDetail ON "
				+ "ModuleDetail.ProjectId=ProjectDetail.ProjectId"
				+ " where ModuleId=?";
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
		public String MODULEID_QUERY = "SELECT ModuleName FROM ModuleDetail WHERE ProjectId=?";
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
		public String TEAM_UPDATE_QUERY = "UPDATE Team SET TeamName=?,TeamId=?,ModuleId=?,TeamDescription=?";
		
		
		public String LOGIN_CHECK_QUERY = "select * from Login where userName=? AND ActiveUser='y'";
	    public String SIGN_UP_CHECK_QUERY = "INSERT INTO Login (username,password,EmployeeId,typeofUser,ActiveUser) VALUES (?,?,?,'UNAUTHORISED','n')";
	    public String SELECT_EMPLOYEE_ID_QUERY = "select * from Employee where EmployeeId=?";
	    public String CHECK_ALREADY_EXIST_USER_QUERY = "select * from Login where EmployeeId=?";
	    public String CHECK_ALREADY_EXIST_USERNAME_QUERY = "select * from Login where userName=?";
	  
	    public String GET_TEAM_LIST_QUERY = "SELECT TeamName FROM TEAM";
	   
	    

		public String EMPLOYEE_INSERT = "insert into Employee (EmployeeId,EmployeeName,EmployeeDesignation,EmployeeLevel,EmployeeExpertise,EmployeeClientId,EmployeeEmail,TeamId,ProficiencyCams,ProficiencyProject,DateofJoining,LastWorkingDay,Billable,ActiveUser,LCR) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public String SHEET_NO = "sheetno";
		public String FILE_NAME = "file1";
		public String UPDATE_QUERY = "UPDATE Employee SET EmployeeName=?,EmployeeLevel=?,EmployeeDesignation=?,EmployeeExpertise=?,EmployeeClientId=?,EmployeeEmail=?,ProficiencyCams=?,ProficiencyProject=?,DateofJoining=?,Billable=? WHERE EmployeeId=?";

		public String INSERT_REQUEST_QUERY = "insert into RequestTable(ReqId, TeamId, No_Of_ASE, No_Of_SE, No_Of_SSE, Comments, Status_ID, EmployeeId, SpecificReq) values(?,?,?,?,?,?,?,?,?)";
		public String INSERT_SPECIFIC_REQUEST_QUERY = "insert into SpecificRequest(ReqId, EmployeeId, SpecificComment) values(?,?,?)";
	    
		public String GET_REQUESTID_QUERY = "select ReqId from RequestTable where TeamId = ?";
	   
	    public String GET_LASTREQID_QUERY = "SELECT COUNT(*) AS NumberOfRows FROM RequestTable";

		public String Get_Project_QUERY = "select ProjectName from ProjectDetail ";
		public String Get_ProjectId_QUERY = "select ProjectId from ProjectDetail where ProjectName = ?";
		public String INSERTMODULE_QUERY = "insert into ModuleDetail(ModuleName,ProjectId,ModuleId,ModuleDescription,Status) values(?,?,?,?,?)";
		public String TEAM_INSERT1 = "insert into Team (TeamName,TeamId,ModuleId,TeamDescription,Status) values(?,?,?,?,?)";
		public String TEAM_INSERT = "insert into Team (TeamName,TeamId,ModuleId,TeamDescription,Status) values(?,?,?,?,?)";
		public String GET_TEAMID_QUERY = "select TeamId from Team WHERE TeamName = ?";
		public String GET_TEAMNAME_QUERY = "select TeamName from Team WHERE TeamId = ?";
		public String GET_EMPLOYEEID_QUERY = "select EmployeeId from Login WHERE UserName = ?";
		
		public String GET_APPROVED_REQUESTS_QUERY = "SELECT R.ReqId, R.No_Of_ASE, R.No_Of_SE, R.No_Of_SSE, R.Comments, S.StatusName, T.teamname, R.SpecificReq FROM RequestTable as R, StatusTable as S, Team T WHERE S.Status_ID = 3 AND S.Status_ID = R.Status_ID AND R.TeamId = T.teamId";
		public String GET_UNAPPROVED_REQUESTS_QUERY = "SELECT R.ReqId, R.No_Of_ASE, R.No_Of_SE, R.No_Of_SSE, R.Comments, S.StatusName, T.teamname, R.SpecificReq FROM RequestTable as R, StatusTable as S, Team T WHERE S.Status_ID != 3 AND S.Status_ID = R.Status_ID AND R.TeamId = T.teamId";
		public String ACCEPT_REQUEST_QUERY = "UPDATE RequestTable SET Status_ID = 3, Reason = ? WHERE ReqId = ?";
		public String REJECT_REQUEST_QUERY = "UPDATE RequestTable SET Status_ID = 4, Reason = ? WHERE ReqId = ?";
		public String ONHOLD_REQUEST_QUERY = "UPDATE RequestTable SET Status_ID = 2, Reason = ? WHERE ReqId = ?";
		
		public String BUDGET_DETAILS_QUERY = "SELECT EmployeeDesignation, Currency, Amount FROM BillabilityTable";
		public String BUDGET_REQUEST_DETAILS_QUERY = "SELECT R.No_Of_ASE, R.No_Of_SE, R.No_Of_SSE, T.TeamName FROM RequestTable R, Team T WHERE R.TeamId = T.TeamId AND ReqId = ? ";
		public String SPECIFIC_REQUEST_QUERY = "SELECT S.EmployeeId, S.SpecificComment, E.EmployeeName, E.LCR, E.EmployeeDesignation FROM SpecificRequest S, Employee E WHERE S.EmployeeId = E.EmployeeId AND S.ReqId = ?";
		public String COUNT_ASE_QUERY = "SELECT COUNT(EmployeeDesignation) AS CURRENT_ASE FROM Employee WHERE TeamId = ? AND EmployeeDesignation = 'Associate Software Engineer'";
		public String COUNT_SE_QUERY = "SELECT COUNT(EmployeeDesignation) AS CURRENT_SE FROM Employee WHERE TeamId = ? AND EmployeeDesignation = 'Software Engineer'";
		public String COUNT_SSE_QUERY = "SELECT COUNT(EmployeeDesignation) AS CURRENT_SSE FROM Employee WHERE TeamId = ? AND EmployeeDesignation = 'Senior Software Engineer'";
		public String COUNT_TL_QUERY = "SELECT COUNT(EmployeeDesignation) AS CURRENT_TL FROM Employee WHERE TeamId = ? AND EmployeeDesignation = 'Team Lead'";
		public String GET_REQUEST_TEAMID_QUERY = "SELECT TeamID from RequestTable where ReqId = ?";
		
		
	public String MODULE_INSERT = "insert into ModuleDetail (ModuleName,ProjectId,ModuleId,ModuleDescription,Status) values(?,?,?,?,?)";
	public String INSERT_MODULE_REPORT_QUERY = "insert into ModuleReport(ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp,Dates) values(?,?,?,?,?,?,?,?)";
	public String GET_MODULE_DETAIL_QUERY = "select ModuleName,ProjectId,ModuleDescription from ModuleDetail where ModuleId = ?";
	public String GET_MODULE_NAME = "ModuleName";
	public String GET_PROJECT_ID = "ProjectId";
	public String GET_MODULE_ID = "ModuleId";
	public String GET_MODULE_DESCRIPTION = "ModuleDescription";
	public String GET_USER_NAME = "Username";
	public String GET_ACTION = "Action";
	public String GET_TIMESTAMP = "Timestamp";
	public String GET_MODULE_LIST_QUERY = "SELECT ModuleName FROM ModuleDetail";
	public String GET_MODULE_NAME_FOR_REPORT = "moduleName";
	public String GET_START_DATE_FOR_MODULE_REPORT = "startDate";
	public String GET_END_DATE_FOR_MODULE_REPORT = "endDate";
	public String GET_MODULE_REPORT = "select * from ModuleReport ";
	public String GET_REPORT_DETAIL_WITHOUT_MODULE_NAME_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where Dates BETWEEN ? AND ? ";
	public String GET_REPORT_DETAIL_WITHOUT_MODULE_NAME_QUERY_WITH_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where Dates BETWEEN ? AND ? AND Action=? ";
	public String GET_REPORT_DETAIL_WITHOUT_START_DATE_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? AND Dates <= ? ";
	public String GET_REPORT_DETAIL_WITHOUT_START_DATE_QUERY_WITH_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? AND Dates <= ? AND Action=?";
	public String GET_REPORT_DETAIL_WITHOUT_END_DATE_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? AND Dates >= ? ";
	public String GET_REPORT_DETAIL_WITHOUT_END_DATE_QUERY_WITH_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? AND Dates >= ? AND Action=? ";
	public String GET_REPORT_DETAIL_WITH_END_DATE_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where  Dates >= ? AND Action=? ";
	public String GET_REPORT_DETAIL_WITH_START_DATE_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where  Dates <=? AND Action=? ";
	public String GET_REPORT_DETAIL_WITH_MODULENAME_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ?  AND Action=? ";
	public String GET_REPORT_DETAIL_WITH_ONLY_END_DATE_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where  Dates <= ? ";
	public String GET_REPORT_DETAIL_WITH_ONLY_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where Action = ?";
	public String GET_REPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? ";
	public String GET_REPORT_DETAIL_WITH_ONLY_START_DATE_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where Dates >= ? ";
	public String GET_REPORT_DETAIL_QUERY = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? AND Dates BETWEEN ? AND ? ";
	public String GET_REPORT_DETAIL_QUERY_WITH_ACTION = "select ModuleName,ProjectId,ModuleId,ModuleDescription,Username,Action,Timestamp from ModuleReport where ModuleName = ? AND Dates BETWEEN ? AND ? AND Action=? ";
	
	
	
	    public String TEAM_REPORT = "select * from TeamReport";
		public String GET_TEAM_NAME_FOR_REPORT = "teamName";
		public String GET_START_DATE_FOR_TEAM_REPORT = "startDate";
		public String GET_END_DATE_FOR_TEAM_REPORT = "endDate";
		public String INSERT_TEAM_REPORT_QUERY = "insert into TeamReport(TeamName,TeamId,ModuleID,TeamDescription,Username,Action,Timestamp,Date)values(?,?,?,?,?,?,?,?)";		
		public String GET_TEAM_NAME = "TeamName";
		public String GET_TEAM_ID = "TeamId";
		
		public String GET_TEAMREPORT_DETAIL_WITHOUT_TEAM_NAME_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where Date BETWEEN ? AND ? ";
		public String GET_TEAMREPORT_DETAIL_WITHOUT_TEAM_NAME_QUERY_WITH_ACTION  = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where Date BETWEEN ? AND ? AND Action=?";
		
		public String GET_TEAMREPORT_DETAIL_WITHOUT_START_DATE_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Date <= ?";
		public String GET_TEAMREPORT_DETAIL_WITHOUT_START_DATE_QUERY_WITH_ACTION = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Date <= ?AND Action=?";

		public String GET_TEAMREPORT_DETAIL_WITHOUT_END_DATE_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Date >= ?";
		public String GET_TEAMREPORT_DETAIL_WITHOUT_END_DATE_QUERY_WITH_ACTION = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Date >= ?AND Action=?";

		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_END_DATE_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where  Date <= ? ";
		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_END_DATE_QUERY_WITH_ACTION = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where  Date <= ? AND Action=?";

		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? ";
		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY_WITH_ACTION = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Action=?";

		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_START_DATE_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where Date >= ? ";
		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_START_DATE_QUERY_WITH_ACTION  = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where Date >= ?AND Action=? ";

		public String GET_TEAMREPORT_DETAIL_WITH_ONLY_ACTION = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where  Action=? ";

		public String GET_TEAMREPORT_DETAIL_QUERY = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Date BETWEEN ? AND ? ";
		public String GET_TEAMREPORT_DETAIL_QUERY_WITH_ACTION = "select TeamName,TeamId,ModuleId,TeamDescription,Username,Action,Timestamp from TeamReport where TeamName = ? AND Date BETWEEN ? AND ? AND Action=?";

		  //employee report query
				public String GET_EMPLOYEE_REPORT_QUERY="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where EmployeeName =? AND Date BETWEEN ? AND ? AND Action =?";
				public String GET_EMPLOYEE_REPORT_QUERY_DESG="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where EmployeeDesignation =? AND Date BETWEEN ? AND ? AND Action =?";
				public String GET_EMPLOYEE_REPORT_QUERY_BILL_action="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where Billable =? AND Date BETWEEN ? AND ? AND Action =?";
				public String INSERT_EMPLOYEE_REPORT_QUERY = "insert into EmployeeReport (EmployeeId,EmployeeName,EmployeeDesignation,EmployeeLevel,EmployeeExpertise,EmployeeClientId,EmployeeEmail,TeamId,ProficiencyCams,ProficiencyProject,DateofJoining,LastWorkingDay,Billable,ActiveUser,LCR,Username,Action,Timestamp,Date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				public String INSERT_EMPLOYEE_REPORT_AUTHORIZED_QUERY = "insert into EmployeeReport (EmployeeId,EmployeeName,EmployeeDesignation,EmployeeLevel,EmployeeExpertise,EmployeeClientId,EmployeeEmail,TeamId,ProficiencyCams,ProficiencyProject,DateofJoining,LastWorkingDay,Billable,ActiveUser,LCR,UserName,Action,AuthorizedAs,TimeStamp,Date) select Employee.EmployeeId,Employee.EmployeeName,"
						+ "Employee.EmployeeDesignation,Employee.EmployeeLevel,Employee.EmployeeExpertise,Employee.EmployeeClientId,Employee.EmployeeEmail,Employee.TeamId,Employee.ProficiencyCams,Employee.ProficiencyProject,Employee.DateofJoining,Employee.LastWorkingDay,Employee.Billable,Employee.ActiveUser,Employee.LCR,?,?,?,?,? from Employee WHERE EmployeeId = ?";
				public String GET_EMPLOYEE_REPORT_QUERY_action="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where  Date BETWEEN ? AND ? AND Action =?";
				public String GET_EMPLOYEE_REPORT_QUERY_emp="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where EmployeeName =? AND Date BETWEEN ? AND ? ";
				public String GET_EMPLOYEE_REPORT_QUERY_DESIGNATION="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where EmployeeDesignation =? AND Date BETWEEN ? AND ? ";
				public String GET_EMPLOYEE_REPORT_QUERY_BILLABILITY="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where Billable =? AND Date BETWEEN ? AND ? ";
				public String GET_EMPLOYEE_REPORT_QUERY_ALL="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where Billable =? AND EmployeeDesignation =? AND Date BETWEEN ? AND ? AND Action =? ";
				public String GET_EMPLOYEE_REPORT_QUERY_BILL_desg="select EmployeeReport.*, Team.TeamName  from EmployeeReport  LEFT JOIN Team ON EmployeeReport.TeamId=Team.TeamId where Billable =? AND EmployeeDesignation =? AND Date BETWEEN ? AND ? ";
				public String GET_EMPLOYEE_REPORT_QUERY_NULL_EMP_NAME="select * from EmployeeReport where EmployeeName LIKE '*' AND Date BETWEEN ? AND ? AND Action=?";
				public String GET_EMPLOYEE_REPORT_QUERY_NULL_ACTION="select * from EmployeeReport where EmployeeName =? AND Date BETWEEN ? AND ? AND Action LIKE '*'";
				public String GET_EMPLOYEE_REPORT_QUERY_NULL_BOTH_NAME_ACTION="select * from EmployeeReport where EmployeeName LIKE ? AND Date BETWEEN ? AND ? AND Action LIKE ?";
				//user request reports query
				public String EMPLOYEE_REPORT = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID ";
				public String GET_EMPLOYEE_REPORT_DETAIL_WITHOUT_START_DATE_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND S.StatusName = ? AND E.Dates <= ? ";
				public String GET_EMPLOYEE_REPORT_DETAIL_WITHOUT_TEAM_NAME_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND E.Dates BETWEEN ? AND ? ";
				public String GET_EMPLOYEE_REPORT_DETAIL_WITHOUT_END_DATE_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND S.StatusName = ? AND E.Dates >= ?";
				public String GET_EMPLOYEE_REPORT_DETAIL_WITH_ONLY_END_DATE_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND E.Dates <= ?";
				public String GET_EMPLOYEE_REPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND S.StatusName = ?";
				public String GET_EMPLOYEE_REPORT_DETAIL_WITH_ONLY_START_DATE_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND E.Dates >= ?";
				public String GET_EMPLOYEE_LIST_QUERY = "SELECT TeamName FROM Team ";
				public String GET_EMPLOYEE_REPORT_DETAIL_QUERY = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID AND S.StatusName = ? AND E.Dates BETWEEN ? AND ? ";
				public String GET_MODULEID_QUERY = "select ModuleId from ModuleDetail WHERE ModuleName = ?";
		
		public String ASSIGN_RESOURCE_QUERY = "UPDATE EMPLOYEE SET TeamId = ? WHERE EmployeeId = ?";
		public String REQUEST_TEAMID_QUERY = "SELECT TEAMID FROM RequestTable WHERE ReqId = ?";
		public String FREE_ASE_LIST_QUERY = "SELECT EmployeeId, EmployeeName, LCR FROM EMPLOYEE WHERE (TeamId = 'TE-021' OR TeamId = 'TE-034' OR TeamId = 'TE-037') AND EmployeeDesignation = 'ASE'";
		public String FREE_SE_LIST_QUERY = "SELECT EmployeeId, EmployeeName, LCR FROM EMPLOYEE WHERE (TeamId = 'TE-021' OR TeamId = 'TE-034' OR TeamId = 'TE-037') AND EmployeeDesignation = 'SE'";
		public String FREE_SSE_LIST_QUERY = "SELECT EmployeeId, EmployeeName, LCR FROM EMPLOYEE WHERE (TeamId = 'TE-021' OR TeamId = 'TE-034' OR TeamId = 'TE-037') AND EmployeeDesignation = 'SSE'";
		public String AVERAGE_LCR_QUERY = "SELECT AVG(Cast(LCR as Float)) AS AVERAGE FROM EMPLOYEE WHERE (TeamId != 'TE-021' AND TeamId != 'TE-034' AND TeamId != 'TE-037')";

		public String TOTAL_LCR_QUERY = "SELECT SUM(Cast(LCR as Float)) AS TOTAL FROM EMPLOYEE WHERE (TeamId != 'TE-021' AND TeamId != 'TE-034' AND TeamId != 'TE-037')";
		public String COUNT_BILLABLE_EMPLOYEE_QUERY = "SELECT COUNT(EmployeeId) AS NumberOfEmployee FROM EMPLOYEE WHERE (TeamId != 'TE-021' AND TeamId != 'TE-034' AND TeamId != 'TE-037')";
		public String GET_ROW_QUERY = "SELECT COUNT(*) AS NumberOfRows FROM Team";
		public String GET_UNAUTHORIZED_EMPLOYEE_QUERY = "select L_ID,Username,TypeOfUser,EmployeeId,ActiveUser,EmployeeDesignation from Login L, Employee E where L.EmployeeId = E.EMployeeId AND TypeOfUser = 'UNAUTHORISED' AND ActiveUser = 'n' ";
		public String UPDATE_TYPE_OF_VIEWER_QUERY = "UPDATE Login SET TypeOfUser = 'VIEWER' , ActiveUser = 'y' where L_ID = ? ";
		public String UPDATE_TYPE_OF_USER_QUERY = "UPDATE Login SET TypeOfUser = 'USER' , ActiveUser = 'y' where L_ID = ? ";
		public String UPDATE_TYPE_OF_ADMIN_QUERY = "UPDATE Login SET TypeOfUser = 'ADMIN' , ActiveUser = 'y' where L_ID = ? ";
		public String GET_PIECHART_DETAILS = "SELECT * FROM Employee INNER JOIN Team ON Team.TeamId=Employee.TeamId INNER JOIN ModuleDetail ON ModuleDetail.ModuleId=Team.ModuleId INNER JOIN ProjectDetail ON ProjectDetail.ProjectId=ModuleDetail.ProjectId WHERE ProjectDetail.ProjectId=?";
	
		 public String GET_LASTMODID_QUERY = "SELECT COUNT(*) AS NumberOfRows FROM ModuleDetail ";
		 
		 public String REQUEST_STATUS_QUERY = "SELECT R.ReqId, T.TeamName, R.No_Of_ASE, R.No_Of_SE, R.No_Of_SSE, R.Reason, S.StatusName FROM RequestTable R, StatusTable S,Login L, Team T WHERE R.Status_ID = S.Status_ID AND R.EmployeeId = L.EmployeeId AND R.TeamId = T.TeamId AND L.Username = ?";
		 public String MODULEDETAILS="SELECT ModuleDetail.ProjectId,ModuleDetail.ModuleId,ModuleDetail.ModuleName FROM (ProjectDetail INNER JOIN ModuleDetail ON ProjectDetail.ProjectId=ModuleDetail.ProjectId)where ModuleDetail.Status='Y'";
		 public String TEAMDETAILS="SELECT Team.ModuleId,Team.TeamId,Team.TeamName FROM (ModuleDetail INNER JOIN Team ON ModuleDetail.ModuleId=Team.ModuleId)where ModuleDetail.Status='Y'";
         public String USERTYPE ="TypeOfUser";
         public String LOGIN_ID ="L_ID";
		public String GET_ALL_REQUEST_REPORT = "select E.ReqId, T.TeamName, E.No_Of_ASE, E.No_Of_SE, E.No_Of_SSE, E.Comments, S.StatusName, E.EmployeeId, E.EmployeeName, E.TimeStamp from EmployeeRequestReportTable as E, StatusTable as S, Team as T WHERE E.TeamId = T.TeamId AND E.Status_ID = S.Status_ID";
		
		public String GET_EMP_LIST_ON_MODULE_CLICK = "select * from Employee INNER JOIN Team ON Team.TeamId=Employee.TeamId INNER JOIN  ModuleDetail ON ModuleDetail.ModuleId=Team.ModuleId WHERE ModuleDetail.ModuleId=?";
		public String FETCH_COUNT_DESIG = "SELECT EmployeeName FROM Employee WHERE TeamId=? AND EmployeeDesignation = ? ";
}

