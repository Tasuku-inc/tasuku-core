package ru.mephi.tasuku.binding;

import ru.mephi.tasuku.appuser.model.AppUserModel;
import ru.mephi.tasuku.project.repository.model.ProjectModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ProjectUserRolePk implements Serializable {
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectModel project;
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUserModel user;
}
