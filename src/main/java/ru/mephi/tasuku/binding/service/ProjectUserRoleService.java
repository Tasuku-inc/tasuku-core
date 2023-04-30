package ru.mephi.tasuku.binding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.tasuku.binding.repository.ProjectUserRoleRepository;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;
import ru.mephi.tasuku.project.service.exception.MemberByIdNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectUserRoleService {
	private final ProjectUserRoleRepository projectUserRoleRepository;

	public boolean existsByProjectIdAndUserId(long projectId, long userId) {
		return !projectUserRoleRepository
				.searchAllByProjectIdAndUserId(projectId, userId)
				.isEmpty();
	}

	public List<ProjectUserRole> getAllByProjectId(long projectId) {
		List<ProjectUserRoleModel> models = projectUserRoleRepository
				.findByPkProjectId(projectId);
		return models.stream()
				.map(ProjectUserRoleModelMapper::modelToObject)
				.toList();
	}

	public List<ProjectUserRole> getAllByAppUserId(long appUserId) {
		List<ProjectUserRoleModel> models = projectUserRoleRepository
				.findByPkUserId(appUserId);
		return models.stream()
				.map(ProjectUserRoleModelMapper::modelToObject)
				.toList();
	}

	@Transactional
	public void addMemberToProject(ProjectUserRole projectUserRole) {
		ProjectUserRoleModel model = ProjectUserRoleModelMapper
				.objectToModel(projectUserRole);
		projectUserRoleRepository.save(model);
	}

	@Transactional
	public void updateMember(ProjectUserRole projectUserRole) {
		long appUserId = projectUserRole.getUser().getId();
		long projectId = projectUserRole.getProject().getId();

		if (existsByProjectIdAndUserId(projectId, appUserId)) {
			ProjectUserRoleModel model = ProjectUserRoleModelMapper
					.objectToModel(projectUserRole);
			projectUserRoleRepository.save(model);
		} else {
			throw new MemberByIdNotFoundException(appUserId);
		}
	}

	@Transactional
	public void deleteMember(long projectId, long appUserId) {
		if (existsByProjectIdAndUserId(projectId, appUserId)) {
			projectUserRoleRepository
					.deleteMember(projectId, appUserId);
		} else {
			throw new MemberByIdNotFoundException(appUserId);
		}
	}
}
