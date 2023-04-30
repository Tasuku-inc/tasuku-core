package ru.mephi.tasuku.task.service.object;

import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.service.object.Sprint;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Data
@Builder
@ToString
public class Task {
	private Long id;
	private String name;
	private AppUser reporter;
	private AppUser assignee;
	private TaskStatus status;
	private String description;
	private Sprint sprint;
	private Project project;
}
