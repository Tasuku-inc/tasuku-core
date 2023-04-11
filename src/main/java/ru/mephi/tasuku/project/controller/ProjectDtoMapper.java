package ru.mephi.tasuku.project.controller;

import org.springframework.stereotype.Component;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.service.object.Project;

@Component
public class ProjectDtoMapper {

    public Project dtoToObject(ProjectResponse dto) {
        return Project.builder()
                .name(dto.getName())
                .closed(false)
                .build();
    }

    public ProjectResponse objectToDto(Project object) {
        return ProjectResponse.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }
}
