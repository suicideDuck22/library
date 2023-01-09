package com.levelup.library.interfaces;

import com.levelup.library.entities.UserEntity;

import java.util.Collection;
import java.util.Map;

public interface UserService {
    Collection<UserEntity > getAllUsers();

    UserEntity getUser(Long id);

    void createUser(UserEntity newUser);

    void deleteUser(Long id);

    void updateUser(Long id, UserEntity updatedUser);
}
