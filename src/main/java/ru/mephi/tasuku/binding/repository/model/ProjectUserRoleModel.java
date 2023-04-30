package ru.mephi.tasuku.binding.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mephi.tasuku.appuser.repository.model.UserRole;

@Entity
@Table(name = "project_user_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectUserRoleModel {
	@EmbeddedId
	private ProjectUserRolePk pk;
	@Column
	@Enumerated (EnumType.STRING)
	private UserRole userRole;
}
