package com.sonle.jiro.entity;

import com.sonle.jiro.domain.Status;

import javax.persistence.*;

@Entity
@Table(name = "app_sequence", schema = "public")
public class Sequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private Integer next;

    public Sequence() {
    }

    public Sequence(Integer next) {
        this.next = next;
    }

    public Sequence(Long id, Project project, Integer next) {
        this.id = id;
        this.project = project;
        this.next = next;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }
}
