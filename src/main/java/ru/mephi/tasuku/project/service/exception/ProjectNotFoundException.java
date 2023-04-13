package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;
import ru.mephi.tasuku.project.service.exception.ErrorMessage;
import ru.mephi.tasuku.project.service.exception.ProjectException;

public class ProjectNotFoundException extends ProjectException {

    public ProjectNotFoundException(long id) {
        super(HttpStatus.NOT_FOUND, ErrorMessage.PROJECT_NOT_FOUND, Long.toString(id));
    }
}
