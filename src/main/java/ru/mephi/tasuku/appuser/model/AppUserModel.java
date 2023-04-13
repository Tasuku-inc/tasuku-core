package ru.mephi.tasuku.appuser.model;

import ru.mephi.tasuku.binding.model.ProjectUserRoleModel;
import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.mephi.tasuku.task.model.TaskModel;

import java.util.List;

@Entity
@Table(name = "app_user")
@Data
@EqualsAndHashCode
@ToString
public class AppUserModel {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Enumerated(EnumType.STRING)
	private SystemRole systemRole;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProjectUserRoleModel> projectUserRoles;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "reporter")
	private List<TaskModel> reportingTasks;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "assignee")
	private List<TaskModel> assignedTasks;
}
