package com.tasukuinc.tasukucore.project;

import com.tasukuinc.tasukucore.project.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
}
