package ru.mephi.tasuku.appuser.service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.service.ProjectUserRoleModelMapper;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.task.service.TaskModelMapper;

@Component
@RequiredArgsConstructor
public class AppUserModelMapper {

    private final ProjectUserRoleModelMapper projectUserRoleModelMapper;
    private final TaskModelMapper taskModelMapper;

    public AppUser modelToObject(AppUserModel model) {
        return AppUser.builder()
                .id(model.getId())
                .username(model.getUsername())
                .password(model.getPassword())
                .email(model.getEmail())
                .systemRole(model.getSystemRole())
                .projectUserRoles(model
                        .getProjectUserRoles()
                        .stream()
                        .map(projectUserRoleModelMapper::modelToObject)
                        .collect(Collectors.toList()))
                .assignedTasks(model
                        .getAssignedTasks()
                        .stream()
                        .map(taskModelMapper::modelToObject)
                        .collect(Collectors.toList()))
                .reportingTasks(model
                        .getReportingTasks()
                        .stream()
                        .map(taskModelMapper::modelToObject)
                        .collect(Collectors.toList()))
                .build();
    }

    public AppUserModel objectToModel(AppUser object) {
        return AppUserModel.builder()
                .id(object.getId())
                .username(object.getUsername())
                .password(object.getPassword())
                .email(object.getEmail())
                .systemRole(object.getSystemRole())
                .projectUserRoles(object
                        .getProjectUserRoles()
                        .stream()
                        .map(projectUserRoleModelMapper::objectToModel)
                        .collect(Collectors.toList()))
                .assignedTasks(object
                        .getAssignedTasks()
                        .stream()
                        .map(taskModelMapper::objectToModel)
                        .collect(Collectors.toList()))
                .reportingTasks(object
                        .getReportingTasks()
                        .stream()
                        .map(taskModelMapper::objectToModel)
                        .collect(Collectors.toList()))
                .build();
    }

}
