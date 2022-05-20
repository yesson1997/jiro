package com.sonle.jiro.repository;

import com.sonle.jiro.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    @Query("SELECT i FROM Issue i WHERE u.project=?1 ORDER BY u.listPosition LIMIT 1")
    Optional<Issue> findLastIssue(Long projectId);

    List<Issue> findAllByProjectId(Long projectId);
}
