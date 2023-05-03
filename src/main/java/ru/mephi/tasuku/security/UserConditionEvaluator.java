package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.service.ProjectUserRoleService;
import ru.mephi.tasuku.security.exception.NotAllowedException;
import ru.mephi.tasuku.task.service.TaskService;

@Component
@RequiredArgsConstructor
public class UserConditionEvaluator {
    private final ProjectUserRoleService projectUserRoleService;
    private final TaskService taskService;

    public boolean canCreateTask(long projectId) {
        long appUserId = getAuthAppUser().getId();
        return projectUserRoleService.existsByProjectIdAndUserId(projectId, appUserId);
    }

    public boolean canUpdateTask(long taskId) {
        long appUserId = getAuthAppUser().getId();
        long projectId = taskService.getById(taskId).getProject().getId();
        return projectUserRoleService.existsByProjectIdAndUserId(projectId, appUserId);
    }

    public boolean canUpdateAppUser(long appUserId) {
        long appUserUpdaterId = getAuthAppUser().getId();
        return (appUserId == appUserUpdaterId);
    }

    public static AppUser getAuthAppUser() {
        return ((SecurityUser) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal())
                .getAppUser();
    }
}
