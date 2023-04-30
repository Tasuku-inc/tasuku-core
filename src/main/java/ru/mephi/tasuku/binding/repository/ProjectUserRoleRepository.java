package ru.mephi.tasuku.binding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRolePk;

import java.util.List;

public interface ProjectUserRoleRepository extends JpaRepository<ProjectUserRoleModel, ProjectUserRolePk> {

	List<ProjectUserRoleModel> searchAllByPk_Project_IdAndPk_User_Id(long projectId, long userId);

	default List<ProjectUserRoleModel> searchAllByProjectIdAndUserId(long projectId, long userId) {
		return searchAllByPk_Project_IdAndPk_User_Id(projectId, userId);
	}
}
