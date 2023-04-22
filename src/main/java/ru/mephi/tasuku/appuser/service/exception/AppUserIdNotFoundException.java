package ru.mephi.tasuku.appuser.service.exception;

import org.springframework.http.HttpStatus;

public class AppUserIdNotFoundException extends AppUserException{
	public AppUserIdNotFoundException(long id) {
		super(HttpStatus.NOT_FOUND, AppUserErrorMessage.APP_USER_ID_NOT_FOUND, Long.toString(id));
	}
}
