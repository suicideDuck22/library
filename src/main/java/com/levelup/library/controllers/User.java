package com.levelup.library.controllers;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.repositories.UserRepository;
import com.levelup.library.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/create")
    String createUserPage(){
        return "Rendering create user page";
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> createUser(@RequestBody @Valid UserEntity newUser){
        userService.createUser(newUser);
        Map<String, String> responseObject = new HashMap<>();

        responseObject.put("message", "User created successfully.");
        return new ResponseEntity(responseObject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        Map<String, String> responseObject = new HashMap<>();
        userService.deleteUser(id);

        responseObject.put("teste", "teste");
        return new ResponseEntity(responseObject, HttpStatus.OK);
    }
}
