package ru.mephi.tasuku.appuser.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AppUserUpdateRequest {
	private long id;
	@NotBlank(message = "Username can't be blank or empty")
	@NotNull(message = "Username can't be null")
	private String username;
	@Email(message = "Invalid email form")
	private String email;
	@NotBlank(message = "Password can't be blank or empty")
	@NotNull(message = "Password can't be null")
	private String password;
}
