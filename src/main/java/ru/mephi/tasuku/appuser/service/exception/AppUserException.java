package ru.mephi.tasuku.appuser.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AppUserException extends ResponseStatusException {
	protected AppUserException(HttpStatus status, AppUserErrorMessage formatError, String param) {
		super(status, String.format(formatError.getMessage(), param));
	}
}
