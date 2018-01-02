package com.dsburroughs.rewardbot.repository;

import com.dsburroughs.rewardbot.model.Task;
import com.dsburroughs.rewardbot.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatusIn(List<TaskStatus> status);
}
