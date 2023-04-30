package ru.mephi.tasuku.task.repository.model;

import lombok.*;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "task")
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
