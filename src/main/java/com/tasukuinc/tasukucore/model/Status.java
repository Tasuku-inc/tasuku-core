package com.tasukuinc.tasukucore.model;

import com.tasukuinc.tasukucore.model.catalogue.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "status")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Status {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "status_id")
	private long id;

	@Enumerated (value = EnumType.STRING)
	private TaskStatus taskStatus;
}
