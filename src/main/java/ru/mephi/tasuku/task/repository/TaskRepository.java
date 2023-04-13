package ru.mephi.tasuku.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.task.repository.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
