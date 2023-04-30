package ru.mephi.tasuku.binding.repository.model;

import lombok.*;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.mephi.tasuku.project.repository.model.ProjectModel;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectUserRolePk implements Serializable {
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectModel project;
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUserModel appUser;
}
