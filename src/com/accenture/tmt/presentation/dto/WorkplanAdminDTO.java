package com.accenture.tmt.presentation.dto;

import java.util.Map;

public class WorkplanAdminDTO {
	
	private int aseRequested ;
	private int seRequested ;
	private int sseRequested ;
	private Map<String, Float> freeASEList ;
	private Map<String, Float> freeSEList ;
	private Map<String, Float> freeSSEList ;
	private float currentAvg ;
	private float total ;
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
	public Map<String, Float> getFreeASEList() {
		return freeASEList;
	}
	public void setFreeASEList(Map<String, Float> freeASEList2) {
		this.freeASEList = freeASEList2;
	}
	public Map<String, Float> getFreeSEList() {
		return freeSEList;
	}
	public void setFreeSEList(Map<String, Float> freeSEList) {
		this.freeSEList = freeSEList;
	}
	public Map<String, Float> getFreeSSEList() {
		return freeSSEList;
	}
	public void setFreeSSEList(Map<String, Float> freeSSEList) {
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

}
