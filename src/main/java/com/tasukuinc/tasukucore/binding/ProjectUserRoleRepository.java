package com.tasukuinc.tasukucore.binding;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.binding.model.ProjectUserRoleModel;
import com.tasukuinc.tasukucore.binding.model.ProjectUserRolePk;
import com.tasukuinc.tasukucore.project.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectUserRoleRepository extends
		JpaRepository<ProjectUserRoleModel, ProjectUserRolePk> {
	List<ProjectUserRoleModel> searchAllByPk_ProjectAndPk_User(ProjectModel project, AppUserModel user);
	List<ProjectUserRoleModel> searchAllByPk_Project_IdAndPk_User_Id (long projectId, long userId);
}
