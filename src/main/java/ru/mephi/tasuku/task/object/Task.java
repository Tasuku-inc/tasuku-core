package ru.mephi.tasuku.task.object;

import ru.mephi.tasuku.appuser.object.AppUser;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.object.Sprint;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mephi.tasuku.task.model.TaskStatus;

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
	private Project project;
}
