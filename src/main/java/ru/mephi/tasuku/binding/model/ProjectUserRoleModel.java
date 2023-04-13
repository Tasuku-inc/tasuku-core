package ru.mephi.tasuku.binding.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.mephi.tasuku.appuser.model.UserRole;

@Entity
@Data
@Table(name = "project_user_role")
public class ProjectUserRoleModel {
	@EmbeddedId
	private ProjectUserRolePk pk;

	@Column
	@Enumerated (EnumType.STRING)
	private UserRole userRole;
}
