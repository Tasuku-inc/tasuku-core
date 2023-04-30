package ru.mephi.tasuku.project.service.exception;

import org.springframework.http.HttpStatus;

public class MemberByIdNotFoundException extends ProjectException {

	public MemberByIdNotFoundException(long appUserId) {
		super(HttpStatus.NOT_FOUND, ProjectErrorMessage.MEMBER_BY_ID_NOT_FOUND, Long.toString(appUserId));
	}
}
