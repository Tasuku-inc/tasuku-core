package com.tasukuinc.tasukucore.binding;

import com.tasukuinc.tasukucore.project.model.ProjectModel;
import com.tasukuinc.tasukucore.task.model.TaskModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "project_task")
@Data
public class ProjectTaskModel {
	@ManyToOne
	@Id
	private ProjectModel project;

	@ManyToOne
	@Id
	private TaskModel task;
}
