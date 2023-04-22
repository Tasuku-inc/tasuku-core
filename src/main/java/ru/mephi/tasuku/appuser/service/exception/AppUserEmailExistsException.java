package ru.mephi.tasuku.appuser.service.exception;

import org.springframework.http.HttpStatus;

public class AppUserEmailExistsException extends AppUserException{
	public AppUserEmailExistsException(String email) {
		super(HttpStatus.BAD_REQUEST, AppUserErrorMessage.APP_USER_EMAIL_EXISTS, email);
	}
}
