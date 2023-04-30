package ru.mephi.tasuku.binding.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.mephi.tasuku.binding.repository.model.UserRole;

@Data
public class ProjectMemberRequest {
	@NotNull(message = "UserId can't be null")
	private Long appUserId;
	@NotNull(message = "UserRole can't be null")
	private UserRole userRole;
}
