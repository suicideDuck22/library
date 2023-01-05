package com.levelup.library.services;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.exceptions.EmailInUseException;
import com.levelup.library.interfaces.UserService;
import com.levelup.library.repositories.UserRepository;
import com.levelup.library.utils.Validator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

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
        Validator.EmailIsAvailable(newUser);
        Validator.validateCPF(newUser.getCpf());
        Validator.CPFAvailable(newUser);

        newUser.setPassword(DigestUtils.sha256Hex(newUser.getPassword()));
        userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userToDelete = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + id + " not founded.");
        }));

        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(UserEntity updatedUser) {
        Optional<UserEntity> optOldUser = Optional.ofNullable(userRepository.findById(updatedUser.getId()).orElseThrow(() -> {
            throw new NoSuchElementException("User with ID " + updatedUser.getId() + " not founded.");
        }));

        Validator.EmailIsAvailable(updatedUser);

        UserEntity oldUser = optOldUser.get();
        updatedUser.setPassword(DigestUtils.sha256Hex(updatedUser.getPassword()));

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<UserEntity> criteria = builder.createCriteriaUpdate(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        criteria.set("name", updatedUser.getName());
        criteria.set("nickname", updatedUser.getNickname());
        criteria.set("cpf", updatedUser.getCpf());
        criteria.set("birthDate", updatedUser.getBirthDate());
        criteria.set("phone", updatedUser.getPhone());
        criteria.set("email", updatedUser.getEmail());
        criteria.set("password", updatedUser.getPassword());

        criteria.where(builder.equal(root.get("id"), oldUser.getId()));
        entityManager.createQuery(criteria).executeUpdate();
    }
}
