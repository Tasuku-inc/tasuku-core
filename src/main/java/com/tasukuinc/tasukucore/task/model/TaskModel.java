package com.tasukuinc.tasukucore.task.model;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.project.model.ProjectModel;
import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table (name = "task")
@Data
public class TaskModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "task_id")
	private Long id;
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
	private SprintModel sprint;
	@ManyToOne
	private ProjectModel project;
}
