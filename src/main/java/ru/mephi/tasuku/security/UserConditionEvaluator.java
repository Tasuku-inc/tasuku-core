package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.repository.ProjectUserRoleRepository;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRolePk;
import ru.mephi.tasuku.binding.service.ProjectUserRoleService;
import ru.mephi.tasuku.task.service.TaskService;

@Component
@RequiredArgsConstructor
public class UserConditionEvaluator {
	private final ProjectUserRoleService projectUserRoleService;
	private final TaskService taskService;

	public boolean canCreateTask(long projectId) {
		long authAppUserId = getAuthAppUserId();
		return projectUserRoleService
				.existsByProjectIdAndUserId(projectId, authAppUserId);
	}

	public boolean canUpdateTask(long taskId) {
		long authAppUserId = getAuthAppUserId();
		long projectId = taskService.getById(taskId).getProject().getId();
		return projectUserRoleService
				.existsByProjectIdAndUserId(projectId, authAppUserId);
	}

	public boolean canUpdateAppUser(long appUserId) {
		long authAppUserId = getAuthAppUserId();
		return appUserId == authAppUserId;
	}

	public long getAuthAppUserId() {
		return  ((SecurityUser) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal())
				.getAppUser().getId();
	}
}
