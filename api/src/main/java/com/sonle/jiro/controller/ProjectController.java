package com.sonle.jiro.controller;

import com.sonle.jiro.controller.reqres.CreateIssueRequest;
import com.sonle.jiro.controller.reqres.CreateProjectRequest;
import com.sonle.jiro.entity.Issue;
import com.sonle.jiro.entity.Project;
import com.sonle.jiro.service.IssueService;
import com.sonle.jiro.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final IssueService issueService;

    public ProjectController(ProjectService projectService, IssueService issueService) {
        this.projectService = projectService;
        this.issueService = issueService;
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProject(@PathVariable Long projectId) {
        Optional<Project> optProject = projectService.getProject(projectId);
        return optProject.map(o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{projectId}/issues")
    public ResponseEntity<List<Issue>> getAllIssues(@PathVariable Long projectId) {
        return ResponseEntity.ok(issueService.getIssuesByProjectId(projectId));
    }

    @GetMapping("/{projectId}/issues/{issueId}")
    public ResponseEntity<Issue> getIssue(@PathVariable Long issueId) {
        Optional<Issue> optIssue = issueService.getIssueById(issueId);
        return optIssue.map(o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectRequest request) {
        return ResponseEntity.ok(projectService.createProject(request.getProjectName()));
    }

    @PostMapping("/{projectId}/issues")
    public ResponseEntity<Issue> createIssue(@PathVariable Long projectId, @RequestBody CreateIssueRequest request) {
        return ResponseEntity.ok(issueService.create(projectId, request.getTitle()));
    }
}
