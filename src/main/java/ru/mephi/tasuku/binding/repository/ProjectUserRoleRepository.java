package ru.mephi.tasuku.binding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import ru.mephi.tasuku.binding.repository.model.ProjectUserRolePk;

import java.util.List;

public interface ProjectUserRoleRepository extends JpaRepository<ProjectUserRoleModel, ProjectUserRolePk> {

	List<ProjectUserRoleModel> searchAllByPk_ProjectIdAndPk_AppUserId(long projectId, long appUserId);

	default List<ProjectUserRoleModel> searchAllByProjectIdAndAppUserId(long projectId, long appUserId) {
		return searchAllByPk_ProjectIdAndPk_AppUserId(projectId, appUserId);
	}

	List<ProjectUserRoleModel> findByPkProjectId(long projectId);

	List<ProjectUserRoleModel> findByPkAppUserId(long appUserId);

	@Modifying
	@Query("""
		delete from ProjectUserRoleModel pur
			where pur.pk.project.id=:projectId
			and pur.pk.appUser.id =:appUserId""")
	void deleteMember(@Param("projectId") long projectId, @Param("appUserId") long appUserId);
}
