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

	public static ProjectUserRole modelToObject(ProjectUserRoleModel model) {
		return ProjectUserRole.builder()
				.project(ProjectModelMapper.modelToObject(model.getPk().getProject()))
				.user(AppUserModelMapper.modelToObject(model.getPk().getUser()))
				.userRole(model.getUserRole())
				.build();
	}

	public static ProjectUserRoleModel objectToModel(ProjectUserRole object) {
		return ProjectUserRoleModel.builder()
				.pk(ProjectUserRolePk.builder()
						.user(AppUserModelMapper.objectToModel(object.getUser()))
						.project(ProjectModelMapper.objectToModel(object.getProject()))
						.build())
				.userRole(object.getUserRole())
				.build();
	}
}
