package com.tasukuinc.tasukucore.domain;

import com.tasukuinc.tasukucore.domain.catalogue.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "role_name")
	private UserRole userRole;

	@OneToMany(mappedBy = "role")
	private Set<ProjectUserRole> projectUserRoles;
}
