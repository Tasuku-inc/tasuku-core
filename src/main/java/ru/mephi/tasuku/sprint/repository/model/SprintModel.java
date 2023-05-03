package ru.mephi.tasuku.sprint.repository.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import ru.mephi.tasuku.task.repository.model.TaskModel;

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
	private Long id;
	@Column
	private LocalDate fromDate;
	@Column
	private LocalDate toDate;
	@ManyToOne
	@JoinColumn(name = "project_id")
	private ProjectModel project;
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
	private List<TaskModel> tasks;
}
