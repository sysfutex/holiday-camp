package com.github.sysfutex.holidaycamp.core.location.service;

import com.github.sysfutex.holidaycamp.core.location.model.LocationWithoutUsersModel;

import java.util.List;

public interface LocationService {
    List<LocationWithoutUsersModel> getAllWithoutUsers();
}
