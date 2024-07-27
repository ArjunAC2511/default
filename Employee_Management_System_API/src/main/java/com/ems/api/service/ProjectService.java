package com.ems.api.service;

import java.util.List;

import com.ems.api.entity.ProjectEntity;



public interface ProjectService {

	public ProjectEntity saveProject(ProjectEntity project);

	public ProjectEntity updateProject(ProjectEntity project,Integer projectId);

	public ProjectEntity getProjectById(Integer projectId);

	public List<ProjectEntity> getAllProjects();

	public String deleteProjectById(Integer projectId);
}
