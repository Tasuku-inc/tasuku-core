package ru.mephi.tasuku.task.service.exception;

public enum TaskErrorMessage {
	TASK_ID_NOT_FOUND("Task with 'taskId' = '%s' not found."),
	TASK_ID_EXISTS("Task with 'taskId' = '%s' already exists."),
	TASK_NAME_EXISTS("Task with 'name' = '%s' already exists."),
	VALIDATION_ERROR("Validation error of the '%s' field");

	private final String message;

	TaskErrorMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
