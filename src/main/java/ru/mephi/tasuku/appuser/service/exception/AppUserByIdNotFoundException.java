package ru.mephi.tasuku.appuser.service.exception;

import org.springframework.http.HttpStatus;

public class AppUserByIdNotFoundException extends AppUserException{
	public AppUserByIdNotFoundException(long id) {
		super(HttpStatus.NOT_FOUND, AppUserErrorMessage.APP_USER_ID_NOT_FOUND, Long.toString(id));
	}
}
