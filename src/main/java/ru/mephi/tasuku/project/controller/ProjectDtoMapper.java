package ru.mephi.tasuku.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.project.controller.dto.ProjectCreateRequest;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.controller.dto.ProjectUpdateRequest;
import ru.mephi.tasuku.project.service.ProjectService;
import ru.mephi.tasuku.project.service.object.Project;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProjectDtoMapper {
    private final AppUserService appUserService;
    private final ProjectService projectService;

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
                .closed(dto.getClosed())
                .build();
    }

    public Project updateDtoToObject(ProjectUpdateRequest dto, long projectId) {
        Project currentProjectState = projectService.getById(projectId);

        return Project.builder()
                .id(projectId)
                .name(
                        Optional.ofNullable(dto.getName())
                                .orElse(currentProjectState.getName()))
                .headUser(
                        Optional.ofNullable(dto.getHeadUserId())
                                .map(appUserService::getById)
                                .orElse(currentProjectState.getHeadUser()))
                .closed(
                        Optional.ofNullable(dto.getClosed())
                                .orElse(currentProjectState.isClosed()))
                .build();
    }
}
