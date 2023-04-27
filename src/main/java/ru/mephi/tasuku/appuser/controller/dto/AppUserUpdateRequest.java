package ru.mephi.tasuku.appuser.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AppUserUpdateRequest {
	private String username;
	@Email(message = "Invalid email form")
	private String email;
	@NotBlank
	private String password;
}
