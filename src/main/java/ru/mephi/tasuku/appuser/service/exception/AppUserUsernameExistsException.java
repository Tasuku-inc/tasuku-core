package ru.mephi.tasuku.appuser.service.exception;

import org.springframework.http.HttpStatus;

public class AppUserUsernameExistsException extends AppUserException{
	public AppUserUsernameExistsException(String param) {
		super(HttpStatus.BAD_REQUEST, AppUserErrorMessage.APP_USER_USERNAME_EXISTS, param);
	}
}
