package com.tasukuinc.tasukucore.task;

import com.tasukuinc.tasukucore.task.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
