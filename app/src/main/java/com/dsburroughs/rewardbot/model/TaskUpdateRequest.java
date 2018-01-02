package com.dsburroughs.rewardbot.model;

public class TaskUpdateRequest {

    private TaskStatus status;

    protected TaskUpdateRequest() {
    }

    public TaskUpdateRequest(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
