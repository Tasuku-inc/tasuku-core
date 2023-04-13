package ru.mephi.tasuku.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;

public interface SprintRepository extends JpaRepository<SprintModel, Long> {
}
