package ru.mephi.tasuku.security.exception;

import org.springframework.http.HttpStatus;

public class NotAllowedException extends UserException {
    public NotAllowedException(Long userId) {
        super(HttpStatus.METHOD_NOT_ALLOWED, UserErrorMessage.NOT_ALLOWED, userId);
    }
}
