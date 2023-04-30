package ru.mephi.tasuku.binding.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberRequest;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberResponse;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;

@Component
@RequiredArgsConstructor
public class ProjectUserRoleDtoMapper {
	private final AppUserService appUserService;

	public ProjectUserRole projectMemberRequestToObject(ProjectMemberRequest dto) {
		return ProjectUserRole.builder()
				.appUser(appUserService.getById(dto.getAppUserId()))
				.userRole(dto.getUserRole())
				.build();
	}

	public ProjectMemberResponse objectToProjectMemberResponse(ProjectUserRole object){
		return ProjectMemberResponse.builder()
				.appUserId(object.getAppUser().getId())
				.username(object.getAppUser().getUsername())
				.userRole(object.getUserRole())
				.build();
	}
}
