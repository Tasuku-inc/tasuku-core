package ru.mephi.tasuku.project.controller;

import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.service.object.Project;

public class ProjectDtoMapper {

    public static Project dtoToObject(ProjectResponse dto) {
        return Project.builder()
                .name(dto.getName())
                .headUser(dto.getHeadUser())
                .closed(false)
                .build();
    }

    public static ProjectResponse objectToDto(Project object) {
        return ProjectResponse.builder()
                .id(object.getId())
                .name(object.getName())
                .headUser(object.getHeadUser())
                .build();
    }
}
