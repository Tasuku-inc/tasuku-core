package ru.mephi.tasuku.task.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.tasuku.task.controller.dto.TaskCreateRequest;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import ru.mephi.tasuku.task.controller.dto.TaskUpdateRequest;
import ru.mephi.tasuku.task.service.TaskService;

@RestController
@RequiredArgsConstructor
@EnableMethodSecurity
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;
	private final TaskDtoMapper taskDtoMapper;

	@GetMapping("/{taskId}")
	public TaskResponse getTask(@PathVariable long taskId) {
		return taskDtoMapper.objectToDto(taskService.getById(taskId));
	}

	@PreAuthorize("@userConditionEvaluator.canCreateTask(#taskDto.projectId) or hasRole('ADMIN')")
	@PostMapping("/create")
	public long createTask(@Valid @RequestBody TaskCreateRequest taskDto) {
		return taskService.createTask(taskDtoMapper.createDtoToObject(taskDto));
	}

	@PreAuthorize("@userConditionEvaluator.canUpdateTask(#taskId) or hasRole('ADMIN')")
	@PostMapping("{taskId}/update")
	public void updateTask(@PathVariable long taskId,
						   @Valid @RequestBody TaskUpdateRequest taskDto) {
		taskService.updateTask(taskId, taskDtoMapper.updateDtoToObject(taskDto, taskId));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{taskId}/delete")
	public void deleteTask(@PathVariable long taskId) {
		taskService.deleteTask(taskId);
	}
}
