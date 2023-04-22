package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;

public class FieldValidationException extends ProjectException {
    public FieldValidationException(String field) {
        super(HttpStatus.BAD_REQUEST, ProjectErrorMessage.VALIDATION_ERROR, field);
    }
}
