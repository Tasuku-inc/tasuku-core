package com.tasukuinc.tasukucore.binding.object;

import com.tasukuinc.tasukucore.appuser.model.UserRole;
import com.tasukuinc.tasukucore.appuser.object.AppUser;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProjectUserRole {
	//TODO снять заглушку
	//private Project project;
	private AppUser user;
	private UserRole userRole;

}
