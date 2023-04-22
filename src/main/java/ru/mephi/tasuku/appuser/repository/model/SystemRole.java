package ru.mephi.tasuku.appuser.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SystemRole {
	ADMIN("ADMIN"),
	USER("USER");

	@Getter
	private final String name;
}
