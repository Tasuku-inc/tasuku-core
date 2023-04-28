package ru.mephi.tasuku.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.task.repository.model.TaskModel;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
	List<TaskModel> findAllByProjectId(long projectId);

	Optional<TaskModel> findByName(String name);
}
