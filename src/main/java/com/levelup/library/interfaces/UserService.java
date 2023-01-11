package com.levelup.library.interfaces;

import com.levelup.library.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {
    Collection<UserEntity> find(Long userId);

    void create(UserEntity newUser);

    void delete(Long id);

    void update(Long id, UserEntity updatedUser);
}
