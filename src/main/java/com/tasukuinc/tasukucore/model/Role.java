package com.tasukuinc.tasukucore.model;

import com.tasukuinc.tasukucore.model.catalogue.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "role_name")
	private UserRole userRole;
}
