package ru.mephi.tasuku.sprint.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class SprintException extends ResponseStatusException {
	protected SprintException(HttpStatus status, SprintErrorMessage formatError, String param) {
		super(status, String.format(formatError.getMessage(), param));
	}
}
