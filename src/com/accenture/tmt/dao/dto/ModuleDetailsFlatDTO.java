package com.accenture.tmt.dao.dto;

public class ModuleDetailsFlatDTO {
	private String moduleName;
	private String projectId;
	private String moduleDescription;
	private String moduleId;
	private String project;
	private String status;
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getModuleDescription() {
		return moduleDescription;
	}
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
