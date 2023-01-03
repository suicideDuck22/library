package com.levelup.library.controllers;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Greeting {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public List<UserEntity> greetUser(){
        return userRepository.findAll();
    }
}
