package ru.mephi.tasuku.appuser.controller;

import ru.mephi.tasuku.appuser.controller.dto.SystemRoleRequest;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;

public class SystemRoleDtoMapper {
	public static SystemRole dtoToObject(SystemRoleRequest dto) {
		return dto.getSystemRole();
	}
}
