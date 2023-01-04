package com.levelup.library.services;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.interfaces.UserService;
import com.levelup.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getUser(Long id) {
        return null;
    }

    public Map<String, String> createUser(UserEntity newUser) {
        return null;
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userToDelete = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));
    }
}
