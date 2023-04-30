package ru.mephi.tasuku.binding.service.object;

import lombok.Builder;
import lombok.Data;
import ru.mephi.tasuku.appuser.service.object.AppUser;
import ru.mephi.tasuku.binding.repository.model.UserRole;
import ru.mephi.tasuku.project.service.object.Project;

@Data
@Builder
public class ProjectUserRole {
	private Project project;
	private AppUser user;
	private UserRole userRole;
}
