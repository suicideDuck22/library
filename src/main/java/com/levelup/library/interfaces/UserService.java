package com.levelup.library.interfaces;

import com.levelup.library.entities.UserEntity;

import java.util.Map;

public interface UserService {
    UserEntity getUser(Long id);

    void createUser(UserEntity newUser);

    void deleteUser(Long id);
}
