package com.accenture.tmt.common;

public interface PROPERTY {
	public String FETCHDETAILS="SELECT Team.TeamId FROM ProjectDetail INNER JOIN ModuleDetail ON ProjectDetail.ProjectId=ModuleDetail.ProjectId INNER JOIN Team ON Team.ModuleId=ModuleDetail.ModuleId where ProjectDetail.ProjectName=? AND ModuleDetail.ModuleName=? AND Team.TeamName=?";
	 public String MODULEDETAILS="SELECT  ModuleDetail.ModuleId FROM FROM ProjectDetail INNER JOIN ModuleDetail ON ProjectDetail.ProjectId=ModuleDetail.ProjectId where ProjectDetail.ProjectName=? AND ModuleDetail.ModuleName=?"
;

}
