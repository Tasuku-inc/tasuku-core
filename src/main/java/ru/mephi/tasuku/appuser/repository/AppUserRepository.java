package ru.mephi.tasuku.appuser.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;

public interface AppUserRepository extends JpaRepository<AppUserModel, Long> {
	Optional<AppUserModel> findByUsername(String username);

}
