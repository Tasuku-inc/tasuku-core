package ru.mephi.tasuku.appuser.controller.dto;

import lombok.Data;

@Data
public class AppUserUpdateRequest {
	private String username;
	private String email;
	private String password;
}
