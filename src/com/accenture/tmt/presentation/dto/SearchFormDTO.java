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
	private String DateOfJoining;
	private String LastWorkingDay;
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
	public String getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	public String getLastWorkingDay() {
		return LastWorkingDay;
	}
	public void setLastWorkingDay(String lastWorkingDay) {
		LastWorkingDay = lastWorkingDay;
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
	