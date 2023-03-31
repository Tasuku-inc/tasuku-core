package com.tasukuinc.tasukucore.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "proj")

public class Project {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "proj_id")
	private long id;

	@Column (name = "name")
	private String name;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "head_id", referencedColumnName = "user_id")
	private User headUser;

	@Column (name = "is_closed")
	private boolean isClosed;

	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable (name = "proj_user_role",
			joinColumns = @JoinColumn(name = "proj_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

}
