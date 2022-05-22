package com.sonle.jiro.controller.reqres;

import java.util.List;

public class CreateProjectRequest {
    private String projectName;

    private CreateProjectRequest() {
    }

    public CreateProjectRequest(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
