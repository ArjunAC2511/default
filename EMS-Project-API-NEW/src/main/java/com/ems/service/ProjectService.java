package com.ems.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entity.Project;

public interface ProjectService {
	
	public Project createProject(Project project, MultipartFile file);
	
	public List<Project> getAllProjects();
	
	public ResponseEntity<Project> getProjectById(Long projectId);
	
	 public Project updateProject(Long projectId, Project projectDetails, MultipartFile file);
	
	public void deleteProject(Long projectId);

}
