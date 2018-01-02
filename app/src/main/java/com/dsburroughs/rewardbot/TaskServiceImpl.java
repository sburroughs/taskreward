package com.dsburroughs.rewardbot;

import com.dsburroughs.rewardbot.model.Task;
import com.dsburroughs.rewardbot.model.TaskStatus;
import com.dsburroughs.rewardbot.model.TaskUpdateRequest;
import com.dsburroughs.rewardbot.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> getAll() {
        return repository.findByStatusIn(
                Arrays.asList(TaskStatus.CREATED, TaskStatus.IN_PROGRESS)
        );
    }

    @Override
    public Task get(long id) {
        return repository.findOne(id);
    }

    @Override
    public long addTask(Task task) {
        return repository.save(task).getId();
    }

    @Override
    public void updateTask(final long id, final TaskUpdateRequest task) {
        final Optional<Task> oldTask = Optional.ofNullable(repository.findOne(id));
        if (oldTask.isPresent()) {
            final Task updated = oldTask.get();
            updated.setStatus(task.getStatus());
            repository.save(updated);
        }
    }

    @Override
    public long getTaskStatusCount(TaskStatus status) {
        return repository.findByStatusIn(Arrays.asList(status))
                .parallelStream()
                .mapToLong(Task::getReward)
                .sum();
    }
}
