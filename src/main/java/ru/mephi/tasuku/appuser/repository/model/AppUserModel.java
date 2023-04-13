package ru.mephi.tasuku.appuser.repository.model;

import ru.mephi.tasuku.binding.repository.model.ProjectUserRoleModel;
import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.mephi.tasuku.task.repository.model.TaskModel;

import java.util.List;

@Entity
@Table(name = "app_user")
@Data
@EqualsAndHashCode(exclude = {
		"projectUserRoles",
		"reportingTasks",
		"assignedTasks"
})
@ToString(exclude = {
		"projectUserRoles",
		"reportingTasks",
		"assignedTasks"
})
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
	@OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProjectUserRoleModel> projectUserRoles;
	@OneToMany(mappedBy = "reporter")
	private List<TaskModel> reportingTasks;
	@OneToMany(mappedBy = "assignee")
	private List<TaskModel> assignedTasks;
}
