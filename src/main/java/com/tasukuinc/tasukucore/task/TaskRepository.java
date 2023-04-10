package com.tasukuinc.tasukucore.task;

import com.tasukuinc.tasukucore.task.model.TaskModel;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskModel, Long> {
}
