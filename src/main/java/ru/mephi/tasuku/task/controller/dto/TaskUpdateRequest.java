package ru.mephi.tasuku.task.controller.dto;

import lombok.Getter;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Getter
public class TaskUpdateRequest {
	private String name;
	private Long assigneeId;
	private Long reporterId;
	private TaskStatus status;
	private Long sprintId;
	private String description;
}
