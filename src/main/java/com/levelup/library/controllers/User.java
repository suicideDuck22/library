package com.levelup.library.controllers;

import com.levelup.library.entities.UserEntity;
import com.levelup.library.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/all")
    ResponseEntity<Map<String, Collection<UserEntity>>> getAllUsers(){
        Map<String, List<UserEntity>> users = new HashMap<>();
        users.put("users", userService.getAllUsers());
        return new ResponseEntity(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<UserEntity> getUser(@PathVariable Long id){
        UserEntity foundedUser = userService.getUser(id);
        return new ResponseEntity(foundedUser, HttpStatus.OK);
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> createUser(@RequestBody @Valid UserEntity newUser){
        Map<String, String> responseObject = new HashMap<>();
        userService.createUser(newUser);

        responseObject.put("message", "User created successfully.");
        return new ResponseEntity(responseObject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        Map<String, String> responseObject = new HashMap<>();
        userService.deleteUser(id);

        responseObject.put("message", "User with ID " + id + " has been deleted.");
        return new ResponseEntity(responseObject, HttpStatus.OK);
    }

    @PutMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Map<String, String>> updateUser(@RequestBody @Valid UserEntity updatedUser){
        Map<String, String> responseobject = new HashMap<>();
        userService.updateUser(updatedUser);
        responseobject.put("message", "User updated successfully.");
        return new ResponseEntity(responseobject, HttpStatus.OK);
    }
}
