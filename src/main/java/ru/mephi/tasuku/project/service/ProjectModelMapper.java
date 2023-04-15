package ru.mephi.tasuku.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.binding.service.ProjectUserRoleModelMapper;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.service.SprintModelMapper;
import ru.mephi.tasuku.task.service.TaskModelMapper;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectModelMapper {
    private final AppUserModelMapper appUserModelMapper;
    private final ProjectUserRoleModelMapper projectUserRoleModelMapper;
    private final TaskModelMapper taskModelMapper;
    private final SprintModelMapper sprintModelMapper;

    public Project modelToObject(ProjectModel model) {
        return Project.builder()
                .id(model.getId())
                .name(model.getName())
                .closed(model.isClosed())
                .headUser(appUserModelMapper.modelToObject(model.getHeadUser()))
                .projectUserRoles(model
                        .getProjectUserRoles()
                        .stream()
                        .map(projectUserRoleModelMapper::modelToObject)
                        .collect(Collectors.toList()))
                .tasks(model
                        .getTasks()
                        .stream()
                        .map(taskModelMapper::modelToObject)
                        .collect(Collectors.toList()))
                .sprints(model
                        .getSprints()
                        .stream()
                        .map(sprintModelMapper::modelToObject)
                        .collect(Collectors.toList()))
                .build();
    }

    public ProjectModel objectToModel(Project object) {
        return ProjectModel.builder()
                .id(object.getId())
                .name(object.getName())
                .closed(object.isClosed())
                .headUser(appUserModelMapper.objectToModel(object.getHeadUser()))
                .projectUserRoles(object
                        .getProjectUserRoles()
                        .stream()
                        .map(projectUserRoleModelMapper::objectToModel)
                        .collect(Collectors.toList()))
                .tasks(object
                        .getTasks()
                        .stream()
                        .map(taskModelMapper::objectToModel)
                        .collect(Collectors.toList()))
                .sprints(object
                        .getSprints()
                        .stream()
                        .map(sprintModelMapper::objectToModel)
                        .collect(Collectors.toList()))
                .build();
    }

}
