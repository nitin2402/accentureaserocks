package com.accenture.tmt.dao.dto;

public class LoginFlatDTO {
	private String LoginId;
	private String userName;
	private String passWord;
	private String typeOfUser;
	private String employeeId;
	private String activeUser;
	private String employeedesignation;
	
	public String getLoginId() {
		return LoginId;
	}
	public void setLoginId(String loginId) {
		LoginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}
	public String getEmployeedesignation() {
		return employeedesignation;
	}
	public void setEmployeedesignation(String employeedesignation) {
		this.employeedesignation = employeedesignation;
	}
	
	
}
