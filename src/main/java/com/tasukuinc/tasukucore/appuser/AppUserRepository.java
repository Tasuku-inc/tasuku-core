package com.tasukuinc.tasukucore.appuser;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import com.tasukuinc.tasukucore.project.model.ProjectModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUserModel, Long> {
	Optional<AppUserModel> findByUsername(String username);
}
