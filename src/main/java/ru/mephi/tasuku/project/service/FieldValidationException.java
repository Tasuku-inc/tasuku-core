package ru.mephi.tasuku.project.service;

import org.springframework.http.HttpStatus;
import ru.mephi.tasuku.project.service.exception.ErrorMessage;
import ru.mephi.tasuku.project.service.exception.ProjectException;

public class FieldValidationException extends ProjectException {
    public FieldValidationException(String field) {
        super(HttpStatus.BAD_REQUEST, ErrorMessage.VALIDATION_ERROR, field);
    }
}
