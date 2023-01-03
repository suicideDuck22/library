package com.levelup.library.repositories;

import com.levelup.library.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM person WHERE email = :email AND password = :password", nativeQuery = true)
    UserEntity findByEmailAndPassword(String email, String password);

    @Query(value = "SELECT email FROM person WHERE email = :email", nativeQuery = true)
    String findByEmail(String email);
}
