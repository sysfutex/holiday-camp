package com.github.sysfutex.holidaycamp.core.user.service.impl;

import com.github.sysfutex.holidaycamp.core.user.model.UserWithLocationModel;
import com.github.sysfutex.holidaycamp.common.user.converter.UserConverter;
import com.github.sysfutex.holidaycamp.core.user.service.UserService;
import com.github.sysfutex.holidaycamp.db.user.entity.UserWithLocationEntity;
import com.github.sysfutex.holidaycamp.db.user.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserConverter userConverter;

    @Override
    public Optional<UserWithLocationModel> getWithLocationByPhoneNumber(String phoneNumber) {
        UserWithLocationEntity dbUser = userRepo.findWithLocationByPhoneNumber(phoneNumber).orElse(null);
        return Optional.ofNullable(userConverter.entityWithLocationToModelWithLocation(dbUser));
    }
}
