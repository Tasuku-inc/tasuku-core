package ru.mephi.tasuku.project.service;

import java.util.List;

import org.springframework.stereotype.Component;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;

@Component
public class ProjectModelMapper {

    public Project modelToObject(ProjectModel model) {
        return Project.builder()
                .id(model.getId())
                .name(model.getName())
                .closed(model.isClosed())
                .build();
    }

    public ProjectModel objectToModel(Project object) {
        return ProjectModel.builder()
                .id(object.getId())
                .name(object.getName())
                .closed(object.isClosed())
                //TODO пока что так
                .headUser(null)
                .projectUserRoles(List.of())
                .tasks(List.of())
                .sprints(List.of())

                .build();
    }

}
