package ru.mephi.tasuku.sprint;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.sprint.model.SprintModel;

public interface SprintRepository extends JpaRepository<SprintModel, Long> {
}
