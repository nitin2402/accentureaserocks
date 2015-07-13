package com.accenture.tmt.presentation.dto;

import java.util.Date;

public class ReportDetailsDTO {
	private Date StartDate;
	private Date EndDate;
	private String status;
	public Date getStartDate() {
		return StartDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
