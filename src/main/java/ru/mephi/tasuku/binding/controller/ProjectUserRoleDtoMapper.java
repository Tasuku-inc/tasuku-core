package ru.mephi.tasuku.binding.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberRequest;
import ru.mephi.tasuku.binding.controller.dto.ProjectMemberResponse;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;

@Component
@RequiredArgsConstructor
public class ProjectUserRoleDtoMapper {
	private final AppUserService appUserService;

	public ProjectUserRole projectMemberRequestToObject(ProjectMemberRequest dto) {
		return ProjectUserRole.builder()
				.user(appUserService.getById(dto.getAppUserId()))
				.userRole(dto.getUserRole())
				.build();
	}

	public ProjectMemberResponse objectToProjectMemberResponse(ProjectUserRole object){
		AppUser appUser = object.getUser();
		return ProjectMemberResponse.builder()
				.appUserId(appUser.getId())
				.username(appUser.getUsername())
				.userRole(object.getUserRole())
				.build();
	}
}
