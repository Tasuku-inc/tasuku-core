package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;

public class ProjectNameExistsException extends ProjectException{
	public ProjectNameExistsException(String name) {
		super(HttpStatus.BAD_REQUEST, ProjectErrorMessage.PROJECT_NAME_EXISTS, name);
	}
}
