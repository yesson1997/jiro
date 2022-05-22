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

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "list_position")
    private Double listPosition;

    public Issue() {
    }

    public Issue(Long id, String title, Project project, Status status, Double listPosition) {
        this.id = id;
        this.title = title;
        this.project = project;
        this.status = status;
        this.listPosition = listPosition;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getListPosition() {
        return listPosition;
    }

    public void setListPosition(Double listPosition) {
        this.listPosition = listPosition;
    }
}
