package com.tasukuinc.tasukucore.project.model;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.binding.ProjectUserRoleModel;
import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import com.tasukuinc.tasukucore.task.model.TaskModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table (name = "project")
@Data
@EqualsAndHashCode
@ToString
public class ProjectModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "project_id")
	private long id;
	@Column
	private String name;
	@ManyToOne
	@JoinColumn(name = "head_user_id")
	private AppUserModel headUser;
	@Column
	private boolean closed;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "pk.project", cascade = CascadeType.ALL)
	private List<ProjectUserRoleModel> projectUserRoles;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<TaskModel> taskModels;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<SprintModel> sprints;
}
