package ru.mephi.tasuku.task;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.task.model.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    ////
}
