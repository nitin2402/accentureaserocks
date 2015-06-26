package com.accenture.tmt.presentation.dto;

import java.sql.Date;


public class EmployeeDetailsDTO {
	private String empId;
	private String empName;
	private String designation;

	private String expertise;
	private String level;
	private String clientId;
	private String email;
	private String teamId;
	private String profCamps;
	private String profProject;
	private String doj;
	private String lastWD;
	private String isBillable;
	private String isActive;
	public String getEmpId() {
		return empId;
	}
	public String getProfCamps() {
		return profCamps;
	}
	public void setProfCamps(String profCamps) {
		this.profCamps = profCamps;
	}
	public String getProfProject() {
		return profProject;
	}
	public void setProfProject(String profProject) {
		this.profProject = profProject;
	}
	
	public String getIsBillable() {
		return isBillable;
	}
	public void setIsBillable(String isBillable) {
		this.isBillable = isBillable;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getLastWD() {
		return lastWD;
	}
	public void setLastWD(String lastWD) {
		this.lastWD = lastWD;
	}

}
