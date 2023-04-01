package com.tasukuinc.tasukucore.appuser.model;

import com.tasukuinc.tasukucore.binding.ProjectUserRoleModel;
import jakarta.persistence.*;

import lombok.Data;

import java.util.Set;

@Entity
@Table (name = "app_user")
@Data
public class AppUserModel {
	@Id
	@Column (name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "user_name")
	private String username;

	@Column (name = "email")
	private String email;

	@Column (name = "password")
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<ProjectUserRoleModel> projectUserRoleSet;
}
