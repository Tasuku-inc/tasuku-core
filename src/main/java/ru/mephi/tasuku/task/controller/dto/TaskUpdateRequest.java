package ru.mephi.tasuku.task.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Data
public class TaskUpdateRequest {
	@NotBlank(message = "Task name can't be blank or empty")
	private String name;
	private Long assigneeId;
	private Long reporterId;
	private TaskStatus status;
	private String description;
}
