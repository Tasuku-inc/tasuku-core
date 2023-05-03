package ru.mephi.tasuku.sprint.service.object;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.task.service.object.Task;

@Data
@Builder
@ToString
public class Sprint {
	private Long id;
	private LocalDate fromDate;
	private LocalDate toDate;
	private Project project;
	private List<Task> tasks;
}
