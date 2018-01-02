package com.dsburroughs.rewardbot;

import com.dsburroughs.rewardbot.model.Task;
import com.dsburroughs.rewardbot.model.TaskStatus;
import com.dsburroughs.rewardbot.model.TaskUpdateRequest;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task get(long id);

    long addTask(Task task);

    void updateTask(long id, TaskUpdateRequest status);

    long getTaskStatusCount(TaskStatus status);
}
