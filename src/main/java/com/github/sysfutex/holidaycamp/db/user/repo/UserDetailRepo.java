package com.github.sysfutex.holidaycamp.db.user.repo;

import com.github.sysfutex.holidaycamp.db.user.entity.UserDetailEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends ListCrudRepository<UserDetailEntity, Long> {
}
