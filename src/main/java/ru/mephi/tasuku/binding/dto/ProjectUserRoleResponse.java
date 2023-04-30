package ru.mephi.tasuku.binding.dto;

import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.repository.model.UserRole;
import ru.mephi.tasuku.project.controller.dto.ProjectResponse;

@Data
@Builder
public class ProjectUserRoleResponse {
	private ProjectResponse project;
	private AppUserResponse user;
	private UserRole userRole;
}
