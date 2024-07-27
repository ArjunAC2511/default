package com.ems.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.entity.ProjectEntity;
import com.ems.api.service.ProjectService;


@RestController
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/saveproject")
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectEntity project) {
        ProjectEntity savedProject = projectService.saveProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @PutMapping("/updateproject/{projectId}")
    public ResponseEntity<ProjectEntity> updateProject(
            @RequestBody ProjectEntity project,
            @PathVariable Integer projectId) {
        ProjectEntity updatedProject = projectService.updateProject(project, projectId);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @GetMapping("/getproject/{projectId}")
    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Integer projectId) {
        ProjectEntity project = projectService.getProjectById(projectId);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allprojects")
    public ResponseEntity<List<ProjectEntity>> getAllProjects() {
        List<ProjectEntity> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @DeleteMapping("/deleteproject/{projectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable Integer projectId) {
        try {
            String message = projectService.deleteProjectById(projectId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}