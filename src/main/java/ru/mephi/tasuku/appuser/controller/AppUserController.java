package ru.mephi.tasuku.appuser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;
import ru.mephi.tasuku.appuser.controller.dto.AppUserCreateRequest;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.appuser.controller.dto.AppUserUpdateRequest;
import ru.mephi.tasuku.appuser.controller.dto.SystemRoleRequest;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.security.UserConditionEvaluator;

import java.util.List;

@RestController
@RequestMapping("/appUsers")
@RequiredArgsConstructor
@EnableMethodSecurity
public class AppUserController {
	private final AppUserService appUserService;
	private final AppUserDtoMapper appUserDtoMapper;
	private final UserConditionEvaluator userConditionEvaluator;

	@GetMapping("/")
	public List<AppUserResponse> getAll() {
		return appUserService.getAll().stream()
				.map(appUserDtoMapper::objectToDto).toList();
	}

	@GetMapping("/{appUserId}")
	public AppUserResponse get(@PathVariable long appUserId) {
		return appUserDtoMapper.objectToDto(
				appUserService.getById(appUserId)
		);
	}

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public long create(@RequestBody AppUserCreateRequest dto) {
		return appUserService.create(
				appUserDtoMapper.createDtoToObject(dto)
		);
	}

	@PostMapping("/{appUserId}/update")
	@PreAuthorize("@userConditionEvaluator.canUpdateAppUser(#appUserId) or hasRole('ADMIN')")
	public void update(@PathVariable long appUserId,
					   @RequestBody AppUserUpdateRequest dto) {
		appUserService.update(
				appUserId,
				appUserDtoMapper.updateDtoToObject(dto)
		);
	}

	@DeleteMapping("/{appUserId}/delete")
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable long appUserId) {
		appUserService.delete(appUserId);
	}

	@PostMapping("/{appUserId}/updateSystemRole")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateSystemRole(@PathVariable long appUserId,
								 @RequestBody SystemRoleRequest dto) {
		appUserService.updateSystemRole(
				appUserId,
				SystemRoleDtoMapper.dtoToObject(dto)
		);
	}
}
