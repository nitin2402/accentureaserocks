package com.accenture.tmt.manager;

import java.sql.SQLException;
import java.util.List;

import com.accenture.tmt.dao.ModuleDAO;
import com.accenture.tmt.dao.dto.ModuleDetailsDTO;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;

public class ModuleController {
	ModuleDAO moduleDAO =new ModuleDAO();
	
	
	public void addModule(ModuleDetailsDTO newModule){
		moduleDAO.addModule(newModule);
	}
	
	public String fetchModuleid(String module){
		String moduleID=moduleDAO.fetchModuleId(module);
		return moduleID;
		}

	public int editModule(String moduleName,String projectId,String moduleDescription,String moduleId){
		int status=moduleDAO.editModule(moduleName, projectId, moduleDescription, moduleId);
		return status;
	}
	
	public String FetchProjectId(String projectName){
		String projectId=moduleDAO.fetchProjectId(projectName);
		return projectId;
		}
		
	public List<ModuleDetailsDTO> fetchModuleDetails(String module)
	{
		List<ModuleDetailsDTO> ModuleDetailsList=moduleDAO.fetchModuleDetails(module);
		return ModuleDetailsList;
	}
	
	public  List<ModuleFormDTO> fetchModuleDetails() {
		List<ModuleFormDTO> list=moduleDAO.fetchModuleDetails();
		return list;
	}
	
	public List<String> FetchModuleByProject(String project) {
		List<String> list=moduleDAO.FetchModuleByProject(project);
		return list;
	}
	public List<String> fetchModule() {
		List<String> moduleList=moduleDAO.fetchModule();
		return moduleList;
	}
	public int deleteModule(String moduleId) throws ClassNotFoundException, SQLException {
		int status=moduleDAO.deleteModule(moduleId);
		return status;
	}
}