package com.accenture.tmt.manager;

import java.util.List;

import com.accenture.tmt.dao.ProjectDAO;

public class ProjectController {
	
	ProjectDAO projectDAO= new ProjectDAO();
	
	public  List<String> fetchProject(){
		List<String> projectList =projectDAO.fetchProject();
		return projectList;
		
	}

}
