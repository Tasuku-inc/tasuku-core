package ru.mephi.tasuku.appuser;

import ru.mephi.tasuku.appuser.model.AppUserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUserModel, Long> {
	Optional<AppUserModel> findByUsername(String username);
}
