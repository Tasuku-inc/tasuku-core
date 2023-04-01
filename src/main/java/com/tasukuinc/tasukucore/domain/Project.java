package com.tasukuinc.tasukucore.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table (name = "proj")
@Data
public class Project {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "proj_id")
	private long id;

	@Column (name = "name")
	private String name;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "head_id", referencedColumnName = "user_id")
	private AppUser headUser;

	@Column (name = "is_closed")
	private boolean isClosed;

	@OneToMany(mappedBy = "project")
	private Set<ProjectUserRole> projectUserRoles;

	@OneToMany(mappedBy = "project")
	private Set<ProjectTask> projectTasks;
}
