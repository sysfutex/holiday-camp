package com.github.sysfutex.holidaycamp.db.location.repo;

import com.github.sysfutex.holidaycamp.db.location.entity.LocationEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends ListCrudRepository<LocationEntity, Long> {
}
