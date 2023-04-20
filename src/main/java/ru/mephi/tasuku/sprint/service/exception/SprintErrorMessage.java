package ru.mephi.tasuku.sprint.service.exception;

public enum SprintErrorMessage {
	SPRINT_ID_NOT_FOUND("Sprint with 'sprintId' = '%s' not found.");
	private final String message;

	SprintErrorMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
