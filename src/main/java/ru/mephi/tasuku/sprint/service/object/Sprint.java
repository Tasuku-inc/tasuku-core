package ru.mephi.tasuku.sprint.service.object;

import ru.mephi.tasuku.project.service.object.Project;
import ru.mephi.tasuku.task.service.object.Task;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@ToString
public class Sprint {
	private long id;
	private Date fromDate;
	private Date toDate;
	private Project project;
	private List<Task> tasks;
}
