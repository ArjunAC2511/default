package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entity.Project;
import com.ems.service.ProjectService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectservice;

    @PostMapping("/save")
    public Project createProject(@RequestPart("project") Project project, @RequestParam("file") MultipartFile file) {
        return projectservice.createProject(project, file);
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectservice.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) {
        return projectservice.getProjectById(projectId);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestPart("project") Project projectDetails, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(projectservice.updateProject(projectId, projectDetails, file));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectservice.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
