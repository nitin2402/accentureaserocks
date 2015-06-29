package com.accenture.tmt.dao.dto;

public class RequestStatusFlatDTO {
	private String reqId;
	private String teamId;
	private String noOfASE;
	private String noOfSE; 
	private String noOfSSE; 
	private String comments;
	private String statusName;
	
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
	public String getNoOfASE() {
		return noOfASE;
	}
	public void setNoOfASE(String noOfASE) {
		this.noOfASE = noOfASE;
	}
	public String getNoOfSE() {
		return noOfSE;
	}
	public void setNoOfSE(String noOfSE) {
		this.noOfSE = noOfSE;
	}
	public String getNoOfSSE() {
		return noOfSSE;
	}
	public void setNoOfSSE(String noOfSSE) {
		this.noOfSSE = noOfSSE;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
