package com.tasukuinc.tasukucore.appuser.object;

import com.tasukuinc.tasukucore.appuser.model.SystemRole;
import com.tasukuinc.tasukucore.binding.object.ProjectUserRole;
import com.tasukuinc.tasukucore.task.object.Task;
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
