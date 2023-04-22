package ru.mephi.tasuku.project.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mephi.tasuku.project.controller.dto.ProjectRequest;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.project.service.ProjectService;
import ru.mephi.tasuku.task.controller.dto.TaskDtoMapper;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import ru.mephi.tasuku.task.service.TaskService;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
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
    public long createProject(@RequestBody ProjectRequest projectDto) {
        return projectService.createProject(projectDtoMapper.requestDtoToObject(projectDto));
    }

    @DeleteMapping("/delete/{projectId}")
    public void deleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
    }

    @GetMapping("/{projectId}/tasks")
    public List<TaskResponse> findAllProjectTasks(@PathVariable long projectId) {
        return projectService.getTasks(projectId)
                .stream().map(TaskDtoMapper::objectToDto).toList();
    }
}
