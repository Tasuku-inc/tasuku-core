package com.tasukuinc.tasukucore.project.model;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.binding.ProjectTaskModel;
import com.tasukuinc.tasukucore.binding.ProjectUserRoleModel;
import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table (name = "project")
@Data
public class ProjectModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "project_id")
	private long id;

	@Column (name = "name")
	private String name;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "head_id", referencedColumnName = "user_id")
	private AppUserModel headUser;

	@Column (name = "is_closed")
	private boolean isClosed;

	@OneToMany(mappedBy = "project")
	private Set<ProjectUserRoleModel> projectUserRoles;

	@OneToMany(mappedBy = "project")
	private Set<ProjectTaskModel> projectTasks;

	@OneToMany(mappedBy = "project")
	private Set<SprintModel> sprints;
}
