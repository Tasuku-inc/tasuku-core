package ru.mephi.tasuku.appuser.dto;

import ru.mephi.tasuku.appuser.service.object.AppUser;

public class AppUserDtoMapper {

	public static AppUserResponse objectToDto(AppUser object) {
		return AppUserResponse.builder()
				.id(object.getId())
				.email(object.getEmail())
				.username(object.getUsername())
				.systemRole(object.getSystemRole())
				.build();
	}
}
