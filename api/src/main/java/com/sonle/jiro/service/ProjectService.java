package com.sonle.jiro.service;

import com.sonle.jiro.entity.Project;
import com.sonle.jiro.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProject(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public Project createProject(String projectName) {
        Project project = new Project();
        project.setName(projectName);
        return projectRepository.save(project);
    }
}
