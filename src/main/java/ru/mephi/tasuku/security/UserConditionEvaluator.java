package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.binding.service.ProjectUserRoleService;
import ru.mephi.tasuku.security.exception.NotAllowedException;
import ru.mephi.tasuku.task.service.TaskService;

@Component
@RequiredArgsConstructor
public class UserConditionEvaluator {
    private final ProjectUserRoleService projectUserRoleService;
    private final TaskService taskService;

    public boolean canCreateTask(long projectId) {
        long appUserId = getAuthAppUserId();
        if (!projectUserRoleService.existsByProjectIdAndUserId(projectId, appUserId)) {
            throw new NotAllowedException(appUserId);
        }
        return true;
    }

    public boolean canUpdateTask(long taskId) {
        long appUserId = getAuthAppUserId();
        long projectId = taskService.getById(taskId).getProject().getId();
        if (!projectUserRoleService.existsByProjectIdAndUserId(projectId, appUserId)) {
            throw new NotAllowedException(appUserId);
        }
        return true;
    }

    public boolean canUpdateAppUser(long appUserId) {
        long appUserUpdaterId = getAuthAppUserId();
        if (appUserId == appUserUpdaterId) {
            throw new NotAllowedException(appUserUpdaterId);
        }
        return true;
    }

    public long getAuthAppUserId() {
        return ((SecurityUser) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal())
                .getAppUser().getId();
    }
}
