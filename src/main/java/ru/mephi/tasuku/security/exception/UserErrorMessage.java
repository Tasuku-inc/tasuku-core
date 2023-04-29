package ru.mephi.tasuku.security.exception;

public enum UserErrorMessage {
    NOT_ALLOWED("Operation for 'userId' = '%d' not allowed.");

    private final String message;

    UserErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}