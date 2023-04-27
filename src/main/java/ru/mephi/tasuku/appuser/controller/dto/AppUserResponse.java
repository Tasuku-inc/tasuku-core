package ru.mephi.tasuku.appuser.controller.dto;

import ru.mephi.tasuku.appuser.repository.model.SystemRole;
import ru.mephi.tasuku.binding.dto.ProjectUserRoleResponse;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppUserResponse {
	private Long id;
	private String username;
	private String email;
	private SystemRole systemRole;
}