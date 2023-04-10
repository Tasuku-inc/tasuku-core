package com.tasukuinc.tasukucore.binding;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.project.model.ProjectModel;
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
