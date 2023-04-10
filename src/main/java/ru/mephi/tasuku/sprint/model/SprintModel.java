package ru.mephi.tasuku.sprint.model;

import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.task.model.TaskModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "sprint")
@Data
@EqualsAndHashCode
@ToString
public class SprintModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sprint_id")
	private long id;
	@Column
	private Date fromDate;
	@Column
	private Date toDate;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectModel project;
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private List<TaskModel> tasks;
}