package ru.mephi.tasuku.project.service;

import java.util.List;

import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;

public class ProjectModelMapper {

    public static Project modelToObject(ProjectModel model){
        return Project.builder()
                .id(model.getId())
                .name(model.getName())
                .headUser(model.getHeadUser())
                .closed(model.isClosed())
                .build();
    }

    public static ProjectModel objectToModel(Project object){
        return ProjectModel.builder()
                .id(object.getId())
                .name(object.getName())
                .headUser(object.getHeadUser())
                .closed(object.isClosed())
                //TODO пока что так
                .projectUserRoles(List.of())
                .taskModels(List.of())
                .sprints(List.of())

                .build();
    }

}
