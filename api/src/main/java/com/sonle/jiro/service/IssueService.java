package com.sonle.jiro.service;

import com.sonle.jiro.entity.Issue;
import com.sonle.jiro.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<Issue> getIssuesByProjectId(Long projectId) {
        return issueRepository.findAllByProjectId(projectId);
    }

    public Optional<Issue> getIssueById(Long issueId) {
        return issueRepository.findById(issueId);
    }

    public Issue create(Long projectId, String title) {
        return null;
    }
}
