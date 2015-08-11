package com.accenture.tmt.presentation.dto;

import java.util.List;
import java.util.Map;

public class WorkplanAdminDTO {
	
	private int aseRequested ;
	private int seRequested ;
	private int sseRequested ;
	private Map<String, List<String>> freeASEList ;
	private Map<String, List<String>> freeSEList ;
	private Map<String, List<String>> freeSSEList ;
	private float currentAvg ;
	private float total ;
	private int numberOfEmployee ;
	private String teamName = null ; 
	
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
	public Map<String, List<String>> getFreeASEList() {
		return freeASEList;
	}
	public void setFreeASEList(Map<String, List<String>> freeASEList) {
		this.freeASEList = freeASEList;
	}
	public Map<String, List<String>> getFreeSEList() {
		return freeSEList;
	}
	public void setFreeSEList(Map<String, List<String>> freeSEList) {
		this.freeSEList = freeSEList;
	}
	public Map<String, List<String>> getFreeSSEList() {
		return freeSSEList;
	}
	public void setFreeSSEList(Map<String, List<String>> freeSSEList) {
		this.freeSSEList = freeSSEList;
	}
	public float getCurrentAvg() {
		return currentAvg;
	}
	public void setCurrentAvg(float currentAvg) {
		this.currentAvg = currentAvg;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
