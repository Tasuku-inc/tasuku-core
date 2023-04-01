package com.tasukuinc.tasukucore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {


}
