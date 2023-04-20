package ru.mephi.tasuku.task.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public abstract class TaskException extends ResponseStatusException {
	protected TaskException(HttpStatus status, TaskErrorMessage formatError, String param) {
		super(status, String.format(formatError.getMessage(), param));
	}
}
