package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.binding.repository.ProjectUserRoleRepository;

@RequiredArgsConstructor
@Component
public class UserConditionEvaluator {
	private final ProjectUserRoleRepository projectUserRoleRepository;

	public boolean canWriteToProject (long projectId) {
		SecurityUser user = (SecurityUser) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		long userId = user.getAppUser().getId();
		var projectUserRoles = projectUserRoleRepository
				.searchAllByProjectIdAndUserId(userId, projectId);
		return !projectUserRoles.isEmpty();
	}
}
