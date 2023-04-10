package ru.mephi.tasuku.binding;

import ru.mephi.tasuku.appuser.model.AppUserModel;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectUserRoleRepository extends
		CrudRepository<ProjectUserRoleModel, ProjectUserRolePk> {
	List<ProjectUserRoleModel> searchAllByPk_ProjectAndPk_User(ProjectModel project, AppUserModel user);
}
