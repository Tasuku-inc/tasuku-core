package ru.mephi.tasuku.binding.object;

import ru.mephi.tasuku.appuser.model.UserRole;
import ru.mephi.tasuku.appuser.object.AppUser;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mephi.tasuku.project.service.object.Project;

@Data
@Builder
@ToString
public class ProjectUserRole {
	private Project project;
	private AppUser user;
	private UserRole userRole;

}
