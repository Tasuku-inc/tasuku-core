package ru.mephi.tasuku.sprint.repository.model;

import lombok.*;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.task.repository.model.TaskModel;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "sprint")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"tasks"})
@ToString(exclude = {"tasks"})
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
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private List<TaskModel> tasks;
}
