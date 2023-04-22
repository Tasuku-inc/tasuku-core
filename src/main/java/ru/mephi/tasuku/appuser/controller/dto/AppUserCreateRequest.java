package ru.mephi.tasuku.appuser.controller.dto;

import lombok.Data;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;

@Data
public class AppUserCreateRequest {
	private String username;
	private String email;
	private SystemRole systemRole;
	private String password;
}
