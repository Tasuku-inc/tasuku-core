package com.tasukuinc.tasukucore.task.dto;

import com.tasukuinc.tasukucore.appuser.dto.AppUserResponse;
import com.tasukuinc.tasukucore.task.model.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskResponse {
	private long taskId;
	private String name;
	private AppUserResponse reporter;
	private AppUserResponse assignee;
	private TaskStatus status;
	private String description;
	//TODO убрать заглушку
	//private Project project;
}
