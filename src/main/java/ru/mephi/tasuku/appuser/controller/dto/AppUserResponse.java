package ru.mephi.tasuku.appuser.controller.dto;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;

@Data
@Builder
public class AppUserResponse {
	private Long id;
	private String username;
	private String email;
	private SystemRole systemRole;
}
