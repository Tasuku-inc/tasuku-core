package com.tasukuinc.tasukucore.domain;

import com.tasukuinc.tasukucore.domain.catalogue.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "status")
@Data
public class Status {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "status_id")
	private long id;

	@Enumerated (value = EnumType.STRING)
	private TaskStatus taskStatus;
}
