package ru.mephi.tasuku.appuser.controller.dto;

import lombok.Data;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;

@Data
public class SystemRoleRequest {
	SystemRole systemRole;
}
