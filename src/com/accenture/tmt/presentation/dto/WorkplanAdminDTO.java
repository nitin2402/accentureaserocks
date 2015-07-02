package com.accenture.tmt.presentation.dto;

import java.util.List;
import java.util.Map;

public class WorkplanAdminDTO {
	
	private int aseRequested ;
	private int aseRequestedValue ;
	private int seRequested ;
	private int seRequestedValue ;
	private int sseRequested ;
	private int sseRequestedValue ;
	private int totalRequestedValue ;
	private int currentASE ;
	private int currentASEValue ;
	private int currentSE ;
	private int currentSEValue ;
	private int currentSSE ;
	private int currentSSEValue ;
	private int currentTL ;
	private int currentTLValue ;
	private int totalCurrentValue ;
	private String aseCurrency ;
	private String seCurrency ;
	private String sseCurrency ;
	private String tlCurrency ;
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
	public int getAseRequestedValue() {
		return aseRequestedValue;
	}
	public void setAseRequestedValue(int aseRequestedValue) {
		this.aseRequestedValue = aseRequestedValue;
	}
	public int getSeRequestedValue() {
		return seRequestedValue;
	}
	public void setSeRequestedValue(int seRequestedValue) {
		this.seRequestedValue = seRequestedValue;
	}
	public int getSseRequestedValue() {
		return sseRequestedValue;
	}
	public void setSseRequestedValue(int sseRequestedValue) {
		this.sseRequestedValue = sseRequestedValue;
	}
	public int getTotalRequestedValue() {
		return totalRequestedValue;
	}
	public void setTotalRequestedValue(int totalRequestedValue) {
		this.totalRequestedValue = totalRequestedValue;
	}
	public int getCurrentASEValue() {
		return currentASEValue;
	}
	public void setCurrentASEValue(int currentASEValue) {
		this.currentASEValue = currentASEValue;
	}
	public int getCurrentSEValue() {
		return currentSEValue;
	}
	public void setCurrentSEValue(int currentSEValue) {
		this.currentSEValue = currentSEValue;
	}
	public int getCurrentSSEValue() {
		return currentSSEValue;
	}
	public void setCurrentSSEValue(int currentSSEValue) {
		this.currentSSEValue = currentSSEValue;
	}
	public int getCurrentTLValue() {
		return currentTLValue;
	}
	public void setCurrentTLValue(int currentTLValue) {
		this.currentTLValue = currentTLValue;
	}
	public int getTotalCurrentValue() {
		return totalCurrentValue;
	}
	public void setTotalCurrentValue(int totalCurrentValue) {
		this.totalCurrentValue = totalCurrentValue;
	}
	public String getAseCurrency() {
		return aseCurrency;
	}
	public void setAseCurrency(String aseCurrency) {
		this.aseCurrency = aseCurrency;
	}
	public String getSeCurrency() {
		return seCurrency;
	}
	public void setSeCurrency(String seCurrency) {
		this.seCurrency = seCurrency;
	}
	public String getSseCurrency() {
		return sseCurrency;
	}
	public void setSseCurrency(String sseCurrency) {
		this.sseCurrency = sseCurrency;
	}
	public String getTlCurrency() {
		return tlCurrency;
	}
	public void setTlCurrency(String tlCurrency) {
		this.tlCurrency = tlCurrency;
	}

}
