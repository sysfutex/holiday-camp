package com.github.sysfutex.holidaycamp.db.location.repo;

import com.github.sysfutex.holidaycamp.db.location.entity.LocationEntity;
import com.github.sysfutex.holidaycamp.db.location.entity.custom.LocationWithoutUsersEntity;
import com.github.sysfutex.holidaycamp.db.location.entity.custom.mapper.LocationWithoutUsersRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends ListCrudRepository<LocationEntity, Long> {
    @Query(
            value = "SELECT l.id AS locations_id, l.name AS locations_name FROM locations l",
            rowMapperClass = LocationWithoutUsersRowMapper.class
    )
    List<LocationWithoutUsersEntity> findAllWithoutUsers();
}
