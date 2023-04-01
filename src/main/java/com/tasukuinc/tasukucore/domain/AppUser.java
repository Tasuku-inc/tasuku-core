package com.tasukuinc.tasukucore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table (name = "app_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

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
	private Set<ProjectUserRole> projectUserRoleSet;
}
