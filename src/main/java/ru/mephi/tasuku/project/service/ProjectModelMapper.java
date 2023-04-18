package ru.mephi.tasuku.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.service.ProjectUserRoleModelMapper;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.service.SprintModelMapper;
import ru.mephi.tasuku.task.service.TaskModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectModelMapper {

    public static Project modelToObject(ProjectModel model) {
        return Project.builder()
                .id(model.getId())
                .name(model.getName())
                .closed(model.isClosed())
                .headUser(AppUserModelMapper.modelToObject(model.getHeadUser()))
                .projectUserRoles(List.of())
                .tasks(List.of())
                .sprints(List.of())
                .build();
    }

    public static ProjectModel objectToModel(Project object) {
        return ProjectModel.builder()
                .id(object.getId())
                .name(object.getName())
                .closed(object.isClosed())
                .headUser(AppUserModelMapper.objectToModel(object.getHeadUser()))
                .projectUserRoles(List.of())
                .tasks(List.of())
                .sprints(List.of())
                .build();
    }

}
