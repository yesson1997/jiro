package com.sonle.jiro.entity;

import com.sonle.jiro.domain.Status;

import javax.persistence.*;

@Entity
@Table(name = "issue", schema = "public")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "project_id")
    private Long projectId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Issue() {
    }

    public Issue(Long id, String title, Long projectId, Status status) {
        this.id = id;
        this.title = title;
        this.projectId = projectId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
