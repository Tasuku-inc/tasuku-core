package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;

public class ProjectByIdNotFoundException extends ProjectException {

    public ProjectByIdNotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, ProjectErrorMessage.PROJECT_BY_ID_NOT_FOUND, Long.toString(id));
    }
}
