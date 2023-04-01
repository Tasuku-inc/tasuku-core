package com.tasukuinc.tasukucore.domain;

import com.tasukuinc.tasukucore.domain.AppUser;
import com.tasukuinc.tasukucore.domain.Project;
import com.tasukuinc.tasukucore.domain.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "proj_user_role")
public class ProjectUserRole {
	@ManyToOne
	@Id
	private Project project;

	@ManyToOne
	@Id
	private AppUser user;

	@ManyToOne
	@Id
	private Role role;
}
