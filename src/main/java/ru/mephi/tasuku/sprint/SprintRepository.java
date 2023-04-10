package ru.mephi.tasuku.sprint;

import ru.mephi.tasuku.sprint.model.SprintModel;
import org.springframework.data.repository.CrudRepository;

public interface SprintRepository extends CrudRepository<SprintModel, Long> {
}
