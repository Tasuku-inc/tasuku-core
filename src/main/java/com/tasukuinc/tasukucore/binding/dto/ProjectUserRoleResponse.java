package com.tasukuinc.tasukucore.binding.dto;

import com.tasukuinc.tasukucore.appuser.dto.AppUserResponse;
import com.tasukuinc.tasukucore.appuser.model.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectUserRoleResponse {
	//TODO убрать заглушку
	//private ProjectResponse project;
	private AppUserResponse user;
	private UserRole userRole;
}
