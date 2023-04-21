package ru.mephi.tasuku.task.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class TaskCreateRequest {
	private String name;
	private Long assigneeId;
	private Long projectId;
	private Long sprintId;
	private String description;
}
