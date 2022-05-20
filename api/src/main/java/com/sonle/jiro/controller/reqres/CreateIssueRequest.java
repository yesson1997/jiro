package com.sonle.jiro.controller.reqres;

public class CreateIssueRequest {
    private String title;

    public CreateIssueRequest() {
    }

    public CreateIssueRequest(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
