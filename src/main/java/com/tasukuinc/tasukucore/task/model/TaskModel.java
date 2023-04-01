package com.tasukuinc.tasukucore.task.model;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.binding.ProjectTaskModel;
import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table (name = "task")
@Data
public class TaskModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "task_id")
	private Long id;

	@Column (name = "name")
	private String name;

	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "reporter_id", referencedColumnName = "user_id")
	private AppUserModel reporter;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "assignee_id", referencedColumnName = "user_id")
	private AppUserModel assignee;

	@Enumerated (value = EnumType.STRING)
	private TaskStatus status;

	@Column (name = "description")
	private String description;

	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "sprint_id", referencedColumnName = "sprint_id")
	private SprintModel sprint;

	@OneToMany (mappedBy = "task")
	private Set<ProjectTaskModel> projectTasks;
}
