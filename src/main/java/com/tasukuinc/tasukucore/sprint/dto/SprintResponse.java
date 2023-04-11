package com.tasukuinc.tasukucore.sprint.dto;

import com.tasukuinc.tasukucore.task.dto.TaskResponse;
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
	//TODO: снять заглушку
	//private ProjectResponse project;
	private List<TaskResponse> tasks;
}
