package com.tasukuinc.tasukucore.sprint;

import com.tasukuinc.tasukucore.sprint.model.SprintModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends CrudRepository<SprintModel, Long> {
}
