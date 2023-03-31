package com.tasukuinc.tasukucore.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "sprint")
public class Sprint {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "sprint_id")
	private long id;

	@Column (name = "from_date")
	private Date fromDate;

	@Column (name = "to_date")
	private Date toDate;

	@ManyToOne
	private Project project;
}
