package ru.mephi.tasuku.project.service;

import org.springframework.http.HttpStatus;
import ru.mephi.tasuku.project.service.exception.ErrorMessage;
import ru.mephi.tasuku.project.service.exception.ProjectException;

public class ProjectExistsException extends ProjectException {

    protected ProjectExistsException(long id) {
        super(HttpStatus.CONFLICT, ErrorMessage.PROJECT_EXISTS, Long.toString(id));
    }
}
