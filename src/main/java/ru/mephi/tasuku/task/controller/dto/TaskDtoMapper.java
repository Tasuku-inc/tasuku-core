package ru.mephi.tasuku.task.controller.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.controller.AppUserDtoMapper;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.project.service.ProjectService;
import ru.mephi.tasuku.sprint.service.SprintService;
import ru.mephi.tasuku.task.repository.model.TaskStatus;
import ru.mephi.tasuku.task.service.TaskService;
import ru.mephi.tasuku.task.service.object.Task;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskDtoMapper {
	private final AppUserService appUserService;
	private final SprintService sprintService;
	private final ProjectService projectService;
	private final AppUserDtoMapper appUserDtoMapper;
	private final TaskService taskService;

	public TaskResponse objectToDto(Task object) {
		return TaskResponse.builder()
				.taskId(object.getId())
				.name(object.getName())
				.assignee(appUserDtoMapper.objectToDto(object.getAssignee()))
				.reporter(appUserDtoMapper.objectToDto(object.getReporter()))
				.description(object.getDescription())
				.status(object.getStatus())
				.projectId(object.getProject().getId())
				.sprintId(object.getSprint().getId())
				.build();
	}

	public Task createDtoToObject(TaskCreateRequest dto) {
		return Task.builder()
				.name(dto.getName())
				.assignee(appUserService.getById(dto.getAssigneeId()))
				.status(TaskStatus.OPENED)
				.description(dto.getDescription())
				.sprint(sprintService.getById(dto.getSprintId()))
				.project(projectService.getById(dto.getProjectId()))
				.build();
	}

	public Task updateDtoToObject(TaskUpdateRequest dto, long taskId) {
		Task currentTask = taskService.getById(taskId);

		return Task.builder()
				.id(taskId)
				.project(currentTask.getProject())
				.name(Optional.ofNullable(dto.getName())
						.orElse(currentTask.getName()))
				.assignee(Optional.ofNullable(dto.getAssigneeId())
						.map(appUserService::getById)
						.orElse(currentTask.getAssignee()))
				.reporter(Optional.ofNullable(dto.getReporterId())
						.map(appUserService::getById)
						.orElse(currentTask.getReporter()))
				.status(Optional.ofNullable(dto.getStatus())
						.orElse(currentTask.getStatus()))
				.sprint(Optional.ofNullable(dto.getSprintId())
						.map(sprintService::getById)
						.orElse(currentTask.getSprint()))
				.description(Optional.ofNullable(dto.getDescription())
						.orElse(currentTask.getDescription()))
				.build();
	}
}
