package ru.mephi.tasuku.task.service.exception;

import org.springframework.http.HttpStatus;

public class TaskNameExistsException extends TaskException {
	public TaskNameExistsException(String name) {
		super(HttpStatus.BAD_REQUEST, TaskErrorMessage.TASK_NAME_EXISTS, name);
	}
}
