package com.tasukuinc.tasukucore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "task")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "task_id")
	private Long id;

	@Column (name = "name")
	private String name;

	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "reporter_id", referencedColumnName = "user_id")
	private User reporter;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "assignee_id", referencedColumnName = "user_id")
	private User assignee;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "status_id", referencedColumnName = "status_id")
	private Status status;

	@Column (name = "description")
	private String description;

	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "sprint_id", referencedColumnName = "sprint_id")
	private Sprint sprint;

}
