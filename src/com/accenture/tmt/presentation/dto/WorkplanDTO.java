package com.accenture.tmt.presentation.dto;

public class WorkplanDTO {
	
	private String userName ;
	private String teamName ;
	private int nASE ;
	private int nSE ;
	private int nSSE ;
	private String comment ;
	
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
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
}
