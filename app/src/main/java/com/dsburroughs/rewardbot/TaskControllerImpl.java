package com.dsburroughs.rewardbot;

import com.dsburroughs.rewardbot.model.Task;
import com.dsburroughs.rewardbot.model.TaskStatus;
import com.dsburroughs.rewardbot.model.TaskUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task",
        produces = "application/json")
public class TaskControllerImpl {

    private final Logger logger = LoggerFactory.getLogger(TaskControllerImpl.class);

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        logger.info("getAllTasks");
        return taskService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTask(@PathVariable final long id) {
        logger.info("getTask: {}", id);
        return taskService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public long createTask(@RequestBody final Task task) {
        logger.info("createTask: {}", task);
        return taskService.addTask(task);
    }

    @RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
    public void updateStatus(@PathVariable final long id,
                           @RequestBody final TaskUpdateRequest status) {
        logger.info("updateStatus: {}, {}", id, status);
        taskService.updateTask(id, status);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getStatusCount(@RequestParam("status") final TaskStatus status) {
        logger.info("getStatusCount: {}", status);
        return taskService.getTaskStatusCount(status);
    }

}
