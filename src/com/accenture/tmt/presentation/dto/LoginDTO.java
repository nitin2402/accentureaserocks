package com.accenture.tmt.presentation.dto;

public class LoginDTO {
	private String loginid;
private String username;
private String password;
private String userType;
private String employeeId;
private String activeUser;
private String employeedesignation;


public String getLoginid() {
	return loginid;
}
public void setLoginid(String loginid) {
	this.loginid = loginid;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
