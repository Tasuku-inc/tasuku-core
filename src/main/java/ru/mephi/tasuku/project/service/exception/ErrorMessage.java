package ru.mephi.tasuku.project.service.exception;

public enum ErrorMessage {

    PROJECT_NOT_FOUND("Project with 'projectId' = '%s' not found."),
    PROJECT_EXISTS("Project with 'projectId' = '%s' already exists."),
    VALIDATION_ERROR("Validation error of the '%s' field");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
