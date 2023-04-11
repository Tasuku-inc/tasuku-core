package com.tasukuinc.tasukucore.appuser;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserModel, Long> {
	Optional<AppUserModel> findByUsername(String username);
}
