package com.accenture.tmt.dao.dto;

public class RequestStatusFlatDTO {
	private String reqId;
	private String teamName;
	private String noOfASE;
	private String noOfSE; 
	private String noOfSSE; 
	private String reason;
	private String statusName;
	
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
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
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
