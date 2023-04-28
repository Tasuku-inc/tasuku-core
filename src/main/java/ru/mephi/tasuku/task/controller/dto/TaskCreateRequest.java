package ru.mephi.tasuku.task.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class TaskCreateRequest {
	@NotBlank(message = "Task name can't be blank or empty")
	@NotNull(message = "Task name can't be null")
	private String name;
	private Long assigneeId;
	@NotNull(message = "ProjectId can't be null")
	private Long projectId;
	private Long sprintId;
	@NotNull(message = "Description can't be null")
	private String description;
}
