package ru.mephi.tasuku.task.controller.dto;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.task.repository.model.TaskStatus;

@Data
@Builder
public class TaskResponse {
    private long taskId;
    private String name;
    private AppUserResponse reporter;
    private AppUserResponse assignee;
    private TaskStatus status;
    private long projectId;
    private long sprintId;
    private String description;
}
