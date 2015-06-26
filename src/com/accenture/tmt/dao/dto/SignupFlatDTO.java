package com.accenture.tmt.dao.dto;

public class SignupFlatDTO {
	private String username;
	private String password;
	private String employeeid;
	private String typeofUser;
	private String ActiveUser;
	
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
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getTypeofUser() {
		return typeofUser;
	}
	public void setTypeofUser(String typeofUser) {
		this.typeofUser = typeofUser;
	}
	public String getActiveUser() {
		return ActiveUser;
	}
	public void setActiveUser(String activeUser) {
		ActiveUser = activeUser;
	}
	
	

}
