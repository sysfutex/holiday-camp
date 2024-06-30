package com.github.sysfutex.holidaycamp.core.user.service.impl;

import com.github.sysfutex.holidaycamp.core.user.model.converter.UserDetailConverter;
import com.github.sysfutex.holidaycamp.core.user.service.UserDetailService;
import com.github.sysfutex.holidaycamp.db.user.repo.UserDetailRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepo userDetailRepo;
    private final UserDetailConverter userDetailConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailConverter.entityWithRolesToModelWithRoles(
                userDetailRepo
                        .findWithRolesByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Пользователь с номером телефона " + username + " не найден"))
        );
    }
}
