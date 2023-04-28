package ru.mephi.tasuku.project.service.exception;

public enum ProjectErrorMessage {

    PROJECT_BY_ID_NOT_FOUND("Project with 'projectId' = '%s' not found."),
    PROJECT_ID_EXISTS("Project with 'projectId' = '%s' already exists."),
    PROJECT_NAME_EXISTS("Project with 'name' = '%s' already exists."),
    VALIDATION_ERROR("Validation error of the '%s' field");

    private final String message;

    ProjectErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
