package com.levelup.library.repositories;

import com.levelup.library.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    UserRepository findById(long id);


}
