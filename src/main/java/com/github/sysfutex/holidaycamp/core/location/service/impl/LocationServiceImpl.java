package com.github.sysfutex.holidaycamp.core.location.service.impl;

import com.github.sysfutex.holidaycamp.core.location.model.LocationWithoutUsersModel;
import com.github.sysfutex.holidaycamp.common.location.converter.LocationConverter;
import com.github.sysfutex.holidaycamp.core.location.service.LocationService;
import com.github.sysfutex.holidaycamp.db.location.repo.LocationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepo locationRepo;
    private final LocationConverter locationConverter;

    @Override
    public List<LocationWithoutUsersModel> getAllWithoutUsers() {
        return locationConverter.entitiesWithoutUsersToModelsWithoutUsers(locationRepo.findAllWithoutUsers());
    }
}
