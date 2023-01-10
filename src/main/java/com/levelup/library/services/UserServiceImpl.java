package com.levelup.library.services;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.interfaces.UserService;
import com.levelup.library.repositories.UserRepository;
import com.levelup.library.utils.Validator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users;
    }
    public UserEntity getUser(Long id) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        return user.get();
    }

    public void createUser(UserEntity newUser) {
        validateUserCPFEmailBirthDate(newUser);

        newUser.setPassword(this.passwordEncrypt(newUser.getPassword()));
        userRepository.save(newUser);
    }

    private String passwordEncrypt(String rawPassword){
        return DigestUtils.sha256Hex(rawPassword);
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userToDelete = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, UserEntity updatedUser) {
        Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        validateUserCPFEmailBirthDate(updatedUser);

        updatedUser.setPassword(DigestUtils.sha256Hex(updatedUser.getPassword()));

        entityManager.merge(updatedUser);
    }

    public void validateUserCPFEmailBirthDate(UserEntity user){
        Validator.EmailIsAvailable(user);
        Validator.validateCPF(user.getCpf());
        Validator.CPFAvailable(user);
        Validator.IsAValidDate(user.getBirthDate());
    }
}
