package ru.mephi.tasuku.appuser.service.exception;

public enum AppUserErrorMessage {
	APP_USER_ID_NOT_FOUND("User with 'userId' = '%s' not found.");
	private final String message;

	AppUserErrorMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
