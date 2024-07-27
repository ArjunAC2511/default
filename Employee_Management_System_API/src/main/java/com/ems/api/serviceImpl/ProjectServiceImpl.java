package com.ems.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.api.entity.ProjectEntity;
import com.ems.api.repository.ProjectRepository;
import com.ems.api.service.ProjectService;


@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public ProjectEntity saveProject(ProjectEntity project) {
		ProjectEntity entity = projectRepo.save(project);
		if (entity != null) {
			return entity;
		}
		return null;
	}

	@Override
	public ProjectEntity updateProject(ProjectEntity project, Integer projectId) {
		project.setProjectId(projectId);
		return projectRepo.save(project);

	}

	@Override
	public ProjectEntity getProjectById(Integer projectId) {
		Optional<ProjectEntity> findById = projectRepo.findById(projectId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<ProjectEntity> getAllProjects() {
		return projectRepo.findAll();
	}

	@Override
	public String deleteProjectById(Integer projectId) {

		if (!projectRepo.existsById(projectId)) {
			throw new RuntimeException("Project not found");
		}
		projectRepo.deleteById(projectId);
		return "Project with ID " + projectId + " has been deleted successfully.";
	}
}
