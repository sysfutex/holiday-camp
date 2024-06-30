package com.github.sysfutex.holidaycamp.db.user.repo.custom;

import org.jetbrains.annotations.NotNull;

public interface CustomUserRepo {
    /**
     * Создание нового пользователя
     *
     * @param name         имя нового пользователя
     * @param phoneNumber  номер телеофна нового пользователя (используется как логин)
     * @param locationName название населенного пункта нового пользователя
     * @param passwordHash хэш пароля нового пользователя
     * @param roleNames    названия ролей нового пользователя
     * @return ID созданного пользователя
     */
    Long createUser(
            @NotNull String name,
            @NotNull String phoneNumber,
            @NotNull String locationName,
            @NotNull String passwordHash,
            @NotNull String[] roleNames
    );
}
