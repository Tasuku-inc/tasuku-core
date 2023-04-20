package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;

public class ProjectIdNotFoundException extends ProjectException {

    public ProjectIdNotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, ProjectErrorMessage.PROJECT_ID_NOT_FOUND, Long.toString(id));
    }
}
