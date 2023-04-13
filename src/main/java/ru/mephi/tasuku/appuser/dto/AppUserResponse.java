package ru.mephi.tasuku.appuser.dto;

import ru.mephi.tasuku.appuser.model.SystemRole;
import ru.mephi.tasuku.binding.dto.ProjectUserRoleResponse;
import ru.mephi.tasuku.task.dto.TaskResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppUserResponse {
	private long id;
	private String username;
	private String email;
	private SystemRole systemRole;
	private List<ProjectUserRoleResponse> projectUserRoles;
	private List<TaskResponse> reportingTasks;
	private List<TaskResponse> assignedTasks;
}
