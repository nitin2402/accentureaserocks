package com.accenture.tmt.dao.dto;

public class WorkplanFlatDTO {
	
	private String reqId ;
	private String teamId ;
	private int nASE ;
	private int nSE ;
	private int nSSE ;
	private String comment ;
	private int status_id ;
	private String employeeId ;
	private String isSpecificRequest ;
	private String specificRequestEmployeeId ;
	private String specificComment ;
	
	public String isSpecificRequest() {
		return isSpecificRequest;
	}
	public void setSpecificRequest(String isSpecificRequest) {
		this.isSpecificRequest = isSpecificRequest;
	}
	public String getSpecificRequestEmployeeId() {
		return specificRequestEmployeeId;
	}
	public void setSpecificRequestEmployeeId(String specificRequestEmployeeId) {
		this.specificRequestEmployeeId = specificRequestEmployeeId;
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
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
}
