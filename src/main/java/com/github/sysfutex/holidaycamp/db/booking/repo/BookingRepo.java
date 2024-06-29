package com.github.sysfutex.holidaycamp.db.booking.repo;

import com.github.sysfutex.holidaycamp.db.booking.entity.BookingEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends ListCrudRepository<BookingEntity, Long> {
}
