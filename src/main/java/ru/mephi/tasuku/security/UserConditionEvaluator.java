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
		AppUser user = ((SecurityUser) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal()).getAppUser();
		return projectUserRoleService
				.existsByProjectIdAndUserId(projectId, user.getId());
	}

	public boolean canUpdateTask(long taskId) {
		AppUser user = ((SecurityUser) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal()).getAppUser();
		long projectId = taskService.getById(taskId).getProject().getId();
		return projectUserRoleService
				.existsByProjectIdAndUserId(projectId, user.getId());
	}
}
