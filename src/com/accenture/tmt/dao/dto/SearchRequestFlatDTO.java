package com.accenture.tmt.dao.dto;

public class SearchRequestFlatDTO {
	
	private String reqId ;
	private int nASE ;
	private int nSE ;
	private int nSSE ;
	private String comment ;
	private String statusName ;
	private String teamName;
	private boolean hasSpecificRequest ;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public boolean isHasSpecificRequest() {
		return hasSpecificRequest;
	}
	public void setHasSpecificRequest(boolean hasSpecificRequest) {
		this.hasSpecificRequest = hasSpecificRequest;
	}
}
