package com.accenture.tmt.presentation.dto;

import java.sql.Date;

public class SearchFormDTO {
	
	private String EmpName;
	private String EmpId;
	private String level;
	private String clientId;
	private String email;
	private String teamId;
	private String Designation;
	private String Expertise;
	private String ProfCamps;
	private String ProfProject;
	private Date DateOfJoining;
	private Date LastWorkingDay;
	private String Billable;
	private String ActiveUser;
	
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getExpertise() {
		return Expertise;
	}
	public void setExpertise(String expertise) {
		Expertise = expertise;
	}
	public String getProfCamps() {
		return ProfCamps;
	}
	public void setProfCamps(String profCamps) {
		ProfCamps = profCamps;
	}
	public String getProfProject() {
		return ProfProject;
	}
	public void setProfProject(String profProject) {
		ProfProject = profProject;
	}
	public Date getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	public Date getLastWorkingDay() {
		return LastWorkingDay;
	}
	public void setLastWorkingDay(Date lastWorkingDay) {
		LastWorkingDay = lastWorkingDay;
	}
	public String getBillable() {
		return Billable;
	}
	public void setBillable(String billable) {
		Billable = billable;
	}
	public String getActiveUser() {
		return ActiveUser;
	}
	public void setActiveUser(String activeUser) {
		ActiveUser = activeUser;
	}
}
	