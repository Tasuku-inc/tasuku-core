package ru.mephi.tasuku.project.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.service.ProjectService;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{projectId}")
    public ProjectResponse getProject(@PathVariable long projectId) {
        return ProjectDtoMapper.objectToDto(projectService.getById(projectId));
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAll().stream()
                .map(ProjectDtoMapper::objectToDto)
                .toList();
    }

    @PostMapping
    public long createProject(@RequestBody ProjectResponse projectResponse) {
        return projectService.createProject(ProjectDtoMapper.dtoToObject(projectResponse));
    }

    @DeleteMapping("/delete/{projectId}")
    public void deleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
    }
}
