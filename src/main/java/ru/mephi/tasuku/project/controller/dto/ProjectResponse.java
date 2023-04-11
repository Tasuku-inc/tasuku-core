package ru.mephi.tasuku.project.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {
    private long id;
    private String name;
    private boolean closed;
//TODO требуется реализация следующих полей
//    private AppUserResponse headUser;
//    private List<ProjectUserRoleResponse> projectUserRoles;
//    private List<TaskResponse> taskModels;
//    private List<SprintResponse> sprints;
}
