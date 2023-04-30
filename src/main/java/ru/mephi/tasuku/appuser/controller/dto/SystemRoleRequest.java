package ru.mephi.tasuku.appuser.controller.dto;

import lombok.Data;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;

@Data
public class SystemRoleRequest {
	private long appUserId;
	private SystemRole systemRole;
}
