package ru.mephi.tasuku.project.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.tasuku.project.repository.ProjectRepository;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.exception.ProjectIdNotFoundException;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.task.controller.dto.TaskDtoMapper;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import ru.mephi.tasuku.task.service.TaskService;
import ru.mephi.tasuku.task.service.object.Task;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskService taskService;

    public Project getById(long id) {
        ProjectModel model = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectIdNotFoundException(id));
        return ProjectModelMapper.modelToObject(model);
    }

    public List<Project> findAll() {
        return projectRepository.findAll().stream()
                .map(ProjectModelMapper::modelToObject)
                .toList();
    }

    public List<Task> getTasks(long projectId) {
        return taskService.findAllInProject(projectId);
    }

    @Transactional
    public long createProject(Project project) {
        ProjectModel model = ProjectModelMapper.objectToModel(project);
        return projectRepository.save(model).getId();
    }

    @Transactional
    public void deleteProject(long id) {
        ProjectModel model = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectIdNotFoundException(id));
        projectRepository.delete(model);
    }
}
