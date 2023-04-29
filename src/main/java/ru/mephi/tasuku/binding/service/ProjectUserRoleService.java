package ru.mephi.tasuku.binding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.binding.repository.ProjectUserRoleRepository;

@Service
@RequiredArgsConstructor
public class ProjectUserRoleService {
	private final ProjectUserRoleRepository projectUserRoleRepository;

	public boolean existsByProjectIdAndUserId(long projectId, long userId) {
		return !projectUserRoleRepository.searchAllByProjectIdAndUserId(projectId, userId)
				.isEmpty();
	}
}
