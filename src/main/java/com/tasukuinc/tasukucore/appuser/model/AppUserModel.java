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
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<ProjectUserRoleModel> projectUserRoleSet;
}
