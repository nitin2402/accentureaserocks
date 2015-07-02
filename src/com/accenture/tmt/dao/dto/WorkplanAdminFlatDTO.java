package com.accenture.tmt.dao.dto;

import java.util.List;
import java.util.Map;

public class WorkplanAdminFlatDTO {
	
	private int aseRequested ;
	private int seRequested ;
	private int sseRequested ;
	private int currentASE ;
	private int currentSE ;
	private int currentSSE ;
	private int currentTL ;
	Map<String, List<String>> details ;
	
	public int getAseRequested() {
		return aseRequested;
	}
	public void setAseRequested(int aseRequested) {
		this.aseRequested = aseRequested;
	}
	public int getSeRequested() {
		return seRequested;
	}
	public void setSeRequested(int seRequested) {
		this.seRequested = seRequested;
	}
	public int getSseRequested() {
		return sseRequested;
	}
	public void setSseRequested(int sseRequested) {
		this.sseRequested = sseRequested;
	}
	public int getCurrentASE() {
		return currentASE;
	}
	public void setCurrentASE(int currentASE) {
		this.currentASE = currentASE;
	}
	public int getCurrentSE() {
		return currentSE;
	}
	public void setCurrentSE(int currentSE) {
		this.currentSE = currentSE;
	}
	public int getCurrentSSE() {
		return currentSSE;
	}
	public void setCurrentSSE(int currentSSE) {
		this.currentSSE = currentSSE;
	}
	public int getCurrentTL() {
		return currentTL;
	}
	public void setCurrentTL(int currentTL) {
		this.currentTL = currentTL;
	}
	public Map<String, List<String>> getDetails() {
		return details;
	}
	public void setDetails(Map<String, List<String>> details) {
		this.details = details;
	}
	
}
