package com.tasukuinc.tasukucore.appuser.dto;

import com.tasukuinc.tasukucore.appuser.model.SystemRole;
import com.tasukuinc.tasukucore.binding.dto.ProjectUserRoleResponse;
import com.tasukuinc.tasukucore.task.dto.TaskResponse;
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
