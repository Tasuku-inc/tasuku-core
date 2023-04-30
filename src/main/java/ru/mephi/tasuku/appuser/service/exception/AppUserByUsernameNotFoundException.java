package ru.mephi.tasuku.appuser.service.exception;

import org.springframework.http.HttpStatus;

public class AppUserByUsernameNotFoundException extends AppUserException{
	public AppUserByUsernameNotFoundException(String username) {
		super(HttpStatus.NOT_FOUND, AppUserErrorMessage.APP_USER_USERNAME_NOT_FOUND, username);
	}
}
