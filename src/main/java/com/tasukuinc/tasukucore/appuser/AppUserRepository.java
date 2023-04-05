package com.tasukuinc.tasukucore.appuser;

import com.tasukuinc.tasukucore.appuser.model.AppUserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUserModel, Long> {

}
