package ru.mephi.tasuku.project.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberRequest;
import ru.mephi.tasuku.binding.service.ProjectUserRoleService;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;
import ru.mephi.tasuku.project.repository.ProjectRepository;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.project.service.exception.ProjectByIdNotFoundException;
import ru.mephi.tasuku.project.service.exception.ProjectNameExistsException;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.sprint.SprintUtils;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectUserRoleService projectUserRoleService;

    public Project getById(long id) {
        ProjectModel model = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectByIdNotFoundException(id));
        return ProjectModelMapper.modelToObject(model);
    }

    public List<Project> getAll() {
        return projectRepository.findAll().stream()
                .map(ProjectModelMapper::modelToObject)
                .toList();
    }

    @Transactional
    public long createProject(Project project) {
        if (isProjectNameOccupied(project.getName())) {
            throw new ProjectNameExistsException(project.getName());
        }
        project.setSprints(List.of(SprintUtils.getActual()));
        ProjectModel model = ProjectModelMapper.objectToModel(project);
        return projectRepository.save(model).getId();
    }

    @Transactional
    public void updateProject(Project updatedProject) {
        Project project = getById(updatedProject.getId());
        String newName = updatedProject.getName();
        if (newName != null) {
            if (isProjectNameOccupied(newName)) {
                throw new ProjectNameExistsException(newName);
            }
            project.setName(newName);
        }
        Boolean newClosed = updatedProject.isClosed();
        if (newClosed != null) {
            project.setClosed(newClosed);
        }
        AppUser newHeadUser = updatedProject.getHeadUser();
        if (newHeadUser != null) {
            project.setHeadUser(newHeadUser);
        }
        ProjectModel model = ProjectModelMapper.objectToModel(project);
        projectRepository.save(model);
    }

    @Transactional
    public void deleteProject(long id) {
        ProjectModel model = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectByIdNotFoundException(id));
        projectRepository.delete(model);
    }

    public List<ProjectUserRole> getMembers(long projectId) {
        if (projectRepository.existsById(projectId)) {
            return projectUserRoleService.getAllByProjectId(projectId);
        } else {
            throw new ProjectByIdNotFoundException(projectId);
        }
    }

    public void addMember(long projectId, ProjectUserRole projectUserRole) {
        projectUserRole.setProject(getById(projectId));
        projectUserRoleService.addMemberToProject(projectUserRole);
    }

    public void deleteMember(long projectId, long appUserId) {
        if (projectRepository.existsById(projectId)) {
            projectUserRoleService.deleteMember(projectId, appUserId);
        } else {
            throw new ProjectByIdNotFoundException(projectId);
        }

    }

    public void updateMember(long projectId, ProjectUserRole projectUserRole) {
        projectUserRole.setProject(getById(projectId));
        projectUserRoleService.updateMember(projectUserRole);
    }

    public boolean isProjectNameOccupied(String name) {
        return projectRepository.existsByName(name);
    }
}
