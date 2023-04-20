package ru.mephi.tasuku.task.controller.dto;

import lombok.Getter;

@Getter
public class TaskCreateRequest {
	private String name;
	private Long assigneeId;
	private Long projectId;
	private Long sprintId;
	private String description;
}
