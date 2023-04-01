package com.tasukuinc.tasukucore.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "proj_task")
public class ProjectTask {
	@ManyToOne
	@Id
	private Project project;

	@ManyToOne
	@Id
	private Task task;
}
