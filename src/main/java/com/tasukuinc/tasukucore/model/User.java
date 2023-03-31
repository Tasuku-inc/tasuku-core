package com.tasukuinc.tasukucore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

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

	@ManyToMany (mappedBy = "users")
	private List<Project> projects;

	//TODO: что делать с Role (она разная в зависимости от проекта)
	//мб сделать Map<Project, Role>. Аналогично в Project сделать Map<User, Role>

}
