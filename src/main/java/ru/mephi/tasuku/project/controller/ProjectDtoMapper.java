package ru.mephi.tasuku.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.project.controller.dto.ProjectRequest;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.service.object.Project;

@Component
@RequiredArgsConstructor
public class ProjectDtoMapper {
    private final AppUserService appUserService;

    public Project dtoToObject(ProjectResponse dto) {
        return Project.builder()
                .name(dto.getName())
                .closed(dto.isClosed())
                .build();
    }

    public ProjectResponse objectToDto(Project object) {
        return ProjectResponse.builder()
                .id(object.getId())
                .name(object.getName())
                .headUsername(object.getHeadUser().getUsername())
                .build();
    }

    public Project requestDtoToObject(ProjectRequest dto) {
        return Project.builder()
                .name(dto.getName())
                .headUser(appUserService.findById(dto.getHeadUserId()))
                .closed(dto.getClosed())
                .build();
    }
}
