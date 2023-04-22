package ru.mephi.tasuku.appuser.controller;

import ru.mephi.tasuku.appuser.controller.dto.AppUserCreateRequest;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.appuser.controller.dto.AppUserUpdateRequest;
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

	public static AppUser createDtoToObject(AppUserCreateRequest dto) {
		return AppUser.builder()
				.email(dto.getEmail())
				.username(dto.getUsername())
				.systemRole(dto.getSystemRole())
				.password(dto.getPassword())
				.build();
	}

	public static AppUser updateDtoToObject(AppUserUpdateRequest dto) {
		return AppUser.builder()
				.email(dto.getEmail())
				.username(dto.getUsername())
				.password(dto.getPassword())
				.build();
	}
}
