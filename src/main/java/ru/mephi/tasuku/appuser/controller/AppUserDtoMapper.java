package ru.mephi.tasuku.appuser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.controller.dto.AppUserCreateRequest;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.appuser.controller.dto.AppUserUpdateRequest;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.appuser.service.object.AppUser;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AppUserDtoMapper {
	private final PasswordEncoder passwordEncoder;
	private final AppUserService appUserService;

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

	public AppUser updateDtoToObject(AppUserUpdateRequest dto,
									 long appUserId) {
		AppUser currentUserState = appUserService.getById(appUserId);

		return AppUser.builder()
				.id(appUserId)
				.email(Optional.ofNullable(dto.getEmail())
						.orElse(currentUserState.getEmail()))
				.username(Optional.ofNullable(dto.getUsername())
						.orElse(currentUserState.getUsername()))
				.password(Optional.ofNullable(dto.getPassword())
						.map(passwordEncoder::encode)
						.orElse(currentUserState.getPassword()))
				.systemRole(currentUserState.getSystemRole())
				.build();
	}
}
