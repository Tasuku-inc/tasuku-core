package ru.mephi.tasuku.task.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Data
public class TaskUpdateRequest {
	@NotBlank(message = "Task id can't be blank or empty")
	private long id;
	private String name;
	private Long assigneeId;
	private Long reporterId;
	private TaskStatus status;
	private String description;
}
