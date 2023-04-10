package com.tasukuinc.tasukucore.binding;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.project.model.ProjectModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectUserRoleRepository extends
		CrudRepository<ProjectUserRoleModel, ProjectUserRolePk> {
	List<ProjectUserRoleModel> searchAllByPk_ProjectAndPk_User(ProjectModel project, AppUserModel user);
}
