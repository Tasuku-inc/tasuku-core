package ru.mephi.tasuku.appuser.controller;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mephi.tasuku.appuser.controller.dto.AppUserCreateRequest;
import ru.mephi.tasuku.appuser.controller.dto.AppUserResponse;
import ru.mephi.tasuku.appuser.controller.dto.AppUserUpdateRequest;
import ru.mephi.tasuku.appuser.controller.dto.SystemRoleRequest;
import ru.mephi.tasuku.appuser.service.AppUserService;

@RestController
@RequiredArgsConstructor
@EnableMethodSecurity
@RequestMapping("/app-users")
public class AppUserController {
	private final AppUserService appUserService;
	private final AppUserDtoMapper appUserDtoMapper;

	@GetMapping("/")
	public List<AppUserResponse> getAll() {
		return appUserService.getAll().stream()
				.map(appUserDtoMapper::objectToDto)
				.toList();
	}

	@GetMapping("/{appUserId}")
	public AppUserResponse get(@PathVariable long appUserId) {
		return appUserDtoMapper.objectToDto(appUserService.getById(appUserId));
	}

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public long create(@Valid @RequestBody AppUserCreateRequest dto) {
		return appUserService.create(appUserDtoMapper.createDtoToObject(dto));
	}

	@PostMapping("/update")
	@PreAuthorize("@userConditionEvaluator.canUpdateAppUser(#dto.id) or hasRole('ADMIN')")
	public void update(@Valid @RequestBody AppUserUpdateRequest dto) {
		appUserService.update(appUserDtoMapper.updateDtoToObject(dto));
	}

	@DeleteMapping("/delete/{appUserId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(@PathVariable long appUserId) {
		appUserService.delete(appUserId);
	}

	@PostMapping("/update-system-role")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateSystemRole(@RequestBody SystemRoleRequest dto) {
		appUserService.updateSystemRole(dto.getAppUserId(), SystemRoleDtoMapper.dtoToObject(dto));
	}
}
