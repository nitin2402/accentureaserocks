package com.accenture.tmt.dao.dto;

public class WorkplanFlatDTO {
    
	private String reqId ;
	private String teamId ;
	private int nASE ;
	private int nSE ;
	private int nSSE ;
	private String comment ;
	private int status_id ;
	
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
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
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
	
}
