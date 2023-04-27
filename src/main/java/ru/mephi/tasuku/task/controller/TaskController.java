package ru.mephi.tasuku.task.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.tasuku.task.controller.dto.TaskCreateRequest;
import ru.mephi.tasuku.task.controller.dto.TaskDtoMapper;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import ru.mephi.tasuku.task.controller.dto.TaskUpdateRequest;
import ru.mephi.tasuku.task.service.TaskService;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@EnableMethodSecurity
public class TaskController {
	private final TaskService taskService;
	private final TaskDtoMapper taskDtoMapper;

	@GetMapping("/{taskId}")
	public TaskResponse getTask(@PathVariable long taskId) {
		return taskDtoMapper.objectToDto(
				taskService.getById(taskId)
		);
	}

	@PostMapping("/create")
	@PreAuthorize("@userConditionEvaluator.canCreateTask(#taskDto.projectId) or hasRole('ADMIN')")
	public long createTask(@Valid @RequestBody TaskCreateRequest taskDto) {
		return taskService.createTask(
				taskDtoMapper.createDtoToObject(taskDto)
		);
	}

	@PostMapping("{taskId}/update")
	@PreAuthorize("@userConditionEvaluator.canUpdateTask(#taskId) or hasRole('ADMIN')")
	public void updateTask(@PathVariable long taskId,
						   @Valid @RequestBody TaskUpdateRequest taskDto) {
		taskService.updateTask(
				taskId,
				taskDtoMapper.updateDtoToObject(taskDto, taskId));
	}

	@DeleteMapping("{taskId}/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTask(@PathVariable long taskId) {
		taskService.deleteTask(taskId);
	}
}
