package com.accenture.tmt.presentation.dto;

public class WorkplanDTO {
	
	private String userName ;
	private String teamId ;
	private int nASE ;
	private int nSE ;
	private int nSSE ;
	private String comment ;
	private String isSpecificRequest ;
	private String specificRequestEmployee ;
	private String specificComment ;
	
	public String isSpecificRequest() {
		return isSpecificRequest;
	}
	public void setSpecificRequest(String isSpecificRequest) {
		this.isSpecificRequest = isSpecificRequest;
	}
	public String getSpecificRequestEmployee() {
		return specificRequestEmployee;
	}
	public void setSpecificRequestEmployee(String specificRequestEmployee) {
		this.specificRequestEmployee = specificRequestEmployee;
	}
	public String getSpecificComment() {
		return specificComment;
	}
	public void setSpecificComment(String specificComment) {
		this.specificComment = specificComment;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getnASE() {
		return nASE;
	}
	public void setnASE(int nASE) {
		this.nASE = nASE;
	}
	public int getnSE() {
		return nSE;
	}
	public void setnSE(int nSE) {
		this.nSE = nSE;
	}
	public int getnSSE() {
		return nSSE;
	}
	public void setnSSE(int nSSE) {
		this.nSSE = nSSE;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
}
