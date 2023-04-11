package com.tasukuinc.tasukucore.binding.model;

import com.tasukuinc.tasukucore.appuser.model.UserRole;
import jakarta.persistence.*;
import lombok.Data;

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
