package com.github.sysfutex.holidaycamp.db.user.repo;

import com.github.sysfutex.holidaycamp.db.user.entity.UserEntity;
import com.github.sysfutex.holidaycamp.db.user.repo.custom.CustomUserRepo;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<UserEntity, Long>, CustomUserRepo {
}
