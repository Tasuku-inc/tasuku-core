package ru.mephi.tasuku.binding.repository.model;

import jakarta.persistence.*;
import lombok.*;
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
