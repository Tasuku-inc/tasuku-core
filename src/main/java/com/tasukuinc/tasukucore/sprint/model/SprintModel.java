package com.tasukuinc.tasukucore.sprint.model;

import com.tasukuinc.tasukucore.project.model.ProjectModel;
import com.tasukuinc.tasukucore.task.model.TaskModel;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table (name = "sprint")
@Data
public class SprintModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "sprint_id")
	private long id;
	@Column
	private Date fromDate;
	@Column
	private Date toDate;
	@ManyToOne
	private ProjectModel project;
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private Set<TaskModel> tasks;
}
