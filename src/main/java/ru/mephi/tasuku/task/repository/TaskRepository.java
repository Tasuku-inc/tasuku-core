package ru.mephi.tasuku.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import ru.mephi.tasuku.task.service.object.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {

	List<TaskModel> findAllByProjectId(long projectId);

	Optional<TaskModel> findByName(String name);

	List<TaskModel> findAllByAssigneeId(long appUserId);

	List<TaskModel> findAllByReporterId(long appUserId);

	List<TaskModel> findAllBySprintId(long sprintId);
}
