package ru.mephi.tasuku.task.controller.dto;

import lombok.Data;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Data
public class TaskUpdateRequest {
	private long id;
	private String name;
	private Long assigneeId;
	private Long reporterId;
	private TaskStatus status;
	private String description;
}
