package ru.mephi.tasuku.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.project.controller.dto.ProjectCreateRequest;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.controller.dto.ProjectUpdateRequest;
import ru.mephi.tasuku.project.service.object.Project;

@Component
@RequiredArgsConstructor
public class ProjectDtoMapper {
    private final AppUserService appUserService;

    public ProjectResponse objectToDto(Project object) {
        return ProjectResponse.builder()
                .id(object.getId())
                .name(object.getName())
                .headUsername(object.getHeadUser().getUsername())
                .build();
    }

    public Project createDtoToObject(ProjectCreateRequest dto) {
        return Project.builder()
                .name(dto.getName())
                .headUser(appUserService.getById(dto.getHeadUserId()))
                .closed(false)
                .build();
    }

    public Project updateDtoToObject(ProjectUpdateRequest dto) {
        return Project.builder()
                .id(dto.getId())
                .name(dto.getName())
                .headUser(appUserService.getById(dto.getHeadUserId()))
                .closed(dto.isClosed())
                .build();
    }
}
