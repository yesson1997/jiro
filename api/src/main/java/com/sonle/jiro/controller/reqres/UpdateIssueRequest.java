package com.sonle.jiro.controller.reqres;

import com.sonle.jiro.domain.Status;

public class UpdateIssueRequest {
    private String title;
    private Status status;
    private Double listPosition;

    public UpdateIssueRequest() {
    }

    public UpdateIssueRequest(String title, Status status, Double listPosition) {
        this.title = title;
        this.status = status;
        this.listPosition = listPosition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
