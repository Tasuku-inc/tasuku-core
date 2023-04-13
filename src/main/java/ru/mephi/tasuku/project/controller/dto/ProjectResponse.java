package ru.mephi.tasuku.project.controller.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.dto.AppUserResponse;
import ru.mephi.tasuku.binding.dto.ProjectUserRoleResponse;
import ru.mephi.tasuku.sprint.dto.SprintResponse;
import ru.mephi.tasuku.task.dto.TaskResponse;

@Data
@Builder
public class ProjectResponse {
    private long id;
    private String name;
    private boolean closed;
    private AppUserResponse headUser;
    private List<ProjectUserRoleResponse> projectUserRoles;
    private List<TaskResponse> taskModels;
    private List<SprintResponse> sprints;
}
