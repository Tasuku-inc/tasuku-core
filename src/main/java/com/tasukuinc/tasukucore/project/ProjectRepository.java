package com.tasukuinc.tasukucore.project;

import com.tasukuinc.tasukucore.project.model.ProjectModel;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<ProjectModel, Long> {
}
