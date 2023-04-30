package ru.mephi.tasuku.binding.controller.dto;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.binding.repository.model.UserRole;

@Data
@Builder
public class ProjectMemberResponse {
	private Long appUserId;
	private String username;
	private UserRole userRole;
}
