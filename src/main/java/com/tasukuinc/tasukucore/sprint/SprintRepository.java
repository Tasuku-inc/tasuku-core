package com.tasukuinc.tasukucore.sprint;

import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<SprintModel, Long> {
}
