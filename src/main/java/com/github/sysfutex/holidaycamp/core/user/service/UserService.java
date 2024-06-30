package com.github.sysfutex.holidaycamp.core.user.service;

import com.github.sysfutex.holidaycamp.core.user.model.UserWithLocationModel;

import java.util.Optional;

public interface UserService {
    Optional<UserWithLocationModel> getWithLocationByPhoneNumber(String phoneNumber);
}
