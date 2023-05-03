package ru.mephi.tasuku.project.service;

import java.util.List;

import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.service.SprintModelMapper;

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
