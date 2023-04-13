package ru.mephi.tasuku.task.model;

import ru.mephi.tasuku.appuser.model.AppUserModel;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.sprint.model.SprintModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "task")
@Data
public class TaskModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "task_id")
	private long id;
	@Column
	private String name;
	@ManyToOne
	private AppUserModel reporter;
	@ManyToOne
	private AppUserModel assignee;
	@Enumerated (value = EnumType.STRING)
	private TaskStatus status;
	@Column
	private String description;
	@ManyToOne
	@JoinColumn (name = "sprint_id")
	private SprintModel sprint;
	@ManyToOne
	@JoinColumn (name = "project_id")
	private ProjectModel project;
}
