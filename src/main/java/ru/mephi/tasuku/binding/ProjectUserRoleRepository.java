package ru.mephi.tasuku.binding;

import ru.mephi.tasuku.appuser.model.AppUserModel;
import ru.mephi.tasuku.binding.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.model.ProjectUserRolePk;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.project.repository.model.ProjectModel;

import java.util.List;

public interface ProjectUserRoleRepository extends
		JpaRepository<ProjectUserRoleModel, ProjectUserRolePk> {
	List<ProjectUserRoleModel> searchAllByPk_ProjectAndPk_User(ProjectModel project, AppUserModel user);
	List<ProjectUserRoleModel> searchAllByPk_Project_IdAndPk_User_Id (long projectId, long userId);
}
