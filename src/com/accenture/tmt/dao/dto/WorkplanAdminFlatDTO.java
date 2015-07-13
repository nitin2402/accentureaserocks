package com.accenture.tmt.dao.dto;

import java.util.Map;

public class WorkplanAdminFlatDTO {
	
	private int aseRequested ;
	private int seRequested ;
	private int sseRequested ;
	private Map<String, Integer> freeASEList ;
	private Map<String, Integer> freeSEList ;
	private Map<String, Integer> freeSSEList ;
	private float currentAvg ;
	private int total ;
	private int numberOfEmployee ;
	
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
	public Map<String, Integer> getFreeASEList() {
		return freeASEList;
	}
	public void setFreeASEList(Map<String, Integer> freeASEList) {
		this.freeASEList = freeASEList;
	}
	public Map<String, Integer> getFreeSEList() {
		return freeSEList;
	}
	public void setFreeSEList(Map<String, Integer> freeSEList) {
		this.freeSEList = freeSEList;
	}
	public Map<String, Integer> getFreeSSEList() {
		return freeSSEList;
	}
	public void setFreeSSEList(Map<String, Integer> freeSSEList) {
		this.freeSSEList = freeSSEList;
	}
	public float getCurrentAvg() {
		return currentAvg;
	}
	public void setCurrentAvg(float currentAvg) {
		this.currentAvg = currentAvg;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	
}
