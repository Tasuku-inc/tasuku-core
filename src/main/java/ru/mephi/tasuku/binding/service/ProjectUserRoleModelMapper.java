package ru.mephi.tasuku.binding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRolePk;
import ru.mephi.tasuku.binding.service.object.ProjectUserRole;
import ru.mephi.tasuku.project.service.ProjectModelMapper;

@Component
public class ProjectUserRoleModelMapper {
	@Lazy
	@Autowired
	private ProjectModelMapper projectModelMapper;
	@Lazy
	@Autowired
	private AppUserModelMapper appUserModelMapper;
	public ProjectUserRole modelToObject(ProjectUserRoleModel model) {
		return ProjectUserRole.builder()
				.project(projectModelMapper.modelToObject(model.getPk().getProject()))
				.user(appUserModelMapper.modelToObject(model.getPk().getUser()))
				.userRole(model.getUserRole())
				.build();
	}

	public ProjectUserRoleModel objectToModel(ProjectUserRole object) {
		return ProjectUserRoleModel.builder()
				.pk(ProjectUserRolePk.builder()
						.user(appUserModelMapper.objectToModel(object.getUser()))
						.project(projectModelMapper.objectToModel(object.getProject()))
						.build())
				.userRole(object.getUserRole())
				.build();
	}
}
