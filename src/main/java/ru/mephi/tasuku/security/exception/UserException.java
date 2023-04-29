package ru.mephi.tasuku.security.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public abstract class UserException extends ResponseStatusException {
    protected UserException(HttpStatusCode status, UserErrorMessage formatError, Long userId) {
        super(status, String.format(formatError.getMessage(), userId));
    }
}
