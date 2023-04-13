package ru.mephi.tasuku.task.controller.dto;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.dto.AppUserResponse;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Data
@Builder
public class TaskResponse {
    private long taskId;
    private String name;
    private AppUserResponse reporter;
    private AppUserResponse assignee;
    private ProjectResponse project;
    private TaskStatus status;
    private String description;
}
