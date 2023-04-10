package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class ProjectException extends ResponseStatusException {

    protected ProjectException(HttpStatus status, ErrorMessage formatError, String id) {
        super(status, String.format(formatError.getMessage(), id));
    }
}
