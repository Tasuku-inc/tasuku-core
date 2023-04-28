package ru.mephi.tasuku.appuser.service.exception;

public enum AppUserErrorMessage {
	APP_USER_ID_NOT_FOUND("User with 'userId' = '%s' not found."),
	APP_USER_USERNAME_EXISTS("User with 'username' = '%s' already exists"),
	APP_USER_EMAIL_EXISTS("User with 'email' = '%s' already exists");
	private final String message;

	AppUserErrorMessage(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
