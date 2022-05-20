package com.sonle.jiro.controller.reqres;

import java.util.List;

public class CreateProjectRequest {
    private String projectName;
    private List<String> statusNames;

    private CreateProjectRequest() {
    }

    public CreateProjectRequest(String projectName, List<String> statusNames) {
        this.projectName = projectName;
        this.statusNames = statusNames;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getStatusNames() {
        return statusNames;
    }

    public void setStatusNames(List<String> statusNames) {
        this.statusNames = statusNames;
    }
}
