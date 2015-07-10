package com.accenture.tmt.manager;

import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.dao.ProjectDAO;
import com.accenture.tmt.presentation.dto.ProjectDTO;

public class ProjectController {
	
	ProjectDAO projectDAO= new ProjectDAO();
	
	public  List<String> fetchProject(){
		List<String> projectList =projectDAO.fetchProject();
		return projectList;
		
	}
	public List<ProjectDTO> currentRelease(){
		List<ProjectDTO> list= new ArrayList<ProjectDTO>();
		list = projectDAO.currentRelease();
		return list;
		
	}
	public List<ProjectDTO> releaseDate(){
		List<ProjectDTO> list= new ArrayList<ProjectDTO>();
		list = projectDAO.releaseDate();
		return list;
	}
}
