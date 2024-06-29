package com.github.sysfutex.holidaycamp.db.user.repo;

import com.github.sysfutex.holidaycamp.db.user.entity.RoleEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends ListCrudRepository<RoleEntity, Long> {
}
