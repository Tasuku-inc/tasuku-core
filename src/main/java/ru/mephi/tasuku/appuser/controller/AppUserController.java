package ru.mephi.tasuku.appuser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.tasuku.appuser.controller.dto.AppUserCreateRequest;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.appuser.controller.dto.AppUserUpdateRequest;
import ru.mephi.tasuku.appuser.service.AppUserService;

import java.util.List;

@RestController
@RequestMapping("/appUsers")
@RequiredArgsConstructor
@EnableMethodSecurity
public class AppUserController {
	private final AppUserService appUserService;

	@GetMapping("/")
	public List<AppUserResponse> getAllAppUsers() {
		return appUserService.getAll()
				.stream().map(AppUserDtoMapper::objectToDto)
				.toList();
	}

	@GetMapping("/{appUserId}")
	public AppUserResponse getAppUser(@PathVariable long appUserId) {
		return AppUserDtoMapper.objectToDto(
				appUserService.getById(appUserId)
		);
	}

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public long createUser(@RequestBody AppUserCreateRequest dto) {
		return appUserService.createUser(
				AppUserDtoMapper.createDtoToObject(dto)
		);
	}

	@PostMapping("/{appUserId}/update")
	public void updateUser(@PathVariable long appUserId,
						   @RequestBody AppUserUpdateRequest dto) {
		appUserService.updateUser(
				appUserId,
				AppUserDtoMapper.updateDtoToObject(dto)
		);
	}

	@DeleteMapping("/{appUserId}/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable long appUserId) {
		appUserService.deleteUser(appUserId);
	}

	@PostMapping("/{appUserId}/updateSystemRole/{systemRole}")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateSystemRole(@PathVariable long appUserId,
								 @PathVariable String systemRole) {
		appUserService.updateSystemRole(appUserId, systemRole);
	}
}
