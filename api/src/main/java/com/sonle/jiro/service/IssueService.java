package com.sonle.jiro.service;

import com.sonle.jiro.controller.reqres.UpdateIssueRequest;
import com.sonle.jiro.domain.Status;
import com.sonle.jiro.entity.Issue;
import com.sonle.jiro.entity.Project;
import com.sonle.jiro.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    private final IssueRepository issueRepository;
    private final SequenceService sequenceService;
    private final ProjectService projectService;

    public IssueService(IssueRepository issueRepository, SequenceService sequenceService, ProjectService projectService) {
        this.issueRepository = issueRepository;
        this.sequenceService = sequenceService;
        this.projectService = projectService;
    }

    public List<Issue> getIssuesByProjectId(Long projectId) {
        return issueRepository.findAllByProjectId(projectId);
    }

    public Optional<Issue> getIssueById(Long issueId) {
        return issueRepository.findById(issueId);
    }

    public Issue create(Long projectId, String title) {
        Integer next = sequenceService.nextValueOf(projectId, Status.BACKLOG);
        Project project = projectService.getProject(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid projectId"));
        Issue issue = new Issue();
        issue.setTitle(title);
        issue.setProject(project);
        issue.setStatus(Status.BACKLOG);
        issue.setListPosition((double) next);
        return issueRepository.save(issue);
    }

    public Issue update(UpdateIssueRequest request, Long projectId, Long issueId) {
        Issue issue = issueRepository.findById(issueId).orElseThrow(() -> new IllegalArgumentException("Invalid issueId"));
        issue = updateIssueFromUpdateRequest(request, issue);
        return issueRepository.save(issue);
    }

    private Issue updateIssueFromUpdateRequest(UpdateIssueRequest request, Issue issue) {
        if (request.getTitle() != null && request.getTitle() != "") {
            issue.setTitle(request.getTitle());
        }
        if (request.getStatus() != null) {
            issue.setStatus(request.getStatus());
        }
        if (request.getListPosition() != null) {
            issue.setListPosition(request.getListPosition());
        }
        return issue;
    }
}
