package com.tasukuinc.tasukucore.binding;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.appuser.model.UserRole;
import com.tasukuinc.tasukucore.project.model.ProjectModel;
import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;

@Entity
@Data
@Table(name = "project_user_role")
public class ProjectUserRoleModel {
	@ManyToOne
	@Id
	private ProjectModel project;

	@ManyToOne
	@Id
	private AppUserModel user;

	@Enumerated (EnumType.STRING)
	private UserRole userRole;
}
