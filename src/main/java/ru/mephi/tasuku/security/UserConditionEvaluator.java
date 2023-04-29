package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.service.ProjectUserRoleService;
import ru.mephi.tasuku.task.service.TaskService;

@Component
@RequiredArgsConstructor
public class UserConditionEvaluator {
	private final ProjectUserRoleService projectUserRoleService;
	private final TaskService taskService;

	public boolean canCreateTask(long projectId) {
		long authAppUserId = getAuthAppUser().getId();
		return projectUserRoleService
				.existsByProjectIdAndUserId(projectId, authAppUserId);
	}

	public boolean canUpdateTask(long taskId) {
		long authAppUserId = getAuthAppUser().getId();
		long projectId = taskService.getById(taskId).getProject().getId();
		return projectUserRoleService
				.existsByProjectIdAndUserId(projectId, authAppUserId);
	}

	public boolean canUpdateAppUser(long appUserId) {
		long authAppUserId = getAuthAppUser().getId();
		return appUserId == authAppUserId;
	}

	public static AppUser getAuthAppUser() {
		return  ((SecurityUser) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal())
				.getAppUser();
	}
}
