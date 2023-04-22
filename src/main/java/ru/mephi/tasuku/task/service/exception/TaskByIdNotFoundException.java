package ru.mephi.tasuku.task.service.exception;

import org.springframework.http.HttpStatus;

public class TaskByIdNotFoundException extends  TaskException{
	public TaskByIdNotFoundException(long id) {
		super(HttpStatus.NOT_FOUND, TaskErrorMessage.TASK_BY_ID_NOT_FOUND, Long.toString(id));
	}
}
