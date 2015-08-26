package com.accenture.tmt.dao.dto;

public class SpecificRequestFlatDTO {
	private String reqId ;
	private String employeeId ;
	private String employeeName ;
	private String LCR ;
	private String employeeDesignation ;
	private String specificComment ;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLCR() {
		return LCR;
	}
	public void setLCR(String lCR) {
		LCR = lCR;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getSpecificComment() {
		return specificComment;
	}
	public void setSpecificComment(String specificComment) {
		this.specificComment = specificComment;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	

}
