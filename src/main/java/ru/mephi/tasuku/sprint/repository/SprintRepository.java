package ru.mephi.tasuku.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.sprint.repository.model.SprintModel;

import java.util.List;

public interface SprintRepository extends JpaRepository<SprintModel, Long> {

	List<SprintModel> findByProjectIdOrderByFromDate(long projectId);
}
