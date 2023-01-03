package com.levelup.library.interfaces;

import com.levelup.library.entities.UserEntity;

import java.util.Map;

public interface UserService {
    UserEntity getUser(Long id);

    Map<String, String> createUser(UserEntity newUser);

    Map<String, String> deleteUser(Long id);
}
