package ru.mephi.tasuku.sprint.service.exception;

import org.springframework.http.HttpStatus;

public class SprintIdNotFoundException extends SprintException{
	public SprintIdNotFoundException(long id) {
		super(HttpStatus.NOT_FOUND, SprintErrorMessage.SPRINT_ID_NOT_FOUND, Long.toString(id));
	}
}
