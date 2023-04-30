package ru.mephi.tasuku.project.controller;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mephi.tasuku.binding.controller.ProjectUserRoleDtoMapper;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberRequest;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberResponse;
import ru.mephi.tasuku.binding.service.ProjectUserRoleService;
import ru.mephi.tasuku.project.controller.dto.ProjectCreateRequest;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.controller.dto.ProjectUpdateRequest;
import ru.mephi.tasuku.project.service.ProjectService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectUserRoleDtoMapper projectUserRoleDtoMapper;
    private final ProjectDtoMapper projectDtoMapper;



    @GetMapping("/{projectId}")
    public ProjectResponse getProject(@PathVariable long projectId) {
        return projectDtoMapper.objectToDto(projectService.getById(projectId));
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAll().stream()
                .map(projectDtoMapper::objectToDto)
                .toList();
    }

    @PostMapping("/create")
    public long createProject(@Valid @RequestBody ProjectCreateRequest projectDto) {
        return projectService.createProject(projectDtoMapper.createDtoToObject(projectDto));
    }

    @PostMapping("/update")
    public void updateProject(@Valid @RequestBody ProjectUpdateRequest dto) {
        projectService.updateProject(projectDtoMapper.updateDtoToObject(dto));
    }

    @DeleteMapping("/delete/{projectId}")
    public void deleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
    }

    @GetMapping("{projectId}/members/")
    public List<ProjectMemberResponse> getMembers(@PathVariable long projectId) {
        return projectService.getMembers(projectId).stream()
                .map(projectUserRoleDtoMapper::objectToProjectMemberResponse)
                .toList();
    }

    @PostMapping("{projectId}/members/add")
    public void addMember(@PathVariable long projectId,
                          @Valid @RequestBody ProjectMemberRequest dto) {
        projectService.addMember(
                projectId,
                projectUserRoleDtoMapper.projectMemberRequestToObject(dto)
        );
    }

    @PostMapping("{projectId}/members/update-member-role")
    public void updateMemberRole(@PathVariable long projectId,
                                 @Valid @RequestBody ProjectMemberRequest dto) {
        projectService.updateMember(
                projectId,
                projectUserRoleDtoMapper.projectMemberRequestToObject(dto)
        );
    }

    @DeleteMapping("{projectId}/members/delete/{appUserId}")
    public void deleteMember(@PathVariable long projectId,
                             @PathVariable long appUserId) {
        projectService.deleteMember(projectId, appUserId);
    }
}
