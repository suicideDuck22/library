package com.levelup.library.utils;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.exceptions.EmailInUseException;
import com.levelup.library.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validator {
    private static UserRepository staticUserRepository;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initStaticUserRepository(){
        staticUserRepository = userRepository;
    }

    public static void EmailIsAvailable(UserEntity user) {
        Optional.ofNullable(staticUserRepository.findByEmail(user.getEmail())).map(UserEntity::getId).ifPresent(foundedId -> {
            if (!foundedId.equals(user.getId())){
                throw new EmailInUseException();
            }
        });
    }
}
