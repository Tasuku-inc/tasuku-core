package ru.mephi.tasuku.task.controller;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	@PreAuthorize("@userConditionEvaluator.canUpdateTask(#taskDto.id) or hasRole('ADMIN')")
	@PostMapping("/update")
	public void updateTask(@Valid @RequestBody TaskUpdateRequest taskDto) {
		taskService.updateTask(taskDtoMapper.updateDtoToObject(taskDto));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("delete/{taskId}")
	public void deleteTask(@PathVariable long taskId) {
		taskService.deleteTask(taskId);
	}

	@GetMapping("/{projectId}")
	public List<TaskResponse> getAllByProjectId(@PathVariable long projectId) {
		return taskService.getAllByProjectId(projectId).stream()
				.map(taskDtoMapper::objectToDto)
				.toList();
	}
}
