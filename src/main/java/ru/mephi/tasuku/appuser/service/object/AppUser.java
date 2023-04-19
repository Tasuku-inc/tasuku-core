package ru.mephi.tasuku.appuser.service.object;

import ru.mephi.tasuku.appuser.repository.model.SystemRole;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;
import ru.mephi.tasuku.task.service.object.Task;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class AppUser {
	private long id;
	private String username;
	private String email;
	private String password;
	private SystemRole systemRole;
	private List<ProjectUserRole> projectUserRoles;
	private List<Task> reportingTasks;
	private List<Task> assignedTasks;
}
