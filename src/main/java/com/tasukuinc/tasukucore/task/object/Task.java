package com.tasukuinc.tasukucore.task.object;

import com.tasukuinc.tasukucore.appuser.object.AppUser;
import com.tasukuinc.tasukucore.sprint.object.Sprint;
import com.tasukuinc.tasukucore.task.model.TaskStatus;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Task {
	private long id;
	private String name;
	private AppUser reporter;
	private AppUser assignee;
	private TaskStatus status;
	private String description;
	private Sprint sprint;
	//TODO убрать заглушку
	//private Project project;
}
