package ru.mephi.tasuku.project.controller.dto;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.model.AppUserModel;

@Data
@Builder
public class ProjectResponse {
    private long id;
    private String name;
    private AppUserModel headUser;
    private boolean closed;
//TODO требуется реализация следующих полей
//    private List<ProjectUserRoleResponse> projectUserRoles;
//    private List<TaskResponse> taskModels;
//    private List<SprintResponse> sprints;
}
