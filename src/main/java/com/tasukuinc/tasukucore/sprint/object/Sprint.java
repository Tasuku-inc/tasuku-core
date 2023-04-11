package com.tasukuinc.tasukucore.sprint.object;

import com.tasukuinc.tasukucore.task.object.Task;
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
	//TODO убрать заглушку
	//private Project project;
	private List<Task> tasks;
}
