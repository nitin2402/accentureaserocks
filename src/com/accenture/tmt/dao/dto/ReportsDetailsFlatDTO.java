package com.accenture.tmt.dao.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ReportsDetailsFlatDTO {
	private String teamName ;
	private String reqId ;
	private int nASE ;
	private int nSE ;
	private int nSSE ;
	private String comment ;
	private String statusName ;
	private String empId;
	private String empName;
	private String timestamp;
	private Date Dates;
	
	public Date getDates() {
		return Dates;
	}
	public void setDates(Date dates) {
		Dates = dates;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
