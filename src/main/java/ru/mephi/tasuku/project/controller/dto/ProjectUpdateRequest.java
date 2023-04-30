package ru.mephi.tasuku.project.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectUpdateRequest {
	private long id;
	@NotBlank(message = "Project name can't be blank or empty")
	private String name;
	private Long headUserId;
	private Boolean closed;

	public Boolean isClosed() {
		return closed;
	}
}
