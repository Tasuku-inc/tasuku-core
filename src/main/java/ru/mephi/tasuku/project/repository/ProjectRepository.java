package ru.mephi.tasuku.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.project.repository.model.ProjectModel;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
	boolean existsByName(String name);
}
