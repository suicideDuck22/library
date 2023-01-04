package com.levelup.library.services;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.exceptions.EmailInUseException;
import com.levelup.library.interfaces.UserService;
import com.levelup.library.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getUser(Long id) {
        return null;
    }

    public void createUser(UserEntity newUser) {
        Optional<String> searchEmailResponse = Optional.ofNullable(userRepository.findByEmail(newUser.getEmail()));
        if(searchEmailResponse.isPresent()){
            throw new EmailInUseException();
        }

        newUser.setPassword(DigestUtils.sha256Hex(newUser.getPassword()));

        System.out.println("Email não está em uso");
//        userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userToDelete = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));
    }
}
