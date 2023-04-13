package ru.mephi.tasuku.project.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.tasuku.project.repository.ProjectRepository;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.object.Project;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectModelMapper mapper;

    public Project getById(long id) {
        ProjectModel model = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        return mapper.modelToObject(model);
    }

    public List<Project> getAll() {
        return projectRepository.findAll().stream()
                .map(mapper::modelToObject)
                .toList();
    }

    @Transactional
    public long createProject(Project project) {
        ProjectModel model = mapper.objectToModel(project);
        return projectRepository.save(model).getId();
    }

    @Transactional
    public void deleteProject(long id) {
        ProjectModel model = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.delete(model);
    }
}
