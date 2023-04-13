package ru.mephi.tasuku.sprint.dto;

import ru.mephi.tasuku.project.controller.dto.ProjectResponse;
import ru.mephi.tasuku.task.controller.dto.TaskResponse;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class SprintResponse {
	private long id;
	private Date fromDate;
	private Date toDate;
	private ProjectResponse project;
	private List<TaskResponse> tasks;
}
