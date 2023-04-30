package ru.mephi.tasuku.task.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.controller.AppUserDtoMapper;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.project.service.ProjectService;
import ru.mephi.tasuku.sprint.SprintUtils;
import ru.mephi.tasuku.task.controller.dto.TaskCreateRequest;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import ru.mephi.tasuku.task.controller.dto.TaskUpdateRequest;
import ru.mephi.tasuku.task.repository.model.TaskStatus;
import ru.mephi.tasuku.task.service.object.Task;

@Component
@RequiredArgsConstructor
public class TaskDtoMapper {
    private final AppUserService appUserService;
    private final ProjectService projectService;
    private final AppUserDtoMapper appUserDtoMapper;

    public TaskResponse objectToDto(Task object) {
        return TaskResponse.builder()
                .taskId(object.getId())
                .name(object.getName())
                .assignee(appUserDtoMapper.objectToDto(object.getAssignee()))
                .reporter(appUserDtoMapper.objectToDto(object.getReporter()))
                .description(object.getDescription())
                .status(object.getStatus())
                .projectId(object.getProject().getId())
                .sprintId(object.getSprint().getId())
                .build();
    }

    public Task createDtoToObject(TaskCreateRequest dto) {
        return Task.builder()
                .name(dto.getName())
                .assignee(appUserService.getById(dto.getAssigneeId()))
                .status(TaskStatus.OPENED)
                .description(dto.getDescription())
                .sprint(SprintUtils.getActual())
                .project(projectService.getById(dto.getProjectId()))
                .build();
    }

    public Task updateDtoToObject(TaskUpdateRequest dto) {
        return Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .assignee(Optional.ofNullable(dto.getAssigneeId())
                        .map(appUserService::getById)
                        .orElse(null)
                )
                .reporter(Optional.ofNullable(dto.getReporterId())
                        .map(appUserService::getById)
                        .orElse(null)
                )
                .status(dto.getStatus())
                .description(dto.getDescription())
                .build();
    }
}
