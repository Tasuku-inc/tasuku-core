package com.tasukuinc.tasukucore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table (name = "task")
@Data
public class Task {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "task_id")
	private Long id;

	@Column (name = "name")
	private String name;

	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "reporter_id", referencedColumnName = "user_id")
	private AppUser reporter;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "assignee_id", referencedColumnName = "user_id")
	private AppUser assignee;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "status_id", referencedColumnName = "status_id")
	private Status status;

	@Column (name = "description")
	private String description;

	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "sprint_id", referencedColumnName = "sprint_id")
	private Sprint sprint;

	@OneToMany (mappedBy = "task")
	private Set<ProjectTask> projectTasks;

}
