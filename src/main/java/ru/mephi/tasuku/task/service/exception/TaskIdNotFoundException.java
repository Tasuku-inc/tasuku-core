package ru.mephi.tasuku.task.service.exception;

import org.springframework.http.HttpStatus;

public class TaskIdNotFoundException extends  TaskException{
	public TaskIdNotFoundException(long id) {
		super(HttpStatus.NOT_FOUND, TaskErrorMessage.TASK_ID_NOT_FOUND, Long.toString(id));
	}
}
