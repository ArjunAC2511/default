package com.ems.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entity.Project;
import com.ems.repo.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectRepository projectrepo;

    @Override
    public Project createProject(Project project, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                project.setAttachment(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error saving file", e);
            }
        }
        return projectrepo.save(project);
    }

    public List<Project> getAllProjects() {
        return projectrepo.findAll();
    }

    public ResponseEntity<Project> getProjectById(Long projectId) {
        return projectrepo.findById(projectId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public Project updateProject(Long projectId, Project projectDetails, MultipartFile file) {
        Project project = projectrepo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setProjectName(projectDetails.getProjectName());
        project.setProjectDescription(projectDetails.getProjectDescription());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setProjectManager(projectDetails.getProjectManager());
        project.setBudget(projectDetails.getBudget());

        if (file != null && !file.isEmpty()) {
            try {
                project.setAttachment(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error saving file", e);
            }
        } else {
            project.setAttachment(projectDetails.getAttachment());
        }

        return projectrepo.save(project);
    }

    public void deleteProject(Long projectId) {
        projectrepo.deleteById(projectId);
    }
}
