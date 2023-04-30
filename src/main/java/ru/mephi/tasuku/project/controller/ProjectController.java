package ru.mephi.tasuku.project.controller;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mephi.tasuku.project.controller.dto.ProjectCreateRequest;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.controller.dto.ProjectUpdateRequest;
import ru.mephi.tasuku.project.service.ProjectService;
import ru.mephi.tasuku.task.controller.TaskDtoMapper;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectDtoMapper projectDtoMapper;
    private final TaskDtoMapper taskDtoMapper;

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

    @PostMapping("{projectId}/update")
    public void updateProject(@PathVariable long projectId,
                              @Valid @RequestBody ProjectUpdateRequest dto) {
        projectService.updateProject(projectId,
                projectDtoMapper.updateDtoToObject(dto, projectId)
        );
    }

    @DeleteMapping("/{projectId}/delete")
    public void deleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
    }

    @GetMapping("/{projectId}/tasks")
    public List<TaskResponse> findAllProjectTasks(@PathVariable long projectId) {
        return projectService.getTasks(projectId).stream()
                .map(taskDtoMapper::objectToDto)
                .toList();
    }
}
