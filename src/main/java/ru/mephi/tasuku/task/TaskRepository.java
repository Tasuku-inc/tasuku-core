package ru.mephi.tasuku.task;

import ru.mephi.tasuku.task.model.TaskModel;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskModel, Long> {
}