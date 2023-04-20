package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;

public class ProjectIdExistsException extends ProjectException {

    public ProjectIdExistsException(long id) {
        super(HttpStatus.BAD_REQUEST, ProjectErrorMessage.PROJECT_ID_EXISTS, Long.toString(id));
    }
}
