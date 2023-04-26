package ru.mephi.tasuku.appuser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.controller.dto.AppUserCreateRequest;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.appuser.controller.dto.AppUserUpdateRequest;
import ru.mephi.tasuku.appuser.service.object.AppUser;

@Component
@RequiredArgsConstructor
public class AppUserDtoMapper {
	private final PasswordEncoder passwordEncoder;

	public AppUserResponse objectToDto(AppUser object) {
		return AppUserResponse.builder()
				.id(object.getId())
				.email(object.getEmail())
				.username(object.getUsername())
				.systemRole(object.getSystemRole())
				.build();
	}

	public AppUser createDtoToObject(AppUserCreateRequest dto) {
		return AppUser.builder()
				.email(dto.getEmail())
				.username(dto.getUsername())
				.systemRole(dto.getSystemRole())
				.password(passwordEncoder.encode(dto.getPassword()))
				.build();
	}

	public AppUser updateDtoToObject(AppUserUpdateRequest dto) {
		return AppUser.builder()
				.email(dto.getEmail())
				.username(dto.getUsername())
				.password(passwordEncoder.encode(dto.getPassword()))
				.build();
	}
}
