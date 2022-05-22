package com.sonle.jiro.service;

import com.sonle.jiro.entity.Project;
import com.sonle.jiro.entity.Sequence;
import com.sonle.jiro.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final SequenceService sequenceService;

    public ProjectService(ProjectRepository projectRepository, SequenceService sequenceService) {
        this.projectRepository = projectRepository;
        this.sequenceService = sequenceService;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProject(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Transactional
    public Project createProject(String projectName) {
        Project project = new Project();
        project.setName(projectName);
        project.setCreatedAt(LocalDateTime.now());
        project = projectRepository.save(project);
        Sequence sequence = sequenceService.initSequence();
        sequence.setProject(project);
        sequenceService.save(sequence);
        return project;
    }
}
