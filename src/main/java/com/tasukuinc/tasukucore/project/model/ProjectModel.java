package com.tasukuinc.tasukucore.project.model;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.binding.ProjectUserRoleModel;
import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import com.tasukuinc.tasukucore.task.model.TaskModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Table (name = "project")
@Data
public class ProjectModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "project_id")
	private long id;
	@Column
	private String name;
	@ManyToOne
	private AppUserModel headUser;
	@Column
	private boolean closed;
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<ProjectUserRoleModel> projectUserRoles;
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<TaskModel> taskModels;
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Set<SprintModel> sprints;
}
